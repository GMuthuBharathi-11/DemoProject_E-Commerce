package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.AttachmentService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Attachment;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.AttachmentRepository.AttachmentRepository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class AttachmentServiceImpl
{
    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }


}
