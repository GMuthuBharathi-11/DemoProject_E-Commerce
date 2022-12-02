package com.DemoProjectECommerce.ECommerce.model.imagedto;

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
