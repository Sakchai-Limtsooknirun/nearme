package com.hackaton.nearme.repositories;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    List<Coupon> findAllByCitizenId(String id);

    List<Coupon> findAllByCitizenIdIsNullAndPromotion(Promotion promotion);

    @Transactional
    int deleteByCode(String code) ;
}
