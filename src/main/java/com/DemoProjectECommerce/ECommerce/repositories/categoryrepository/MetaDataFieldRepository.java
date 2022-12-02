package com.DemoProjectECommerce.ECommerce.repositories.categoryrepository;
import com.DemoProjectECommerce.ECommerce.entity.categoryentity.CategoryMetadataField;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MetaDataFieldRepository extends JpaRepository<CategoryMetadataField, Long>
{
    Optional<CategoryMetadataField> findByMetaDataFieldNameLike(String metaDataFieldName);
}
