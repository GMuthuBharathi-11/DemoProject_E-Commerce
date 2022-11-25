//package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.FileController;
//
//
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Payload.FileResponse;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.FileService.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.validation.Valid;
//import java.io.IOException;
////18001080 tollfree
//@RestController
//@RequestMapping("/file")
//public class FileController
//{
//    @Autowired
//    private FileService fileService;
//    @Value("${project.images}")
//    private String path;
//    @PostMapping("/upload")
//    public ResponseEntity<FileResponse> fileUpload
//            (@RequestParam("images")MultipartFile image){
//                String fileName = null;
//                try {
//                    fileName = this.fileService.uploadImage(path, image);
//                }catch (IOException e){
//                    e.printStackTrace();
//                    return new ResponseEntity<>(new FileResponse(null,"image  not uploaded successfully"), HttpStatus.INTERNAL_SERVER_ERROR);
//                }
//
//              return new ResponseEntity<>(new FileResponse(fileName,"image uploaded successfully"), HttpStatus.HTTP_VERSION_NOT_SUPPORTED.OK);
//    }
//}
