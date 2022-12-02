package com.DemoProjectECommerce.ECommerce.repositories.customerrepository;

import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Customer;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUser(User user);

}
