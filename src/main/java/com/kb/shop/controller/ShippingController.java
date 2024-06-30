package com.kb.shop.controller;

import com.kb.shop.ShopApplication;
import com.kb.shop.domain.Seller;
import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service.SellerService;
import com.kb.shop.service.ShippingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.SysexMessage;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/shipping")

public class ShippingController {

    @Autowired
    private ShippingService shippingService;
    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)

    @GetMapping("/{id}")
    public ResponseEntity<ShippingInfo> readOne(@PathVariable Long id){
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo = shippingService.getShippingInfo(id);
        System.out.println("read one");
        if (shippingInfo != null) {
            return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    @PostMapping
    public ResponseEntity<ShippingInfo> create(@RequestBody ShippingInfo shippingInfo){

        ShippingInfo newshippingInfo = new ShippingInfo();
        newshippingInfo = shippingService.setShippingInfo(shippingInfo);
        System.out.println("create");
        if (newshippingInfo != null) {
            return new ResponseEntity<>(newshippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    @PutMapping("/{id}")
        public ShippingInfo udpateShippingInfo(@PathVariable Long id, @RequestBody ShippingInfo shippingInfo) {
            System.out.println("update");
            shippingService.updateShippingInfo(id,shippingInfo);

            return shippingService.getShippingInfo(id);
        }





}
