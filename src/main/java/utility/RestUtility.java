package utility;

import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import manager.FileReaderManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestUtility{
    public static FilterableRequestSpecification httpRequest = null;
    public Map<String,String> val;

    public RestUtility() {
        baseURI = FileReaderManager.getInstance().getConfigReader().getBaseURL();
        httpRequest = (FilterableRequestSpecification) given();
    }

    public void setHeader(Map<String, String> headers) {
        if(headers!=null) {
            Iterator<Map.Entry<String, String>> itr = headers.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<String, String> entry = itr.next();
                httpRequest.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName(entry.getKey())))
                        .header(entry.getKey(), entry.getValue());
            }
        }

    }

    public Response getData(String endpoint,Map<String, String> headers,Map<String, String> pathParams) {
        setHeader(headers);
        return httpRequest.queryParams(pathParams).get(endpoint);
    }

    public int getStatusCode(Response response){
        return response.statusCode();
    }

    public String getFieldValue(Response response,String path){
        return response.jsonPath().get(path);
    }

    public List getFieldValues(Response response, String path){
        return response.jsonPath().getList(path);

    }
}
