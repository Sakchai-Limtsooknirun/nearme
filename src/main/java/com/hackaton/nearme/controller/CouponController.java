package com.hackaton.nearme.controller;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.services.CouponService;
import com.hackaton.nearme.utils.DateTimeCreation;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/coupon")
public class CouponController {

    private CouponService couponService;
    private DateTimeCreation dateTimeCreation = new DateTimeCreation();

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCoupon(@RequestBody Coupon body) {

        body.setCode(UUID.randomUUID().toString().toUpperCase());
        body.setCreatedDate(dateTimeCreation.getCreatedDate());
        body.setExpiredDate(dateTimeCreation.getExpiredDate());

        Coupon coupon = couponService.createCoupon(body);
        System.err.println(coupon);

        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }


    @GetMapping("/{id}")
    public ResponseEntity getCouponById(@PathVariable int id) throws NotFoundException {
        try {
            return ResponseEntity.ok(couponService.getCouponById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(path = "/all")
    public List<Coupon> getAllCoupon() {
        List<Coupon> allCoupon = couponService.getCoupon();
        return allCoupon;
    }

    @GetMapping("/citizen/{citizenId}")
    public ResponseEntity getCouponByCitizenID(@PathVariable String citizenId) {
        List<Coupon> coupon = couponService.getByCitizenID(citizenId);

        return coupon != null ?
                ResponseEntity.ok(coupon) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/promotion/{promotionId}")
    public ResponseEntity getAllCouponNotUsed(@PathVariable int promotionId) {
        List<Coupon> coupon = couponService.getAllCouponNotUsedByPromotionId(promotionId);

        return coupon != null ?
                ResponseEntity.ok(coupon) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/code/{couponCode}")
    public ResponseEntity deleteCouponByCode(@PathVariable String couponCode) {
        boolean deleted = couponService.deleteCouponByCode(couponCode);

        return deleted ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }


    @PutMapping
    public ResponseEntity<?> putCoupon(@RequestParam int promotionId, @RequestParam String citizenId) throws NotFoundException {

        List<Coupon> coupons = couponService.getAllCouponNotUsedByPromotionId(promotionId);
        Coupon updateCoupon = coupons.get(0);
        updateCoupon.setCitizenId(citizenId);
        couponService.updateCoupon(updateCoupon.getCouponId(), updateCoupon);

        return updateCoupon != null ?
                ResponseEntity.ok(updateCoupon) :
                ResponseEntity.notFound().build();
    }

}
