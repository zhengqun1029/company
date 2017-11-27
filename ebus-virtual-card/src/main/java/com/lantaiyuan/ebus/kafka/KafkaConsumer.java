package com.lantaiyuan.ebus.kafka;

import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Resource;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.service.BaseStationServiceI;
import com.lantaiyuan.ebus.service.JpushServiceI;
import com.lantaiyuan.ebus.service.MyTrailServiceI;
import com.lantaiyuan.ebus.service.NoticeHistoryServiceI;
import com.lantaiyuan.ebus.service.OnBusInfoServiceI;
import com.lantaiyuan.ebus.service.TaskTimerServiceI;
import com.lantaiyuan.ebus.util.SnowflakeIdWorker;
import com.lantaiyuan.ebus.util.Tools;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSwipeHistory;
import com.lantaiyuan.ebus.virtual.card.model.enummodel.VirtualCardRecordHeaderTypeEnum;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardSwipeHistoryServiceI;

/**
 * 消费者
 * @author yangyang
 */
@Component
public class KafkaConsumer {
	@Resource
	private BaseStationServiceI baseStationService;
	@Resource
	private OnBusInfoServiceI onBusInfoService;
	@Resource
	private TaskTimerServiceI taskTimerService;
	@Resource
	private NoticeHistoryServiceI noticeHistoryService;
	@Resource
	private JpushServiceI jpushServiceImpl;
	@Resource
	private MyTrailServiceI myTrailService;
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	private VirtualCardSwipeHistoryServiceI virtualCardSwipeHistoryService;
	
	
	public KafkaConsumer(VirtualCardSwipeHistoryServiceI virtualCardSwipeHistoryService) {
		super();
		this.virtualCardSwipeHistoryService = virtualCardSwipeHistoryService;
	}
	
	private SnowflakeIdWorker  snowflakeIdWorker = new SnowflakeIdWorker(0,0);
	
	/**
	 * 消费刷卡记录
	 * @author YvanTan
	 * @param msg
	 */
	@KafkaListener(topics = "${kafka.topic.virtulCardCodeTopic}")
	public void listenVirtualCode(ConsumerRecord<Integer, String> msg) {
		String record = msg.value();
		JSONObject swipeCardJson = JSONObject.parseObject(record);
		JSONObject header = swipeCardJson.getJSONObject("header");
		if (header.getString("msg_id").equals("458759")) {
			JSONObject body = swipeCardJson.getJSONObject("body");
			JSONObject gps_data = body.getJSONObject("gps_data");
			VirtualCardSwipeHistory swipeRecordInDb = virtualCardSwipeHistoryService.queryExistRecord(body.getString("v_card_code")
					, body.getIntValue("up_time"), body.getString("line_id"), body.getString("vehicle_id"));
			//判断刷卡数据是否重刷
			if (Objects.isNull(swipeRecordInDb)) {
				String swipeId = VirtualCardRecordHeaderTypeEnum.SWIPE_CARD.getRecordType()+snowflakeIdWorker.nextId();
				VirtualCardSwipeHistory swipeHistory = new VirtualCardSwipeHistory();
				swipeHistory.setSwipeId(swipeId);
				swipeHistory.setCardNo(body.getString("v_card_code"));
				swipeHistory.setLongitude(new BigDecimal(gps_data.getString("lon")));
				swipeHistory.setLatitude(new BigDecimal(gps_data.getString("lat")));
				// TODO 刷卡时间
				swipeHistory.setSwipeUtcTime(body.getIntValue("up_time"));
				swipeHistory.setStationId(body.getIntValue("bus_station_code"));
				swipeHistory.setStationNo(body.getIntValue("bus_station_no") + 1);
				swipeHistory.setRouteId(body.getString("line_id"));
				swipeHistory.setRouteDirection(body.getBoolean("ondirection_flag"));
				swipeHistory.setOnBusFlag(body.getString("onbus_flag"));
				swipeHistory.setDiverId(body.getInteger("driver_id"));
				swipeHistory.setVehicleId(body.getString("vehicle_id"));
				swipeHistory.setBusSeq(body.getString("bus_req"));
				swipeHistory.setVerifyCode(body.getString("verify_code"));
				if (virtualCardSwipeHistoryService.insertSelective(swipeHistory) == 1) {
				//  写json到kafka 告诉终端  header、body和请求要对应
				//	{"header":{"msg_flag":4,"msg_sn":9,"msg_id（固定值）":0x080007},"body":{"dev_id":123,"result（固定值）":0xE000}}
					kafkaTemplate.setDefaultTopic("LTY_TB_Resp");
					kafkaTemplate.sendDefault("{\"header\":{\"msg_flag\":"+header.getString("msg_flag")+",\"msg_sn\":"+header.getString("msg_sn")+",\"msg_id\":524295},\"body\":{\"dev_id\":"+body.getString("dev_id")+",\"result\":57344}}");
				}
			}
		}
	}
}