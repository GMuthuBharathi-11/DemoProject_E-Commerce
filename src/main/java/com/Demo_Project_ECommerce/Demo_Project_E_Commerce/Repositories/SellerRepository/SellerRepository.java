package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Seller;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SellerRepository extends JpaRepository<Seller,Long>
{
    Optional<Seller> findByUser(User user);

    Optional<Seller> findById(User user);
}
