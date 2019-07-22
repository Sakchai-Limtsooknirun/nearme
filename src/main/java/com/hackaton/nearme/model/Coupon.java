package com.hackaton.nearme.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long coupon_id;

    @NotNull
    private String sn;

    @NotNull
    private String code;

    @NotNull
    @Size(min = 1, max = 100)
    private String description;

    @CreationTimestamp
    private Date created_date;

    @CreationTimestamp
    private Date expired_date;

}
