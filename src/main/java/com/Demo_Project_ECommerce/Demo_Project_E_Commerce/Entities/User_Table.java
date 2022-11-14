package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="user_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User_Table
{

    //Setting Parameters for the User_Table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  Id;                             //Primary key for User_Table
    private String Email;
    private String  First_Name;
    private String  Middle_Name;
    private String  Last_Name;
    private String  Password;
    private boolean Is_Deleted;
    private boolean Is_Active;
    private boolean Is_Expired;
    private boolean Is_Locked;
    private Integer Invalid_Attempt_Count;
    private Date  Password_Update_Date;
}
