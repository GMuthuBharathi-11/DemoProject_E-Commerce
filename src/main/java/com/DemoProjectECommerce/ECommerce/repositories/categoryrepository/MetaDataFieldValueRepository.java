package com.DemoProjectECommerce.ECommerce.repositories.categoryrepository;


import com.DemoProjectECommerce.ECommerce.entity.CategoryMetadataFieldValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MetaDataFieldValueRepository extends JpaRepository<CategoryMetadataFieldValues,Long>
{
}
