package validation;

import requests.HttpRequest;

import java.net.URL;

/**
 * Class used to validate URI of HTTP requests.
 */
public class HttpUriHttpValidationRule implements HttpValidationRule {

    protected HttpUriHttpValidationRule() {}

    @Override
    public void validate(HttpRequest httpRequest) throws Exception {
        String uri = httpRequest.getUri();

        URL url;
        try {
            url = new URL(uri);
        } catch (Exception ex) {
            throw new RuntimeException(getExceptionMessage());
        }
    }

    public String getExceptionMessage() {
        return "URI is invalid";
    }
}
