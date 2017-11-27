package com.lantaiyuan.ebus.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.model.OnBusInfo;
import com.lantaiyuan.ebus.model.OnBusInfoQueryModel;
/**
 * 
  * @ClassName: OnBusInfoMapper
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2016年12月23日 下午5:18:28
 */
@Mapper
public interface OnBusInfoMapper extends BaseDAO<OnBusInfo, OnBusInfoQueryModel>{
    
}