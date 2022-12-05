package com.DemoProjectECommerce.ECommerce.entity;
import javax.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class CategoryMetadataField
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "MetaDataFieldName cannot be null")
    private String metaDataFieldName;

    @OneToMany(mappedBy = "categoryMetadataField")
    private Set<CategoryMetadataFieldValues> categoryMetadataFieldValues;
}
