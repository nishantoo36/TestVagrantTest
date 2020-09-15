package ActionClasses;

import com.google.gson.JsonObject;

public class Comparator {
    public static JsonObject jsonObjectForUI = new JsonObject();
    public static JsonObject jsonObjectForAPI = new JsonObject();
    public static double variance = 0;
    public static double UIData =0;
    public static double APIData =0;
    public boolean isTempCorrect(String tempType,double expectedVariance) {
        if(tempType.equalsIgnoreCase("C")){
          UIData=  jsonObjectForUI.get("Temp in Degrees").getAsDouble();
          APIData =jsonObjectForAPI.getAsJsonObject("main").get("temp").getAsDouble();
          variance = Math.abs(UIData -APIData);
          return isVarianceExpectedForTemperature(tempType,variance,expectedVariance);
        }else if(tempType.equalsIgnoreCase("F")){
            variance = Math.abs(jsonObjectForUI.get("Temp in Fahrenheit").getAsDouble()-jsonObjectForAPI.getAsJsonObject("main").get("temp").getAsDouble());
            return isVarianceExpectedForTemperature(tempType,variance,expectedVariance);
        }else {
            throw new UnsupportedOperationException("Temperature type is not allowed");
        }
    }

    public boolean isHumidity(double expectedVariance){
      UIData= Double.parseDouble(jsonObjectForUI.get("Humidity").getAsString().replace("%",""));
      APIData=  jsonObjectForAPI.getAsJsonObject("main").get("humidity").getAsDouble();
      variance =Math.abs(UIData-APIData);
      return isVarianceExpectedForHumidity(variance,expectedVariance);
    }

     boolean isVarianceExpectedForTemperature(String tempType, double variance,double expectedVariance){
        if(tempType.equalsIgnoreCase("C")&&variance<=expectedVariance){
            return true;
        }else if(tempType.equalsIgnoreCase("F")&&variance<=expectedVariance){
            return true;
        }else {
            return false;
        }
     }

    boolean isVarianceExpectedForHumidity(double variance,double expectedVariance){
            return variance<=expectedVariance;
        }
}
