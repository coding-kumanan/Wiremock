import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockTest extends BaseClass {
 public WireMockServer wireMockServer;

@BeforeClass
    public void setWireMockServer()  {
    wireMockServer =new WireMockServer(8080);
    wireMockServer.start();
    configureFor("localhost", 8080);
    stubFor(get(urlEqualTo("/test1"))
            .willReturn(aResponse()
                    .withHeader("Content-Type","application/json")
                    .withStatus(200)
                    .withBodyFile("response.json")));

}
@AfterClass
    public  void teardown(){
    wireMockServer.stop();
}
@Test
    public void testSample(){
    given();
    addMethodType("GET","http://localhost:8080/test1");
    System.out.println(response().getContentType());
    System.out.println(response().getStatusCode());
    System.out.println(printResponseBody());
    //Assert.assertEquals(getStatusCode(),200);

}

}
