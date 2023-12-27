package demo.springuploadfile.config;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.multipart.MultipartResolver;


@Configuration
@ComponentScan(basePackages = "demo.springuploadfile.service")
public class FileUploadConfiguration {


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // Set the maximum allowed file size (e.g., 10MB)
        factory.setMaxFileSize(DataSize.of(10L, DataUnit.MEGABYTES));
        // Set the maximum allowed request size (e.g., 10MB)
        factory.setMaxRequestSize(DataSize.of(10L, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }


}
