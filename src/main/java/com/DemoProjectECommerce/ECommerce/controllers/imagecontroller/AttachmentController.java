package com.DemoProjectECommerce.ECommerce.controllers.imagecontroller;

import com.DemoProjectECommerce.ECommerce.entity.productentity.Attachment;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.ResponseDto;
import com.DemoProjectECommerce.ECommerce.model.imagedto.ResponseImageDto;
import com.DemoProjectECommerce.ECommerce.services.AttachmentService.AttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class AttachmentController
{

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseImageDto uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Attachment attachment = null;
        String downloadURl = "";
        attachment = attachmentService.saveAttachment(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                                                 .path("/download/")
                                                 .path(attachment.getId())
                                                 .toUriString();

        return new ResponseImageDto(attachment.getFileName(),
                                downloadURl,
                                file.getContentType(),
                                file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);
        return  ResponseEntity.ok()
                              .contentType(MediaType.parseMediaType(attachment.getFileType()))
                              .header(
                                      HttpHeaders.CONTENT_DISPOSITION,
                                      "attachment; filename=\"" + attachment.getFileName()
                                      + "\"")
                              .body(new ByteArrayResource(attachment.getData()));
    }
}
