package com.DemoProjectECommerce.ECommerce.customizehandling;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails
{
   private LocalDateTime time;
   private String message;
   private String details;
}
