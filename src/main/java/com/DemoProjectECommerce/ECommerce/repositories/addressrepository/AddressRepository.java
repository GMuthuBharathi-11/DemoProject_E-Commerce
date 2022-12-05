package com.DemoProjectECommerce.ECommerce.repositories.addressrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DemoProjectECommerce.ECommerce.entity.Address;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{

}
