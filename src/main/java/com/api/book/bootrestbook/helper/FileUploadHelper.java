package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    private final String UPLOAD_DES = "C:\\Users\\socia\\OneDrive\\Desktop\\springvs\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean uploadHelper(MultipartFile file) {
        boolean isUploaded = false;
        try {
            byte data[] = file.getBytes();
            FileOutputStream fos = new FileOutputStream(UPLOAD_DES + File.separator + file.getOriginalFilename());
            System.out.println(UPLOAD_DES + File.separator + file.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();
            isUploaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUploaded;
    }
}
