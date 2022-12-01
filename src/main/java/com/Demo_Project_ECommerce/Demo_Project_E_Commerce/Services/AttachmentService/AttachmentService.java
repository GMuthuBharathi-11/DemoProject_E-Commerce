package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.AttachmentService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService
{
    Attachment saveAttachment(MultipartFile file) throws Exception;
    Attachment getAttachment(String fileId) throws Exception;
}
