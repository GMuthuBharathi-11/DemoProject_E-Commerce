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
//######--------  token generation on process(Done) --------
//######-------   add the data use @PostMapping and check in the workbench ----------
//---- Register API Part(Postmapping Done)
//---- Login and Logout Process
//Done Phase-1
//Phase-2
//Customer API -- done
//Seller API  -- done
//Admin API  --done
//Left with Image Part --Done
//Phase -3
//Category API
//Product API
// Category API (Update)