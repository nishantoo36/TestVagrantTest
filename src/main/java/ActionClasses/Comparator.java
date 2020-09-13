package ActionClasses;

import com.google.gson.JsonObject;

public class Comparator {
    public static JsonObject jsonObjectForUI = new JsonObject();
    public static JsonObject jsonObjectForAPI = new JsonObject();
    double variance = 0;

    public boolean isTempCorrect(String tempType) throws Exception {
        if(tempType.equalsIgnoreCase("C")){
          variance =  jsonObjectForUI.get("Temp in Degrees").getAsDouble()-jsonObjectForAPI.getAsJsonObject("main").get("feels_like").getAsDouble();
          return isVarianceExpected(tempType,variance);
        }else if(tempType.equalsIgnoreCase("F")){
            variance =  jsonObjectForUI.get("Temp in Fahrenheit").getAsDouble()-jsonObjectForAPI.getAsJsonObject("main").get("feels_like").getAsDouble();
            return isVarianceExpected(tempType,variance);
        }else {
            throw new Exception("Temperature type is not allowed");
        }
    }

     boolean isVarianceExpected(String tempType,double variance){
        if(tempType.equalsIgnoreCase("C")&&variance<3){
            return true;
        }else if(tempType.equalsIgnoreCase("F")&&variance<10){
            return true;
        }else {
            return false;
        }
     }
}
