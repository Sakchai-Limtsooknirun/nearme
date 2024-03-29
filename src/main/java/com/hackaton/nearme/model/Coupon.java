package com.hackaton.nearme.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Coupon")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Coupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int couponId;

    private String merchantName;

    private String code;

    private String titleName;

    @Size(min = 1, max = 100)
    private String description;

    private Date createdDate;

    private Date expiredDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @JsonProperty("customer_id")
    private String citizenId;

    @URL
    private String imagePath;

    @Lob
    private String qrCode;


}
