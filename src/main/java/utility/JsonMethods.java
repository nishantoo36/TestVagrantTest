package utility;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.response.Response;

import java.util.Map;

public class JsonMethods {

    public static JsonObject parseRestResponseToJson(Response response){
        Map<String , Object> val = response.jsonPath().get();
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        for(String data:val.keySet()){
            jsonObject.add(data,gson.toJsonTree(val.get(data)));
        }
        return jsonObject;
    }
}
