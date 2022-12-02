package com.DemoProjectECommerce.ECommerce.entity.categoryentity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private  String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentCategoryId")
    private Category parentCategoryId;

    @OneToMany(mappedBy = "parentCategoryId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Category>   childCategoryId;

    @OneToMany(mappedBy = "category")
    private Set<CategoryMetadataFieldValues> categoryMetadataFieldValues;
}

