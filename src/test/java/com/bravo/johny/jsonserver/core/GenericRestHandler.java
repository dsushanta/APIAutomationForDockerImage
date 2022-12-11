package com.bravo.johny.jsonserver.core;

import com.bravo.johny.jsonserver.config.LogConfig;
import com.bravo.johny.jsonserver.dtos.request.IRequest;
import com.bravo.johny.jsonserver.config.Constants;
import com.bravo.johny.jsonserver.config.Enums;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public final class GenericRestHandler {

    private static GenericRestHandler instance;
    private final RequestSpecBuilder builder;

    private GenericRestHandler() {
        builder = new RequestSpecBuilder();
    }

    public static GenericRestHandler getInstance() {
        if (instance == null){
            synchronized (GenericRestHandler.class) {
                if(instance == null) {
                    instance = new GenericRestHandler();
                }
            }
        }

        return instance;
    }

    private RequestSpecification setRequestSpecification() {
        RequestSpecification requestSpecification = builder
                .setBaseUri(AppConfigManager.getInstance().getAppSettingsConfig(Constants.AppSettings.baseURL))
                .addFilter(RequestLoggingFilter.logRequestTo(LogConfig.log))
                .addFilter(ResponseLoggingFilter.logResponseTo(LogConfig.log))
                .build();

        return RestAssured
                .given()
                .spec(requestSpecification).log().all();
    }

    public ResponseOptions<Response> ExecuteAPI(String url, Enums.HTTP_METHOD method) {
        ResponseOptions<Response> response;
        RequestSpecification request = setRequestSpecification();

        switch (method) {
            case GET:
                response = request.get(url);
                break;
            case POST:
                response = request.post(url);
                break;
            case PUT:
                response = request.put(url);
                break;
            case DELETE:
                response = request.delete(url);
                break;
            default:
                throw new RuntimeException("Unsupported HTTP Method !!");

        }
        return response;
    }

    public GenericRestHandler addHeaders(Map<String, String> headers) {
        builder.addHeaders(headers);
        return this;
    }

    public GenericRestHandler addHeader(String key, String value) {
        builder.addHeader(key, value);
        return this;
    }

    public GenericRestHandler setPathParam(Map<String, String> params) {
        builder.addPathParams(params);
        return this;
    }

    public GenericRestHandler addQueryParam(Map<String, String> params) {
        builder.addQueryParams(params);
        return this;
    }

    public GenericRestHandler addBody(IRequest body) {
        builder
                .setBody(body)
                .setContentType(ContentType.JSON);
        return this;
    }

    /*

    public <T extends BaseResponse> T getRequest(String url, Class<T> cls) {

        var response = given()
                .spec(requestSpecification)
                .when()
                .get(url)
                .then()
                .log().all()
                .extract()
                .response().as(cls);


        return response;
    }

    public <T extends BaseResponse> T postRequest(String url, BaseRequest payload, Class<T> cls) {

        var response = given()
                .spec(requestSpecification)
                .contentType("application/json")
                .body(payload)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract()
                .response().as(cls);

        return response;
    }*/
}
