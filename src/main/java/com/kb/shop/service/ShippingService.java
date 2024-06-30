package com.kb.shop.service;

import com.kb.shop.domain.Seller;
import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.SellerRepository;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;


    public ShippingInfo getShippingInfo (Long id) {

        return shippingRepository.selectShippingInfo(id);
    }

    public void deleteShippingInfo (Long id) {
        shippingRepository.deleteShippingInfo(id);
    }

    public void updateShippingInfo (Long id, ShippingInfo shippingInfo) {
        shippingRepository.updateUpdateShippingStatus(id,shippingInfo);
    }

    public ShippingInfo setShippingInfo (ShippingInfo shippingInfo) {
        shippingRepository.setShippingInfo(shippingInfo);
        //return getSellerInfo(seller.getId());
        return shippingRepository.selectSelectInfoByOrderId(shippingInfo.getOrderId());
    }

}
