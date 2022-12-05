package com.DemoProjectECommerce.ECommerce.model.imagedto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseImageDto
{
    private String fileName;
    private String downloadURL;
    private String fileType;
    private Long   fileSize;
}
