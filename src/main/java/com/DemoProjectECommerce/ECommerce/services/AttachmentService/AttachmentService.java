package com.DemoProjectECommerce.ECommerce.services.AttachmentService;

import com.DemoProjectECommerce.ECommerce.entity.productentity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService
{
    Attachment saveAttachment(MultipartFile file) throws Exception;
    Attachment getAttachment(String fileId) throws Exception;
}
