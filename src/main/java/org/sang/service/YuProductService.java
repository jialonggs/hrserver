package org.sang.service;

import org.sang.bean.YuProduct;
import org.sang.mapper.YuProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YuProductService {
    @Autowired
    YuProductMapper yuProductMapper;

    public int addYuProduct(List<YuProduct> yuProducts){
        return yuProductMapper.addYuProduct(yuProducts);

    }



}
