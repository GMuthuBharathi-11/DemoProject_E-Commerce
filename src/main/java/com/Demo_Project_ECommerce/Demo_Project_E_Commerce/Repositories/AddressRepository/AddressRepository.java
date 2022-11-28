package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.AddressRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{

}
