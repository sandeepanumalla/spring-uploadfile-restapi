package demo.springuploadfile.controller;

import demo.springuploadfile.service.FileUploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileAttachmentController {

    private final FileUploadService fileUploadService;

    public FileAttachmentController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        fileUploadService.upload(multipartFile);
        return "file has been uploaded successfully";
    }

    @GetMapping("/download")
    public String downloadFile(
//            @RequestParam("file") MultipartFile multipartFile
    ) {
//        fileUploadService.upload(multipartFile);
        return "file has been downloaded successfully";
    }
}
