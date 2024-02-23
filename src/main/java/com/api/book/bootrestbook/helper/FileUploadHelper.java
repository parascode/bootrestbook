package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    // private final String UPLOAD_DES =
    // "C:\\Users\\socia\\OneDrive\\Desktop\\springvs\\bootrestbook\\src\\main\\resources\\static\\image";
    private final String UPLOAD_DES = new ClassPathResource("/static/image/").getFile().getAbsolutePath();

    // created constructor to handle exception than can occur due to getFile of
    // above class path resource
    public FileUploadHelper() throws IOException {

    }

    public boolean uploadHelper(MultipartFile file) {
        boolean isUploaded = false;
        try {
            // byte data[] = file.getBytes();
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DES + File.separator +
            // file.getOriginalFilename());
            System.out.println(UPLOAD_DES + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DES + File.separator +
                    file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            // fos.write(data);
            // fos.flush();
            // fos.close();
            isUploaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUploaded;
    }
}
