package com.hackaton.nearme.services;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.repositories.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    private CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<Coupon> getCoupon() {

        return couponRepository.findAll();
    }

    public Coupon getCoupon(Long id) {
        return couponRepository.findAllByCouponId(id);
    }

    public Coupon createCoupon(Coupon body) {
        return couponRepository.save(body);
    }

    public Coupon updateCoupon(Long id, Coupon coupon) {

        return couponRepository.findAllByCouponId(id) != null ?
                couponRepository.save(coupon) :
                couponRepository.findAllByCouponId(id);
    }

}
