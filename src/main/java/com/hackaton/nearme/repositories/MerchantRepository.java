package com.hackaton.nearme.repositories;

import com.hackaton.nearme.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

}
