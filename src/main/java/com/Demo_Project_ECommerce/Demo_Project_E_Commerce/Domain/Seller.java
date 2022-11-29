package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="seller")
public class Seller
{
    //Setting Parameters for Seller

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;             // foreign key for (Seller_Table)
    private String gstNo;
    private String companyContact;
    private String companyName;
    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = " User_Id", referencedColumnName = "Id")
    private User   user;
}
