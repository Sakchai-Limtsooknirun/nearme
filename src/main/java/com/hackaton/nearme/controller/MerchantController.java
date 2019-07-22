package com.hackaton.nearme.controller;

import com.hackaton.nearme.services.MerchantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/merchant")
public class MerchantController {
    private MerchantService merchantService;

    public MerchantController(MerchantService merchantService){ this.merchantService = merchantService; }
}
