package ActionClasses.API;

import com.cucumber.listener.Reporter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import utility.JsonMethods;
import utility.RestUtility;

import java.util.Map;

import static ActionClasses.Comparator.jsonObjectForAPI;

public class CityWeatherData extends RestUtility {

    public Response getWeatherInformation(String endPoint, Map<String, String> queryParam) {
        return response = getData(endPoint, setHeaders, queryParam,"queryParam");
    }

    public void storeWeatherDataForCity() {
        String valToParse = response.jsonPath().get().toString().trim();
        jsonObjectForAPI = JsonMethods.parseRestResponseToJson(response);
        Reporter.addStepLog("-----------\n-------------"+valToParse);
    }

}
