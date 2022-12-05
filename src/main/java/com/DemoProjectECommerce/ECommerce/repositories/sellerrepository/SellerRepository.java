package com.DemoProjectECommerce.ECommerce.repositories.sellerrepository;


import com.DemoProjectECommerce.ECommerce.entity.Seller;
import com.DemoProjectECommerce.ECommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByUser(User user);

}
