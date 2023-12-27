package demo.springuploadfile.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public interface FileUploadValidator {
    boolean validate(MultipartFile multipartFile);
}
