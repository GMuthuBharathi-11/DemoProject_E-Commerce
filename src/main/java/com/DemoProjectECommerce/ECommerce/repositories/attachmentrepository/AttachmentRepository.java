package com.DemoProjectECommerce.ECommerce.repositories.attachmentrepository;

import com.DemoProjectECommerce.ECommerce.entity.productentity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,String>
{

}
