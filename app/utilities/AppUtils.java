package utilities;


import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.util.ArrayList;


public class AppUtils {
    public static JsonNode convertToJSON(ArrayList object){
        return Json.toJson(object);
    }
}
