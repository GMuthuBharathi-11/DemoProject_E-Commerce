package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Seller_Repository extends JpaRepository<Seller,Integer> {
}
