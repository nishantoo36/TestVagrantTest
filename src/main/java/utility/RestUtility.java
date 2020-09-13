package utility;

import com.google.gson.JsonObject;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import manager.FileReaderManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestUtility{
    public static Response response;
    private static FilterableRequestSpecification httpRequest = null;
    public Map<String,String> setHeaders;

    protected RestUtility() {
        baseURI = FileReaderManager.getInstance().getConfigReader().getBaseURL();
        httpRequest = (FilterableRequestSpecification) given();
    }

    protected void setHeader(Map<String, String> headers) {
        if(headers!=null) {
            Iterator<Map.Entry<String, String>> itr = headers.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<String, String> entry = itr.next();
                httpRequest.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName(entry.getKey())))
                        .header(entry.getKey(), entry.getValue());
            }
        }

    }

    protected Response getData(String endpoint,Map<String, String> headers,Map<String, String> params,String paramType) {
        setHeader(headers);
        if(paramType.equalsIgnoreCase("pathParam")){
            return httpRequest.pathParams(params).get(endpoint);
        }else if (paramType.equalsIgnoreCase("queryParam")) {
            return httpRequest.queryParams(params).get(endpoint);
        }else {
            throw new UnsupportedOperationException("ParamType is not supported");
        }
    }

    protected Response postData(String endpoint, Map<String, String> headers, Map<String, String> params, String paramType, JsonObject properties) {
        setHeader(headers);
        if (!properties.toString().equals("{}")) {
            httpRequest.body(properties.toString());
        } else {
            httpRequest.body("");
        }
        if(paramType.equalsIgnoreCase("pathParam")){
            return httpRequest.pathParams(params).post(endpoint);
        }else if (paramType.equalsIgnoreCase("queryParam")) {
            return httpRequest.queryParams(params).post(endpoint);
        }else {
            throw new UnsupportedOperationException("ParamType is not supported");
        }
    }

    protected int getStatusCode(){
        return response.statusCode();
    }

    protected String getFieldValue(String path){
        return response.jsonPath().get(path);
    }

    protected List getFieldValues(String path){
        return response.jsonPath().getList(path);

    }
}
