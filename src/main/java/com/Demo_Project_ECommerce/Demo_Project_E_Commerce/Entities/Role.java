package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="role")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;             // primary key
    private String Authority;    // Authority will decide  whether it's an Admin,Seller or a Customer

    @Enumerated(EnumType.STRING)
    @Column(name = "AUTHORITY",unique = true)
        private E_Role roleName;
}

