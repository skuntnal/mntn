package IRCTC.tests;

import IRCTC.dto.FromToFilterCriteriaDTO;
import IRCTC.utilMethods.GenericMethods;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;


public class BusTicketBookingTests extends GenericMethods {

    String url = "";
    JsonPath js;
    Response res;

    Gson gson = new Gson();

    static Properties testProperties;
    static InputStream inputstream_properties;
    SoftAssert assertion = new SoftAssert();

    static {
        try {
            testProperties = new Properties();
            inputstream_properties = BusTicketBookingTests.class.getClassLoader().getResourceAsStream("mntn.properties");
            testProperties.load(inputstream_properties);
            logger.info("PropertyFile : " + testProperties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

    }

    //Test without Authentication
    @Test
    public void VerifyFilterCriteria_PostMethod() {
        try {

            HashMap<String, String> map = new HashMap<>();
            System.out.println("**********************************");
            //construct the url and json body for post request
            url = testProperties.getProperty("appUrl") + testProperties.getProperty("filterCriteriaURI");
            System.out.println("URL : " + url);
            FromToFilterCriteriaDTO fromtofiltercriteriaDTO = new FromToFilterCriteriaDTO(
                    testProperties.getProperty("sourceId"),
                    testProperties.getProperty("destinationId"),
                    testProperties.getProperty("journeyDate"));
            //Convert the response from DTO to json
            String json = gson.toJson(fromtofiltercriteriaDTO);
            res = postRequest(url, json);

            //Verify the response status code
            if(res.statusCode() != 200)
                System.out.println("End-point is returning incorrect status code");
            //Collecting the response from POST request
            js = new JsonPath(res.asString());
            System.out.println("**********************************");
            //Assert on the response received
            assertion.assertEquals(js.get("message").toString().toUpperCase(), "SUCCESS");
            assertion.assertEquals(js.get("status").toString().toUpperCase(), "SUCCESS");
            map = resultsObject(js.get("data"), url, testProperties.getProperty("travelsName"));
            assertion.assertNotNull(resultsObject(js.get("data"), url, testProperties.getProperty("travelsName")));
            assertion.assertAll();
            System.out.println("message" +  " --> " + js.get("message") +
                    ";" + "status"+ " --> " + js.get("message") +
                    "; Bus Depature Time : " + map.keySet() + ", Number of Seats Available : " + map.values());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
