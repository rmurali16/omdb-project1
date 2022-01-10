package APIAction;

import Constant.DataConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class APICalls {


    /**
     *
     * @param searchString search title of the movie needed
     * @param pagination - takes pagination into account if more than >10 results per page
     * @return returns the Api Response of the searchString
     * @throws IOException
     */
    public static Response searchOMDB(String searchString, String pagination) throws IOException {
        Map<String, String> params = new HashMap<>();
        RestAssured.baseURI = DataConstants.getBaseURL();
        String apiKey = DataConstants.getApiKey();
        params.put("apikey",apiKey);
        params.put("s",searchString);

        //To handle the pagination of the response using null
        //If it is null, query param is not added
        if(pagination != null) {
            params.put("page", pagination);
        }
        RequestSpecification request = RestAssured.given().queryParams(params);
        Response response = request.get();

        return response;
    }

    /**
     *
     * @param searchString search title of the movie needed
     * @return a list of movie titles in the list taking pagination into account.
     * @throws IOException
     */
    public static List<String> listOfTitles(String searchString) throws IOException {
        ArrayList<String> titlesList = new ArrayList<String>();
        for(int i = 1; i < 100; i++) {
            Response response = searchOMDB(searchString, String.valueOf(i));
            if (response.jsonPath().getString("Response").equals("True")) {
                titlesList.addAll(response.jsonPath().getList("Search.Title"));
            }
            else{
                break;
            }
        }
        return titlesList;
    }

    /**
     *
     * @param searchString - search a movie title
     * @param movieTitle - Movie title to get the IMDB Id
     * @return returns the IMDB Id of the movie Title
     * @throws IOException
     */
    public static String get_Id_from_Search_List_Movie_title(String searchString, String movieTitle ) throws IOException {
        Map<String, String> id_Title_Map = new HashMap<String, String>();
        for (int i = 1; i < 100; i++) {
            Response response = searchOMDB(searchString, String.valueOf(i));
            if (response.jsonPath().getString("Response").equals("True")) {
                for (int j = 0; j < 10; j++) {
                    String id = response.jsonPath().getString("Search[" + j + "].imdbID");
                    String title = response.jsonPath().getString("Search[" + j + "].Title");
                    id_Title_Map.put(title, id);
                }
            }
            else{
                break;
            }
        }
        String Id_title = id_Title_Map.get(movieTitle);
        return Id_title;
    }
}
