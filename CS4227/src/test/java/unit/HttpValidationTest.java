package unit;

import org.junit.jupiter.api.Test;
import requests.HttpRequest;
import validation.HttpValidationService;

import javax.servlet.http.HttpServletRequest;

/**
 * Testing for validation service.
 */
class HttpValidationTest {

    @Test
    void testValidationService() throws Exception {
        HttpRequest request = HttpRequest.getBuilder()
                .withUri("https://my-other-super-random-example-middleware-host.com/get?sample_arg=1")
                .withMethod("GET")
                .build();

        HttpValidationService httpValidationService = new HttpValidationService();
        httpValidationService.validateHttp(request);
    }

}
