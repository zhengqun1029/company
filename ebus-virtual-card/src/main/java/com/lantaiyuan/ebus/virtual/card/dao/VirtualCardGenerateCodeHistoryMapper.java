package com.lantaiyuan.ebus.virtual.card.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardGenerateCodeHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardGenerateCodeHistoryQueryModel;
@Mapper
public interface VirtualCardGenerateCodeHistoryMapper extends BaseDAO<VirtualCardGenerateCodeHistory, VirtualCardGenerateCodeHistoryQueryModel>{

}