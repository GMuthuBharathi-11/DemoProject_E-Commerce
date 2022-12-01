package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseImageDto
{
    private String fileName;
    private String downloadURL;
    private String fileType;
    private Long fileSize;
}
