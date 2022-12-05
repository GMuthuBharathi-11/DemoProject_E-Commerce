package com.DemoProjectECommerce.ECommerce.entity;

import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)                        //@Enumerated Specifies that a persistent property or field should be persisted as a enumerated type
    @Column(name = "AUTHORITY", unique = true)          // Authority will decide whether it's an Admin,Seller or a Customer
    private ERole roleName;
}

