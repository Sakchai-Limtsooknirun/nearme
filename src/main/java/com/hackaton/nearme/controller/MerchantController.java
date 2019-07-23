package com.hackaton.nearme.controller;

import com.hackaton.nearme.services.MerchantService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/merchant")
public class MerchantController {

    private MerchantService merchantService;

    @Autowired
    public MerchantController(MerchantService merchantService){
        this.merchantService = merchantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getMerchantById(@PathVariable int id) throws NotFoundException {
        try {
            return ResponseEntity.ok(merchantService.getMerchantById(id));
        }catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
