package com.DemoProjectECommerce.ECommerce.repositories.categoryrepository;
import com.DemoProjectECommerce.ECommerce.entity.categoryentity.CategoryMetadataFieldValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaDataFieldValueRepository extends JpaRepository<CategoryMetadataFieldValues,Long>
{
}
