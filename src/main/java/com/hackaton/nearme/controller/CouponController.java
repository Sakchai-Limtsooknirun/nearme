package com.hackaton.nearme.controller;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.services.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/coupon")
public class CouponController {

    private CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCoupon(@Valid @RequestBody Coupon body) {
        Coupon coupon = couponService.createCoupon(body);
        System.err.println(coupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }
}
