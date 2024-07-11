import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
public class WiremockServerConf {
    WireMockServer wireMockServer;
    public void setWireMockServer(){

        WireMockConfiguration configuration = WireMockConfiguration.wireMockConfig()
                .port(8081);

        wireMockServer = new WireMockServer(configuration);
        wireMockServer.start();
    }
    public void stopWireMockServer(){
    wireMockServer.stop();
    }
}
