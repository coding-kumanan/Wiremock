import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class BaseClass {
    static RequestSpecification given;
    static Response post;

    public static void given() {
        given = RestAssured.given();
    }
    public static void contentType(ContentType contentType){
        given = given.contentType(contentType);
    }

    public static void header(String key, String value) {
        given = given.header(key, value);
    }

    public static void body(String reqbody) {
        given = given.body(reqbody);
    }

    public static void body(Object obj) {
        given = given.body(obj);
    }

    public static void body(File file) {
        given = given.body(file);
    }

    public static void addMethodType(String methodType, String url) {
        switch (methodType) {
            case "POST" -> post = given.post(url);
            case "PUT" -> post = given.put(url);
            case "PATCH" -> post = given.patch(url);
            case "DELETE" -> post = given.delete(url);
            case "GET" ->post =given.get(url);
        }

    }
    public static int getStatusCode () {
        return post.statusCode();
    }
    public static String printResponseBody() {
        return post.getBody().asString();
    }
    public static ResponseBody getBody(){
        return post.getBody();
    }
    public static Response response(){
        return post;
    }

}