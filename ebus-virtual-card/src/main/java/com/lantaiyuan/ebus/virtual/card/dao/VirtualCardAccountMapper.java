package com.lantaiyuan.ebus.virtual.card.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccount;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountQueryModel;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountSign;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardInfoQueryModel;
@Mapper
public interface VirtualCardAccountMapper extends BaseDAO<VirtualCardAccount, VirtualCardAccountQueryModel>{

	VirtualCardInfoQueryModel queryByUserAndCity(@Param("userId")int userId, @Param("cityCode")String cityCode);

	String queryMaxCardNoByCity(String  cityCode);
	
	VirtualCardAccount queryByCardNo(@Param("cardNo")String cardNo);

	int updateBalanceByCardNo(VirtualCardAccount virtualCardAccount);

	int updateSignByCardNo(VirtualCardAccountSign virtualCardAccountSign);
}