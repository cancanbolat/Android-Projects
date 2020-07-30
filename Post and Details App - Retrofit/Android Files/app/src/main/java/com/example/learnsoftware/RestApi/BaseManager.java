package com.example.learnsoftware.RestApi;

public class BaseManager {

    protected RestApi getRestApi(){
        RestApiClient restApiClient = new RestApiClient(Base_URL.base_url);
        return restApiClient.getRestApi();
    }

}
