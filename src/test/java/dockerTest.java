import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class dockerTest {

    @Test
    public void test1(){
        Response response = RestAssured.get("http://localhost:8080/example");
        response.prettyPrint();
    }
}
