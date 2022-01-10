import APIAction.APICalls;
import APIAction.APiCalls2;
import Constant.DataConstants;
import Constant.TestConstants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class APITests {

    @Test
    public void verifySearchAndTitles () throws IOException {
        String searchString = DataConstants.getSearchString();
        String title1 =TestConstants.getTitle1();
        String title2 = TestConstants.getTitle2();
        Response response = APICalls.searchOMDB(searchString,null);
        Assert.assertEquals(response.statusCode(),200,"API call failed");

        APICalls.get_Id_from_Search_List_Movie_title(searchString,title2);
        int results_size = Integer.parseInt(response.jsonPath().getString("totalResults"));
        // Assert that list has more than 30 search results
        Assert.assertTrue(results_size > 30);

        //verify if list contains two titles declared in api.properties file.
        Assert.assertTrue(APICalls.listOfTitles(searchString).contains(title1)
        ,"List does not contain"+ title1);
        Assert.assertTrue(APICalls.listOfTitles(searchString).contains(title2),
                "List does not contain"+ title2);
    }

    @Test
    public void verifyReleaseDateDirector () throws IOException {
        String searchString = DataConstants.getSearchString();
        String title2 = TestConstants.getTitle2();
        String Id = APICalls.get_Id_from_Search_List_Movie_title(searchString,title2);
        Response response = APiCalls2.get_by_Id(Id);
        // verify status code before proceed with test
        Assert.assertEquals(response.statusCode(),200,"API call failed");

        String actualReleaseDate = response.jsonPath().getString("Released");
        String actualDirector = response.jsonPath().getString("Director");
        // Assertion for Release date and Director
        Assert.assertEquals(actualReleaseDate,TestConstants.getExpectedReleaseDate());
        Assert.assertEquals(actualDirector,TestConstants.getExpectedDirector());
    }

   @Test
    public void verifyPlotForTitle() throws IOException {
       String title1 =TestConstants.getTitle1();
       Response response = APiCalls2.get_by_title(title1);
       String plotActual = response.jsonPath().getString("Plot");
       String runtimeActual = response.jsonPath().getString("Runtime");
       Assert.assertEquals(response.statusCode(),200,"API call failed");

       //Assertion for runtime and Expected plot
       Assert.assertTrue(plotActual.contains(TestConstants.getExpectedPlot().toLowerCase()));
       Assert.assertEquals(runtimeActual,TestConstants.getExpectedRuntime());
   }
}
