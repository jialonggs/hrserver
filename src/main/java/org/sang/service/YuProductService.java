package org.sang.service;

import org.sang.bean.YuProduct;
import org.sang.mapper.YuBaoJiaMapper;
import org.sang.mapper.YuProductMapper;
import org.sang.utils.DoubleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class YuProductService {
    @Autowired
    YuProductMapper yuProductMapper;

    @Autowired
    YuBaoJiaMapper yuBaoJiaMapper;

    @Transactional
    public int addYuProduct(List<YuProduct> yuProducts){

        Double total = 0.00;
        Double noTaxTotal = 0.00;
        Long id = yuProducts.get(0).getYuBaoJiaId();
        for(YuProduct yuProduct : yuProducts){
            total = total + yuProduct.getTotal();
            noTaxTotal = noTaxTotal + yuProduct.getNoTaxPrice();
        }
        // 更新
        total = DoubleUtil.m2(total);
        noTaxTotal = DoubleUtil.m2(noTaxTotal);
        yuBaoJiaMapper.updateYuBaoJia(id, total, noTaxTotal);
        return yuProductMapper.addYuProduct(yuProducts);

    }

    @Transactional
    public int addNewYuProduct(List<YuProduct> yuProduct1){
        List<YuProduct> yuProducts = yuProductMapper.getByYuBaoJiaId(yuProduct1.get(0).getYuBaoJiaId());
        if(null == yuProducts || yuProducts.isEmpty()){
            return -1;
        }
        yuProducts.add(yuProduct1.get(0));
        Double total = 0.00;
        Double noTaxTotal = 0.00;
        Long id = yuProducts.get(0).getYuBaoJiaId();
        for(YuProduct yuProduct : yuProducts){
            total = total + yuProduct.getTotal();
            noTaxTotal = noTaxTotal + yuProduct.getNoTaxPrice();
        }
        // 更新
        total = DoubleUtil.m2(total);
        noTaxTotal = DoubleUtil.m2(noTaxTotal);
        yuBaoJiaMapper.updateYuBaoJia(id, total, noTaxTotal);
        return yuProductMapper.addYuProduct(yuProduct1);
    }


    @Transactional
    public Boolean updateYuProduct(YuProduct yuProduct1){
        List<YuProduct> yuProducts = yuProductMapper.getByYuBaoJiaId(yuProduct1.getYuBaoJiaId());
        if(null == yuProducts || yuProducts.isEmpty()){
            return false;
        }
        Double total = 0.00;
        Double noTaxTotal = 0.00;
        Long id = yuProducts.get(0).getYuBaoJiaId();
        for(YuProduct yuProduct : yuProducts){
            if(yuProduct.getId() == yuProduct1.getId()){
                total = total + yuProduct1.getTotal();
                noTaxTotal = noTaxTotal + yuProduct1.getNoTaxPrice();
            }else{
                total = total + yuProduct.getTotal();
                noTaxTotal = noTaxTotal + yuProduct.getNoTaxPrice();
            }
        }
        // 更新
        total = DoubleUtil.m2(total);
        noTaxTotal = DoubleUtil.m2(noTaxTotal);
        yuBaoJiaMapper.updateYuBaoJia(id, total, noTaxTotal);
        int i = yuProductMapper.updateYuProduct(yuProduct1);
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public Boolean delProduct(YuProduct yuProduct1){
        List<YuProduct> yuProducts = yuProductMapper.getByYuBaoJiaId(yuProduct1.getYuBaoJiaId());
        if(null == yuProducts || yuProducts.isEmpty()){
            return false;
        }
        Double total = 0.00;
        Double noTaxTotal = 0.00;
        Long id = yuProducts.get(0).getYuBaoJiaId();
        for(YuProduct yuProduct : yuProducts){
            if(yuProduct.getId() == yuProduct1.getId()){
              continue;
            }else{
                total = total + yuProduct.getTotal();
                noTaxTotal = noTaxTotal + yuProduct.getNoTaxPrice();
            }
        }
        // 更新
        total = DoubleUtil.m2(total);
        noTaxTotal = DoubleUtil.m2(noTaxTotal);
        yuBaoJiaMapper.updateYuBaoJia(id, total, noTaxTotal);
        int i = yuProductMapper.delProduct(yuProduct1.getId());
        if(i > 0){
            return true;
        }else{
            return false;
        }
    }



}
