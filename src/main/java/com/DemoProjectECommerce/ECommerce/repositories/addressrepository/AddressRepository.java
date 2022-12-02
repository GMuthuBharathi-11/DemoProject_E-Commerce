package com.DemoProjectECommerce.ECommerce.repositories.addressrepository;

import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{

}
