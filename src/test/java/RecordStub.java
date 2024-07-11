import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class RecordStub extends BaseClass {
    WiremockServerConf conf;
    @BeforeClass
    public void startServer() {
      conf = new WiremockServerConf();
      conf.setWireMockServer();
    }
    @AfterClass
    public void stopServer(){
        conf.stopWireMockServer();
    }

    @Test
    public void recordStub() {
        String startUrl = "http://localhost:8081/__admin/recordings/start";
        String targetBaseUrl = "http://examples.wiremockapi.cloud/";
        Response response = RestAssured.given()
                .body("{\n" +
                        "  \"targetBaseUrl\": \"http://examples.wiremockapi.cloud\"\n" +
                        "}")
                .post(startUrl);
        //System.out.println(response.getBody().asString());

        Response response1 = RestAssured.get("http://localhost:8081/recordables/123");
        System.out.println(response1.getBody().asString());
        Response response2 = RestAssured.post("http://localhost:8081/__admin/recordings/stop");
        System.out.println(response2.getBody().asString());



    }
}