package com.lantaiyuan.ebus.virtual.card.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSign;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSignQueryModel;
@Mapper
public interface VirtualCardAccountSignMapper extends BaseDAO<VirtualCardAccountSign, VirtualCardAccountSignQueryModel>{
		String querySignByUserAndCardNo(@Param("userId")String userId, @Param("cardNo")String cardNo);
}