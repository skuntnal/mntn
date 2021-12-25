package IRCTC.utilMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.log4testng.Logger;

import java.util.ArrayList;
import java.util.HashMap;


public class GenericMethods {
    protected static RequestSpecification spec;
    protected Response response;
    protected static Logger logger = Logger.getLogger(GenericMethods.class);

    public Response postRequest(String uri, String reqBody) {
        response =
                RestAssured.given().
                        contentType("application/json").
                        body(reqBody).
                        when().
                        post(uri).
                        then().
                        extract().
                        response();

        return response;
    }

    protected HashMap<String, String> resultsObject(ArrayList existingArray, String url, String filterCriteria) {

        JSONArray resultsArray = new JSONArray(existingArray);
        JSONObject resultsObject;

        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < resultsArray.length(); i++) {
            resultsObject = resultsArray.getJSONObject(i);
            if(resultsObject.get("serviceName").toString().toUpperCase().equals(filterCriteria)) { //  && ((int) resultsObject.get("fares") < 700)
                String depTime = (String) resultsObject.get("departureTime");
                String avlblSeats = (String) resultsObject.get("availableSeats");
                map.put(depTime, avlblSeats);
                break;
            }
        }

        return map;
    }
}
