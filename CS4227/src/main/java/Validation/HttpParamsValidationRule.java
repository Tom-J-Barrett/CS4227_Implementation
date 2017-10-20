package Validation;

import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;

public class HttpParamsValidationRule implements ValidationRule{

    private HttpRequest http = null;

    protected HttpParamsValidationRule() {    }

    @Override
    public void validate(Object validationData) {
        http = ((HttpRequest) validationData);
        RequestLine requestLine = http.getRequestLine();
        validateHttpParams();
    }

    public boolean validateHttpParams() {
        return Boolean.parseBoolean(null);
    }
}
