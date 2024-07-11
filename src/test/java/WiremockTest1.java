import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.*;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WiremockTest1 extends BaseClass {
    WiremockServerConf conf;
    @BeforeClass
    public void startWiremockServer(){
        conf = new WiremockServerConf();
        conf.setWireMockServer();

    }
    @AfterClass
    public void tearDown(){
        conf.stopWireMockServer();
    }
    @Test
    public void mappingBodyFileTest(){
      Response response = (RestAssured.given()
                    .get("http://localhost:8081/mobile"));
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        response.prettyPrint();



    }
    @Test
    public void queryParameterWithTransformersTest(){
        Response response1 = RestAssured.get("http://localhost:8081/transformers?id=123&name=John");
        response1.prettyPrint();

        Response response2 = RestAssured.get("http://localhost:8081/transformers?id=9178&name=kumanan");
        response2.prettyPrint();

        Response response3 = RestAssured.get("http://localhost:8081/transformers?id=8767&name=Ajith");
        response3.prettyPrint();

    }

    @Test
    public void dynamicProxyWithRequestHeader(){
        Response response = RestAssured.given()
                .header("X-WM-Proxy-Url", "https://reqres.in/api/users?page=2").when()
                .get("http://localhost:8081/proxy-example");
        response.prettyPrint();
    }
}
