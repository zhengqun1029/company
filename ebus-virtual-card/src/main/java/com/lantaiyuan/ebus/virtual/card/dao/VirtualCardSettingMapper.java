package com.lantaiyuan.ebus.virtual.card.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSetting;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardSettingQueryModel;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface VirtualCardSettingMapper extends BaseDAO<VirtualCardSetting, VirtualCardSettingQueryModel>{

    int countCardNumByCityCode(@Param("cityCode") String cityCode);

    BigDecimal sumCityBalance(@Param("id") Long id);

    List<VirtualCardSetting> findCityCardByPage(VirtualCardSettingQueryModel virtualCardSettingQueryModel);
	
	VirtualCardSetting queryByCity(String cityCode);
}