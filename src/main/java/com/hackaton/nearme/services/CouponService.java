package com.hackaton.nearme.services;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.repositories.CouponRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CouponService {

    private CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon createCoupon(Coupon body) {
        return couponRepository.save(body);
    }

    public Coupon getCouponById(int id) throws NotFoundException {
        Optional<Coupon> optional = couponRepository.findById(id);
        if (optional.isPresent()){
            Coupon coupon = optional.get();
            return coupon;

        }else {
            throw new NotFoundException("Not Found");
        }

    }

}
