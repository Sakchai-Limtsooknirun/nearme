package com.hackaton.nearme.repositories;

import com.hackaton.nearme.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    Coupon findAllByCouponId(Long id);
//
//    Coupon findByCode(String code);
}
