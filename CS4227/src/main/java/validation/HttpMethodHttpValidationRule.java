package validation;

import requests.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to validate methods of HTTP requests.
 */
public class HttpMethodHttpValidationRule implements HttpValidationRule {


    protected HttpMethodHttpValidationRule() {

    }

    @Override
    public void validate(HttpRequest httpRequest) throws Exception {
        String method = httpRequest.getMethod();
        List<String> methods = getHttpMethods();

        if(!(methods.contains(method))) {
            throw new Exception(exceptionMessage());
        }
    }

    private List<String> getHttpMethods() {
        List<String> methods = new ArrayList<>();
        methods.add("GET");
        methods.add("HEAD");
        methods.add("POST");
        methods.add("PUT");
        methods.add("DELETE");
        methods.add("CONNECT");
        methods.add("OPTIONS");
        methods.add("TRACE");

        return methods;
    }

    @Override
    public String exceptionMessage() { return "Method is invalid"; }
}
