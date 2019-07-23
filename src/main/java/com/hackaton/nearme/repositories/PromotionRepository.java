package com.hackaton.nearme.repositories;

import com.hackaton.nearme.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
}
