package com.DemoProjectECommerce.ECommerce.entity.entitybasic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private Long   Id;
    @NotNull//Foreign Key taking reference from User_role
    private String phoneNumber;

    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

}
