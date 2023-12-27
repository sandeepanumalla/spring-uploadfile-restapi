package demo.springuploadfile.service;


import demo.springuploadfile.exception.InvalidFileTypeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service("FileTypeValidator")
public class FileTypeValidator extends AbstractFileUploadValidator{

    private static final List<String> allowedContentTypes = Arrays.asList(
            "application/pdf",
            "application/vnd.openxmlformats-officedocument.presentationml.presentation", // PPTX
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document", // DOCX
            "text/plain"
    );
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
        String contentType = multipartFile.getContentType();
        if(isContentTypeAllowed(contentType)) {
            return validateNext(multipartFile);
        } else {
            throw new InvalidFileTypeException("Invalid file type. Allowed types are: " + allowedContentTypes);
        }
    }

    private boolean isContentTypeAllowed(String contentType) {
        return allowedContentTypes.contains(contentType);
    }
}
