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
        if (validateHttpParams())
            System.out.println("HTTP parameters are valid!");
    }

    public boolean validateHttpParams() {
        return true;
    }
}
