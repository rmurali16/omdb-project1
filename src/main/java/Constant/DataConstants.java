package Constant;

import utils.DataUtils;

import java.io.IOException;

public class DataConstants {
    public static String baseUrl;
    public static String apiKey;

    public static String getBaseURL() throws IOException {
        baseUrl = DataUtils.loadProp("baseurl");
        return baseUrl;
    }

    public static String getApiKey() throws IOException {
        apiKey = DataUtils.loadProp("api_key");
        return apiKey;
        }
    public static String getSearchString() throws IOException {
        apiKey = DataUtils.loadProp("search_string");
        return apiKey;
    }
}
