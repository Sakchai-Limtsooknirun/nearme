package com.hackaton.nearme.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String merchantId ;

    private String merchantName ;

    private String terminalID  ;

    private String billerID  ;

    private String billerName ;

    private String terminalPrefix ;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "merchant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Promotion> promotionList = new ArrayList<>();
}
