package Validation;

import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;

public class HttpUrlValidationRule implements ValidationRule {

    private HttpRequest http = null;

    protected HttpUrlValidationRule() {    }

    @Override
    public void validate(Object validationData) {
        http = ((HttpRequest) validationData);
        RequestLine requestLine = http.getRequestLine();
        String uri = requestLine.getUri();
        validateHttpUrl(uri);
    }

    public boolean validateHttpUrl(String method) {
        return Boolean.parseBoolean(null);
    }
}
