package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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
