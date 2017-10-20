package Validation;

import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;

public class HttpMethodValidationRule implements ValidationRule {

    private HttpRequest http = null;

    protected HttpMethodValidationRule() {

    }

    @Override
    public void validate(Object validationData) {
        http = ((HttpRequest) validationData);
        RequestLine requestLine = http.getRequestLine();
        String method = requestLine.getMethod();
        validateHttpMethod(method);
    }

    public boolean validateHttpMethod(String method) {
        return Boolean.parseBoolean(null);
    }
}
