package demo.springuploadfile.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileUploadService {
    void upload(MultipartFile multipartFile);
}
