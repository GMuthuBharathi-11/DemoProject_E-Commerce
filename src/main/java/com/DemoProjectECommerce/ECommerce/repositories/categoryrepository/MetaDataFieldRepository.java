package com.DemoProjectECommerce.ECommerce.repositories.categoryrepository;


import com.DemoProjectECommerce.ECommerce.entity.CategoryMetadataField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface MetaDataFieldRepository extends JpaRepository<CategoryMetadataField, Long>
{
    Optional<CategoryMetadataField> findByMetaDataFieldNameLike(String metaDataFieldName);
}
