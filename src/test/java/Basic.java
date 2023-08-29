import io.restassured.RestAssured;

public class Basic {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://4bd9fe62-42a6-4cb2-9428-75ede561f37c.mock.pstmn.io";
        //Get method
        //RestAssured theo given(endpoint) -> when (send request) -> then (validate)
        //then -> log() xem log -
        RestAssured.given().queryParam("categories", "lawn-care")
                .header("Content-type", "application/json")
                .when().get("users")
                .then().log().all().assertThat().statusCode(200)
                .header("Content-type", "application/json; charset=utf-8");

    }
}
