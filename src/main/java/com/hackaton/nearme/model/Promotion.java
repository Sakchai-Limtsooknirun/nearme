package com.hackaton.nearme.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "promotion")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Promotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "m_id")
    private Merchant merchant;

    @JsonManagedReference
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "promotion",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Coupon> couponList = new ArrayList<>();


    private String description;

    private Date startAt;

    private Date expiresAt;

    private int quantity;

    private String product;

    private boolean deleted;
}
