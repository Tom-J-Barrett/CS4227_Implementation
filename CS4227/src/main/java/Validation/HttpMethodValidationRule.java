package Validation;

import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;

public class HttpMethodValidationRule implements ValidationRule {

    private HttpRequest http = null;

    protected HttpMethodValidationRule() {

    }

    @Override
    public void validate(Object validationData) throws Exception {
        http = ((HttpRequest) validationData);
        RequestLine requestLine = http.getRequestLine();
        String method = requestLine.getMethod();
        try {
            validateHttpMethod(method);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateHttpMethod(String method) throws Exception {
        boolean invalid = false;

        if(invalid){
            throw new Exception(exceptionMessage());
        }
    }

    @Override
    public String exceptionMessage() {
        return "Method is invalid";
    }
}
