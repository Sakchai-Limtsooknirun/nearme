package com.hackaton.nearme.services;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.repositories.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon createCoupon(Coupon body) {
        return couponRepository.save(body);
    }

}
