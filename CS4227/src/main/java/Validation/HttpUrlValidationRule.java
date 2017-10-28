package Validation;

import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;

public class HttpUrlValidationRule implements ValidationRule {

    private HttpRequest http = null;

    protected HttpUrlValidationRule() {    }

    @Override
    public void validate(Object validationData) throws Exception {
        http = ((HttpRequest) validationData);
        RequestLine requestLine = http.getRequestLine();
        String uri = requestLine.getUri();
        try {
            validateHttpUrl(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateHttpUrl(String uri) throws Exception {
        boolean invalid = false;

        if(invalid){
            throw new Exception(exceptionMessage());
        }
    }

    @Override
    public String exceptionMessage() {
        return "URL is invalid";
    }
}
