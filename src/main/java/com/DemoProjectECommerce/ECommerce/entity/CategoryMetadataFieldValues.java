package com.DemoProjectECommerce.ECommerce.entity;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.Data;


@Data
@NoArgsConstructor
@Entity
public class CategoryMetadataFieldValues
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String value;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name= "CategoryMetadataFieldId")
    private CategoryMetadataField categoryMetadataField;


}
