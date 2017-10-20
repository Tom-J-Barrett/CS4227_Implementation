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
        if (validateHttpUrl(uri))
            System.out.println("HTTP URI is valid!");
    }

    public boolean validateHttpUrl(String method) {
        return true;
    }
}
