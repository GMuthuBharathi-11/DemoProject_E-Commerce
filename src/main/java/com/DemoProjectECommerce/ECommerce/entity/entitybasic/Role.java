package com.DemoProjectECommerce.ECommerce.entity.entitybasic;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;      // Authority will decide  whether it's an Admin,Seller or a Customer

    @Enumerated(EnumType.STRING)
    @Column(name = "AUTHORITY", unique = true)
    private ERole roleName;
}

