package bo.edu.ucb.ingsoft.demorest.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    private static Cloudinary cloudinary;
    //Cloudinary cloudinary;

    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryService() {
        valuesMap.put("cloud_name", "ing-de-sistemas");
        valuesMap.put("api_key", "976884648618163");
        valuesMap.put("api_secret", "iiFpy7_rSw5d-lujqY_Y9qTWQfE");
        cloudinary = new Cloudinary(valuesMap);
    }
    public static Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    private static File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        /*
        String fileName = multipartFile.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        File file = null;
        FileInputStream fis=null;
        file = File.createTempFile(fileName, prefix);
        multipartFile.transferTo(file);
        fis=new FileInputStream(file);*/
        return file;
    }
}
