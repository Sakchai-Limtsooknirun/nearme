package com.hackaton.nearme.services;

import com.hackaton.nearme.model.Merchant;
import com.hackaton.nearme.model.Promotion;
import com.hackaton.nearme.repositories.PromotionRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    private PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Promotion getPromotionById(int id) throws NotFoundException {
        return promotionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found")
        );

    }

    public List<Promotion> getPromotion() {
        return promotionRepository.findAll();
    }
}
