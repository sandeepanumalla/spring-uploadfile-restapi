package demo.springuploadfile.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("FileEmptyValidator")
public class FileEmptyValidator extends AbstractFileUploadValidator {
    @Override
    public boolean validateNext(MultipartFile multipartFile) {
        if(nextValidator != null) {
            return nextValidator.validate(multipartFile);
        } else {
            return true;
        }
    }

    @Override
    public boolean validate(MultipartFile multipartFile) {
        if(!isFileEmpty(multipartFile)) {
            return validateNext(multipartFile);
        } else {
            throw new RuntimeException("File should not be empty");
        }
    }

    public boolean isFileEmpty(MultipartFile multipartFile) {
        return multipartFile.isEmpty();
    }
}
