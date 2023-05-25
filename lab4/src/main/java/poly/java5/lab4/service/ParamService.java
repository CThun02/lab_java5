package poly.java5.lab4.service;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {
    @Autowired
    private HttpServletRequest req;


    public String getString(String name, String defaultValue){
        String value;
        try{
            value = req.getParameter(name);
        }catch (Exception e){
            value = defaultValue;
            e.printStackTrace();
        }
        return value;
    }

    public int getInt(String name, int defaultValue){
        int value;
        try{
            value = Integer.parseInt(req.getParameter(name));
        }catch (Exception e){
            value = defaultValue;
            e.printStackTrace();
        }
        return value;
    }

    public double getDouble(String name, double defaultValue){
        double value;
        try{
            value = Double.parseDouble(req.getParameter(name));
        }catch (Exception e){
            value = defaultValue;
            e.printStackTrace();
        }
        return value;
    }



    public boolean getBoolean(String name, boolean defaultValue){
        boolean value;
        try{
            value = Boolean.parseBoolean(req.getParameter(name));
        }catch (Exception e){
            value = defaultValue;
            e.printStackTrace();
        }
        return value;
    }

    public Date getDate(String name, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date value;
        try{
            value = sdf.parse(req.getParameter(name));
        } catch (ParseException e) {
            value = null;
            e.printStackTrace();
        }
        return value;
    }

    public File save(MultipartFile file, String path) throws RuntimeException{
        try {
            // Lấy tên file gốc
            String originalFilename = file.getOriginalFilename();
            // Tạo đối tượng File để lưu file upload
            File uploadFile = new File(path, originalFilename);
            // Lưu file upload vào đối tượng File
            file.transferTo(uploadFile);
            // Trả về đối tượng File đã lưu
            return uploadFile;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi lưu file: " + e.getMessage());
        }
    }
}
