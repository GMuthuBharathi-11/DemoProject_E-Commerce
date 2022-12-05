package com.DemoProjectECommerce.ECommerce.repositories.customerrepository;


import com.DemoProjectECommerce.ECommerce.entity.Customer;
import com.DemoProjectECommerce.ECommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUser(User user);

}
