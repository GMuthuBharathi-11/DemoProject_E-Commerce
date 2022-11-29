package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer
{

    //Setting Parameters for Customer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @NotNull//Foreign Key taking reference from User_role
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
