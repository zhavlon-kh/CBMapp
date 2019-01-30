package kg.apps.CBMapp.service;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public interface FileService {

    static String now(){
        return DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
    }

    JSONArray getContactsAsJsonArrayByIds(Set<Long> idSet);

    JSONArray getAllUserContactsAsJsonArray() throws Exception;

}
