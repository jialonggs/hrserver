package org.sang.service;

import org.sang.bean.StorageBill;
import org.sang.mapper.OrderMapper;
import org.sang.mapper.StorageBillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    StorageBillMapper storageBillMapper;

    public Boolean checkStorageStatus(String kuFangRmark, Integer storageStatus, Long orderId){

        int i = orderMapper.checkKuFang(kuFangRmark, storageStatus, orderId);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public Boolean addBill(StorageBill storageBill){
        int i =storageBillMapper.addBill(storageBill);
        int k = orderMapper.updateStorageStatus(2, storageBill.getOrderId());
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}
