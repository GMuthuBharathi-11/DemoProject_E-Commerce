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
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;      // Authority will decide  whether it's an Admin,Seller or a Customer

    @Enumerated(EnumType.STRING)
    @Column(name = "AUTHORITY", unique = true)
    private E_Role roleName;
}

