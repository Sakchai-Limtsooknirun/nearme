package com.hackaton.nearme.services;

import com.hackaton.nearme.repositories.PromotionRepository;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }
}
