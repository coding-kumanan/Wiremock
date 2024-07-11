import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.stubbing.Scenario.STARTED;

public class WiremockScenarioStatefulBehaviour {
    public WireMockServer wireMockServer;
    @BeforeClass
    public void serverConfiguration(){
        WireMockConfiguration config = WireMockConfiguration.wireMockConfig()
                .port(8082);

        wireMockServer = new WireMockServer(config);
        wireMockServer.start();

        WireMock.configureFor("localhost", 8082);

//        // Initial state: first call
//        stubFor(get(urlEqualTo("/example"))
//                .inScenario("Statefull")
//                .whenScenarioStateIs(STARTED)
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withBody("First response"))
//                .willSetStateTo("Second call"));
//
//        // Second state: second call
//        stubFor(get(urlEqualTo("/example"))
//                .inScenario("Statefull")
//                .whenScenarioStateIs("Second call")
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withBody("Second response"))
//                .willSetStateTo("Third call"));
//
//        // Third state: third call
//        stubFor(get(urlEqualTo("/example"))
//                .inScenario("Statefull")
//                .whenScenarioStateIs("Third call")
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withBody("Third response"))
//                .willSetStateTo(STARTED)); // Reset to STARTED

        System.out.println("WireMock server started..");
        // Keep the server running
        //Runtime.getRuntime().addShutdownHook(new Thread(wireMockServer::stop));
    }

    @Test
    public void statefullTest(){
        Response response = RestAssured.get("http://localhost:8082/example");
        response.prettyPrint();

        Response response2 = RestAssured.get("http://localhost:8082/example");
        response2.prettyPrint();

        Response response3 = RestAssured.get("http://localhost:8082/example");
        response3.prettyPrint();

        Response response4 = RestAssured.get("http://localhost:8082/example");
        response4.prettyPrint();
    }
    @AfterClass
    public void teardown() {
        wireMockServer.stop();
        System.out.println("WireMock server stopped");
    }
}
