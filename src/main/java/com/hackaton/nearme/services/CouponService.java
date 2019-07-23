package com.hackaton.nearme.services;

import com.hackaton.nearme.model.Coupon;
import com.hackaton.nearme.model.Promotion;
import com.hackaton.nearme.repositories.CouponRepository;
import javassist.NotFoundException;
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

    public Coupon createCoupon(Coupon body) {
        return couponRepository.save(body);
    }

    public Coupon getCouponById(int id) throws NotFoundException {
        return couponRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found")
        );

    }

    public List<Coupon> getByCitizenID(String id) {
        return couponRepository.findAllByCitizenId(id);
    }

    public List<Coupon> getAllCouponNotUsedByPromotionId(int promotionId){
        Promotion promotion = new Promotion();
        promotion.setPromotionId(promotionId);
        return couponRepository.findAllByCitizenIdIsNullAndPromotion(promotion);

    }



}
