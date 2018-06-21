package org.sang.service;

import org.sang.bean.BusinessProduct;
import org.sang.bean.YuProduct;
import org.sang.mapper.BusinessBaoJiaMapper;
import org.sang.mapper.BusinessProductMapper;
import org.sang.mapper.YuProductMapper;
import org.sang.utils.DoubleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusinessProductService {
    @Autowired
    BusinessProductMapper businessProductMapper;

    @Autowired
    BusinessBaoJiaMapper businessBaoJiaMapper;

    @Transactional
    public int addBusinessProduct(List<BusinessProduct> businessProducts){
        Double total = 0.00;
        Double noTaxTotal = 0.00;
        Long id = businessProducts.get(0).getYuBaoJiaId();
        for(BusinessProduct businessProduct : businessProducts){
            total = total + businessProduct.getTotal();
            noTaxTotal = noTaxTotal + businessProduct.getNoTaxPrice();
        }
        total = DoubleUtil.m2(total);
        noTaxTotal = DoubleUtil.m2(noTaxTotal);
        // 更新
        businessBaoJiaMapper.updateBusinessBaoJia(id, total, noTaxTotal);
        return businessProductMapper.addBusinessProduct(businessProducts);
    }




    @Transactional
    public int addNewYuProduct(List<BusinessProduct> businessProduct1){
        List<BusinessProduct> yuProducts = businessProductMapper.getByYuBaoJiaId(businessProduct1.get(0).getYuBaoJiaId());
        if(null == yuProducts || yuProducts.isEmpty()){
            return -1;
        }
        yuProducts.add(businessProduct1.get(0));
        Double total = 0.00;
        Double noTaxTotal = 0.00;
        Long id = yuProducts.get(0).getYuBaoJiaId();
        for(BusinessProduct yuProduct : yuProducts){
            total = total + yuProduct.getTotal();
            noTaxTotal = noTaxTotal + yuProduct.getNoTaxPrice();
        }
        // 更新
        total = DoubleUtil.m2(total);
        noTaxTotal = DoubleUtil.m2(noTaxTotal);
        businessBaoJiaMapper.updateBusinessBaoJia(id, total, noTaxTotal);
        return businessProductMapper.addBusinessProduct(businessProduct1);
    }


    @Transactional
    public Boolean updateYuProduct(BusinessProduct businessProduct1){
        List<BusinessProduct> yuProducts = businessProductMapper.getByYuBaoJiaId(businessProduct1.getYuBaoJiaId());
        if(null == yuProducts || yuProducts.isEmpty()){
            return false;
        }
        Double total = 0.00;
        Double noTaxTotal = 0.00;
        Long id = yuProducts.get(0).getYuBaoJiaId();
        for(BusinessProduct yuProduct : yuProducts){
            if(yuProduct.getId() == businessProduct1.getId()){
                total = total + businessProduct1.getTotal();
                noTaxTotal = noTaxTotal + businessProduct1.getNoTaxPrice();
            }else{
                total = total + yuProduct.getTotal();
                noTaxTotal = noTaxTotal + yuProduct.getNoTaxPrice();
            }
        }
        // 更新
        total = DoubleUtil.m2(total);
        noTaxTotal = DoubleUtil.m2(noTaxTotal);
        businessBaoJiaMapper.updateBusinessBaoJia(id, total, noTaxTotal);
        int i = businessProductMapper.updateYuProduct(businessProduct1);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public Boolean delProduct(BusinessProduct businessProduct1){
        List<BusinessProduct> yuProducts = businessProductMapper.getByYuBaoJiaId(businessProduct1.getYuBaoJiaId());
        if(null == yuProducts || yuProducts.isEmpty()){
            return false;
        }
        Double total = 0.00;
        Double noTaxTotal = 0.00;
        Long id = yuProducts.get(0).getYuBaoJiaId();
        for(BusinessProduct businessProduct : yuProducts){
            if(businessProduct.getId() == businessProduct1.getId()){
                continue;
            }else{
                total = total + businessProduct.getTotal();
                noTaxTotal = noTaxTotal + businessProduct.getNoTaxPrice();
            }
        }
        // 更新
        total = DoubleUtil.m2(total);
        noTaxTotal = DoubleUtil.m2(noTaxTotal);
        businessBaoJiaMapper.updateBusinessBaoJia(id, total, noTaxTotal);
        int i = businessProductMapper.delProduct(businessProduct1.getId());
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }



}
