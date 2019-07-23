package com.hackaton.nearme.controller;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.services.CouponService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/coupon")
public class CouponController {

    private CouponService couponService;
    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCoupon(@RequestBody Coupon body) {
        Coupon coupon = couponService.createCoupon(body);
        System.err.println(coupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCouponById(@PathVariable int id) throws NotFoundException {
        try {
            return ResponseEntity.ok(couponService.getCouponById(id));
        }catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }



}
