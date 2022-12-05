package com.DemoProjectECommerce.ECommerce.entity;

import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // primary key
    private Long   Id;
    private String city;
    private String state;
    private String addressLine;
    private String country;
    private String zipCode;
    private String label;

}
