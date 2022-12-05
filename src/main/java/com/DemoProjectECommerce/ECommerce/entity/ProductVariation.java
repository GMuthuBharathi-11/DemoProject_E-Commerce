package com.DemoProjectECommerce.ECommerce.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;


@Entity
@Data
@NoArgsConstructor
public class ProductVariation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Integer quantityAvailable;
    private double price;
    private boolean isActive;

}
