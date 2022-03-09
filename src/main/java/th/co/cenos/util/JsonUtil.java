package th.co.cenos.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public String toJsonString(Object object){
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException();
        }
    }

    public <T extends Object> T toObject(String jsonString, Class<T> type){
        try {
            return type.cast( objectMapper.readValue(jsonString , type));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage() , e);
            throw new RuntimeException();
        }
    }

    public Map<String,Object> toMap(String jsonString){
        return toObject(jsonString , Map.class);
    }

    public Map<String,Object> toMap(Object object) {
        return objectMapper.convertValue(object , Map.class);
    }

}
