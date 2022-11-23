package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.CustomizeErrorHandling;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails
{
   private LocalDateTime time;
   private String message;
   private String details;
}
