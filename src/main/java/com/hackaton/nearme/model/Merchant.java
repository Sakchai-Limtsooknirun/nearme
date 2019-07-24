package com.hackaton.nearme.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="merchant")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Merchant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("m_id")
    private int mId ;

    private String merchantId ;

    private String merchantName ;

    private String terminalId  ;

    private String billerId  ;

    private String billerName ;

    private String terminalPrefix ;

    private double latitude;

    private double longitude;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "merchant",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Promotion> promotionList = new ArrayList<>();
}
