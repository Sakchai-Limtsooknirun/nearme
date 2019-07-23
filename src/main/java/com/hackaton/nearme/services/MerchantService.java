package com.hackaton.nearme.services;

import com.hackaton.nearme.model.Merchant;
import com.hackaton.nearme.repositories.MerchantRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MerchantService {

    private MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public Merchant createMerchant(Merchant body) {
        return merchantRepository.save(body);
    }

    public Merchant getMerchantById(int id) throws NotFoundException {
        return merchantRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found")
        );

    }


}
