package Validation;

import org.apache.http.HttpRequest;
import org.apache.http.protocol.HTTP;
import requestManagement.Context;
import requestManagement.Service;

import java.util.ArrayList;
import java.util.List;

public class ValidationService implements Service {

    public void processIncomingRequest(Context context) {
        HttpRequest httpRequest = ((HttpRequest) context.getEvent());
        validateHttp(httpRequest);
    }

    public void processOutgoingResponse(Context context) {
        HttpRequest httpRequest = ((HttpRequest) context.getEvent());
        validateHttp(httpRequest);
    }

    public void validateHttp(HttpRequest http) {
        List<ValidationRule> rules = new ArrayList<ValidationRule>();
        rules.add(new HttpMethodValidationRule());
        rules.add(new HttpUrlValidationRule());
        rules.add(new HttpParamsValidationRule());
        for ( ValidationRule rule : rules){
            rule.validate(http);
        }
    }
}
