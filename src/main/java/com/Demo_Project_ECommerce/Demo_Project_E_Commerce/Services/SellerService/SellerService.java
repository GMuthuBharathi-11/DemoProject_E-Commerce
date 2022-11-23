package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.SellerService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.CustomizeErrorHandling.ApplicationException;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Seller;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository.Seller_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SellerService
{
    @Autowired
    private Seller_Repository seller_repository;

    public Seller findOne(Long Id)
    {
        Seller seller = seller_repository.findById(Math.toIntExact(Id))
                                         .orElseThrow(()-> new ApplicationException(("No User are find with this id")));
        return seller;
    }
    public Page<Seller> findAllSellers()
{
    PageRequest  Pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "Id");
    Page<Seller> result  = seller_repository.findAll(Pageable);
    return result;

}
}
