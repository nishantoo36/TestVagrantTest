package ActionClasses.API;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import utility.RestUtility;
import java.util.Map;
import static ActionClasses.Comparator.jsonObjectForAPI;

public class CityWeatherData extends RestUtility {
    Response response;

  public Response getWeatherInformation(String endPoint, Map<String,String> queryParam){
        return response=getData(endPoint,val,queryParam);
    }


    public void storeWeatherDataForCity(){

        jsonObjectForAPI= (JsonObject) JsonParser.parseString(response.jsonPath().get().toString());
    }

}
