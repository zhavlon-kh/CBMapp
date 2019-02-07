package kg.apps.CBMapp.service;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
public interface FileService {

    static String now(){
        return DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
    }

    JSONArray getContactsAsJsonArrayByIds(Set<Long> idSet) throws Exception;

    JSONArray getAllUserContactsAsJsonArray() throws Exception;

    boolean storeFile(MultipartFile getFile);

}
