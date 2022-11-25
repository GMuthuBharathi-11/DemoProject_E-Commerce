package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import javax.persistence.Entity;


public enum E_Role
{
    ROLE_ADMIN,ROLE_CUSTOMER,ROLE_SELLER;

    public Object build()
    {
        return  "e_role";

    }
}
