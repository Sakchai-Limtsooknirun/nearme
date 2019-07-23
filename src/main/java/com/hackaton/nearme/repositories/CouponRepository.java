package com.hackaton.nearme.repositories;

import com.hackaton.nearme.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    List<Coupon> findAllByCitizenId(String id);
}
