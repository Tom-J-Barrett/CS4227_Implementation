package Validation;

import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;

public class HttpParamsValidationRule implements ValidationRule {

    private HttpRequest http = null;

    protected HttpParamsValidationRule() {
    }

    @Override
    public void validate(Object validationData) throws Exception {
        http = ((HttpRequest) validationData);
        RequestLine requestLine = http.getRequestLine();
        String params = requestLine.toString();
        try {
            validateHttpParams(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateHttpParams(String params) throws Exception {
        boolean invalid = false;

        if (invalid) {
            throw new Exception(exceptionMessage());
        }
    }

    @Override
    public String exceptionMessage() {
        return "Params are invalid";
    }
}
