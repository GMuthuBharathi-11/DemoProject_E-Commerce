//package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Project_Flow_Information_Phase_1;
//Phase -1
//--> Domain Design
//--> Register API
//--> Login and Logout API

// Phase -1  --> create a table  for ( User , Seller , Consumer , Address , Role , User_Role)
//---> Domain Design (still 10% Remaining)
//---- Create a Package "Entities"
//--->Customer,Seller,Address,Role,User,User_role  Details( used the Lambok concept , Mapping )
//---- Create  a package "Repository"
//--------> creating Interface and extending CrudRepositories
//---- Create a package "Controller"
//--------> Create the API
//--------> Will Perform Service Methods
//---- Create a package "Service"
//--------> @autowired the Methods
//---- Trying with Security Part for Generating the Token
//---- create a package for "Configuration"
//-------->  AuthenticationUserDetails are (the User Id credentials and password encoder details are added the(the core details of a user are added))
//-------->  token generation--------
//----Not Yet started
//---- Register API Part
//---- Login and Logout Process