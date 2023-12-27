package demo.springuploadfile.service;


import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public abstract class AbstractFileUploadValidator implements FileUploadValidator{

    public FileUploadValidator nextValidator;


    public FileUploadValidator setNextValidator(FileUploadValidator nextValidator) {
        this.nextValidator = nextValidator;
        return this.nextValidator; // return type is helpful for method chaining
    }

    public abstract boolean validateNext(MultipartFile multipartFile);
    @Override
    public boolean validate(MultipartFile multipartFile) {
        return validateNext(multipartFile);
    }
}
