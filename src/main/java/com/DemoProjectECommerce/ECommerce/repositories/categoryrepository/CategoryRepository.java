package com.DemoProjectECommerce.ECommerce.repositories.categoryrepository;
import com.DemoProjectECommerce.ECommerce.entity.categoryentity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long>
{
      Optional<Category> findByName(String name);

}
