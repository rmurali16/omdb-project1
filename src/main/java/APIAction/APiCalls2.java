package APIAction;

import Constant.DataConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class APiCalls2 {

    /**
     * Separate method for the Query params
     * @return returns a map of Query param key/value pairs
     * @throws IOException
     */
    public static Map<String, String> queryParams() throws IOException {
        Map<String, String> params = new HashMap<>();
        String apiKey = DataConstants.getApiKey();
        params.put("apikey", apiKey);
        return params;
    }

    /**
     * returns information of the movie by passing in imdb Id as argument
     * @param Id - IMDB Id of the movie
     * @return returns information of the movie in JSON format
     * @throws IOException
     */
    public static Response get_by_Id(String Id) throws IOException {
        RestAssured.baseURI = DataConstants.getBaseURL();
        Map<String, String> queryPar = queryParams();
        queryPar.put("i",Id);
        RequestSpecification request = RestAssured.given().queryParams(queryPar);
        Response idResponse = request.get();
        return idResponse;
    }

    /**
     * returns information of the movie by passing in Movie Title as argument
     * @param title - Title of the movie for which user wants information
     * @return - returns information of the movie in JSON format
     * @throws IOException
     */

    public static Response get_by_title(String title) throws IOException {
        RestAssured.baseURI = DataConstants.getBaseURL();
        Map<String, String> queryPar = queryParams();
        queryPar.put("t", title);
        RequestSpecification request = RestAssured.given().queryParams(queryPar);
        Response titleResponse = request.get();
        return titleResponse;
    }
}
