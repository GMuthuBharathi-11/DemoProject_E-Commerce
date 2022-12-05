package com.DemoProjectECommerce.ECommerce.repositories.categoryrepository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.DemoProjectECommerce.ECommerce.entity.Category;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>
{
      Optional<Category> findByName(String name);

}
