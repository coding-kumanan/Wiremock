import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.PostServeAction;
import com.github.tomakehurst.wiremock.extension.PostServeActionDefinition;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveRequestBodyToFile extends PostServeActionDefinition {

    public SaveRequestBodyToFile(String name, Parameters parameters) {
        super(name, parameters);
    }

    public String getName() {
        return "SaveRequestBodyToFile";
    }
    public void doAction(Request request, Response response, Parameters parameters)  {
        String body = request.getBodyAsString();
        String fileName = parameters.getString("filename","default-payload.json");
        try {
            Files.write(Paths.get("/Users/kumanan/Documents/Wiremock/src/test/resources/__files"+fileName),body.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
