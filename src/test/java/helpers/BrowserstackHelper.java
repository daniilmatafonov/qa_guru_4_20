package helpers;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static tests.browserstack.BrowserstackTestBase.BROWSER_STACK_CONFIG;


public class BrowserstackHelper {

    public static final String BROWSER_STACK_SESSIONS = "https://api-cloud.browserstack.com/app-automate/sessions/";

    public static String getBrowserstackVideoUrl(String sessionId) {
        String video_url = given()
                .auth().basic(BROWSER_STACK_CONFIG.browserstackUser(), BROWSER_STACK_CONFIG.browserstackKey())
                .when()
                .get(BROWSER_STACK_SESSIONS + sessionId +".json")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .path("automation_session.video_url");

        System.out.println("video_url: " + video_url);
        return video_url;
    }

    public static String getBSPublicLink(String sessionId){
        String publicUrl = given()
                .auth().basic(BROWSER_STACK_CONFIG.browserstackUser(), BROWSER_STACK_CONFIG.browserstackKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .path("automation_session.public_url");

        System.out.println("bs_public_url: " + publicUrl);
        System.out.println("bs_build_url: " + publicUrl.split("/sessions/")[0]);
        return publicUrl;
    }
}
