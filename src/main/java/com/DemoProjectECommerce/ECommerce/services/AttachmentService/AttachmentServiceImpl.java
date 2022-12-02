package com.DemoProjectECommerce.ECommerce.services.AttachmentService;

import com.DemoProjectECommerce.ECommerce.repositories.attachmentrepository.AttachmentRepository;

public class AttachmentServiceImpl
{
    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }


}
