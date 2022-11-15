package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class User_Role
{

    // Setting the Foreign Key for User and Role Id
    @Id
    private Long User_Id;                        //foreign key taking reference from user_table
    private Long Role_Id;                       //foreign key taking reference from role


}
