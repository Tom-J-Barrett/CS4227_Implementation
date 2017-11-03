package validation;

import requests.HttpRequest;

/**
 * Class used to validate parameters of HTTP requests.
 */
public class HttpParamsHttpValidationRule implements HttpValidationRule {

    protected HttpParamsHttpValidationRule() {
    }

    @Override
    public void validate(HttpRequest httpRequest) throws Exception {
        //Would implement for POST requests
    }

    @Override
    public String exceptionMessage() {
        return "Params are invalid";
    }
}
