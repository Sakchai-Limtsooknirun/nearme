package com.hackaton.nearme.controller;

import com.hackaton.nearme.model.Promotion;
import com.hackaton.nearme.services.MerchantService;
import com.hackaton.nearme.services.PromotionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/promotion")
public class PromotionController {

    private PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getPromotionById(@PathVariable int id) throws NotFoundException {
        try {
            return ResponseEntity.ok(promotionService.getPromotionById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("/all")
    public List<Promotion> getAllMerchant() {
        List<Promotion> promotions = promotionService.getPromotion();
        return promotions;
    }
}
