package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Seller;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByUser(User user);

}
