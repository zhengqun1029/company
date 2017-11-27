package com.lantaiyuan.ebus.virtual.card.service.impl;

import com.lantaiyuan.ebus.virtual.card.dao.VirtualCardAccountHistoryMapper;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountHistory;
import com.lantaiyuan.ebus.virtual.card.model.VirtualCardAccountHistoryQueryModel;
import com.lantaiyuan.ebus.virtual.card.service.VirtualCardAccountHistoryServiceI;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 虚拟公交卡用户账户交易记录
 *
 * @author yangyang
 * @date 2017/8/8 10:10
 * @email kekecany@163.com
 */
@Service("virtualCardAccountHistoryService")
public class VirtualCardAccountHistoryServiceImpl extends BaseService<VirtualCardAccountHistory, VirtualCardAccountHistoryQueryModel>
        implements VirtualCardAccountHistoryServiceI {

    @Autowired
    private VirtualCardAccountHistoryMapper virtualCardAccountHistoryMapper;

    @Override
    public BaseDAO<VirtualCardAccountHistory, VirtualCardAccountHistoryQueryModel> getDao() {
        return virtualCardAccountHistoryMapper;
    }

}
