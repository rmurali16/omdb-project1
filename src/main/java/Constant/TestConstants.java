package Constant;

import utils.DataUtils;

import java.io.IOException;

public class TestConstants  {

    public static String expectedDirector ;
    public static String expectedReleaseDate ;

    public static String expectedPlot ;
    public static String expectedRuntime ;

    public static String title1;
    public static String title2;

    public static String getExpectedDirector() throws IOException {
        expectedDirector = DataUtils.loadProp("director");
           return expectedDirector;
    }

    public static String getExpectedReleaseDate() throws IOException {
        expectedReleaseDate = DataUtils.loadProp("releasedate");
        return expectedReleaseDate;
    }

    public static String getExpectedPlot() throws IOException {
        expectedPlot = DataUtils.loadProp("plot");
        return expectedPlot;
    }

    public static String getExpectedRuntime() throws IOException {
        expectedRuntime = DataUtils.loadProp("runtime");
        return expectedRuntime;
    }

    public static String getTitle1() throws IOException {
        title1 = DataUtils.loadProp("title1");
        return title1;
    }

    public static String getTitle2() throws IOException {
        title2 = DataUtils.loadProp("title2");
        return title2;
    }
}
