package com.DemoProjectECommerce.ECommerce.services.attachmentservice;

import com.DemoProjectECommerce.ECommerce.entity.Attachment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}
