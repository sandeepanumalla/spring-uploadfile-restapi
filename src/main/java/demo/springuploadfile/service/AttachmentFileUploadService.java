package demo.springuploadfile.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AttachmentFileUploadService implements FileUploadService{

    @Value("${upload.directory}") // External directory where files will be saved
    private String UPLOAD_DIR;

    private final FileTypeValidator fileTypeValidator;

    private final FileEmptyValidator fileEmptyValidator;

    public AttachmentFileUploadService(
//                                       @Qualifier("FileTypeValidator")
            FileTypeValidator fileTypeValidator,
//                                       @Qualifier("FileEmptyValidator")
            FileEmptyValidator fileEmptyValidator) {
        this.fileTypeValidator = fileTypeValidator;
        this.fileEmptyValidator = fileEmptyValidator;
    }

    @Override
    public void upload(MultipartFile multipartFile) {
        fileEmptyValidator.setNextValidator(fileTypeValidator);
        fileEmptyValidator.validate(multipartFile);
        saveFile(multipartFile);
    }

    public void saveFile(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(UPLOAD_DIR + fileName);
        try {
            multipartFile.transferTo(file);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
