package com.hackaton.nearme.controller;

import com.hackaton.nearme.model.Promotion;
import com.hackaton.nearme.services.MerchantService;
import com.hackaton.nearme.services.PromotionService;
import com.hackaton.nearme.utils.DateTimeCreation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
    public List<Promotion> getAllPromotion() {
        List<Promotion> promotions = promotionService.getPromotion();
        return promotions;
    }
    @RequestMapping(method = POST)
    public ResponseEntity createPromotion(@RequestParam int merchantId, @RequestBody Promotion promotion){
        Promotion newPromotion = promotionService.createPromotion(merchantId, promotion);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPromotion) ;
    }
}
