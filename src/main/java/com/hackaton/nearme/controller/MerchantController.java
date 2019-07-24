package com.hackaton.nearme.controller;

import com.hackaton.nearme.model.Merchant;
import com.hackaton.nearme.services.MerchantService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/merchant")
public class MerchantController {

    private MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getMerchantById(@PathVariable int id) throws NotFoundException {
        try {
            return ResponseEntity.ok(merchantService.getMerchantById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("/all")
    public List<Merchant> getAllMerchant() {
        List<Merchant> merchants = merchantService.getMerchant();
        return merchants;
    }
}
