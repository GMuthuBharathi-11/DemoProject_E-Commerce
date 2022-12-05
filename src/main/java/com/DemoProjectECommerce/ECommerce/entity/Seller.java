package com.DemoProjectECommerce.ECommerce.entity;

import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Entity
@Table(name="seller")
public class Seller
{
    //Setting Parameters for Seller
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   Id;
    private String gstNo;
    private String companyContact;
    private String companyName;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = " User_Id", referencedColumnName = "Id")
    private User user;
}
