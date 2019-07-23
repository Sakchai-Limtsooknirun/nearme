package com.hackaton.nearme.controller;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.services.CouponService;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/coupon")
public class CouponController {

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @RequestMapping(method = RequestMethod.POST)

    public ResponseEntity<?> createCoupon(@Valid @RequestBody Coupon body) {
        Date date = new Date();
        try {
            Date created_date = sdf.parse(sdf.format(date));
            body.setCreated_date(created_date);
            body.setExpired_date(created_date);

//            Date expired_date = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        body.setCode("AAAA");
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



    @RequestMapping(path = "/all")
    public List<Coupon> getAllCoupon() {
        List<Coupon> allCoupon = couponService.getCoupon();
        return allCoupon;
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateCoupon(@PathVariable int id, @Valid @RequestBody Coupon body) {
//        body.setCouponId(id);
//        Coupon coupon = couponService.updateCoupon(id, body);
//        return coupon != null ?
//                ResponseEntity.ok(coupon) :
//                ResponseEntity.notFound().build();
//    }

}
