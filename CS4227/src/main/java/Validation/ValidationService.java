package Validation;

import org.apache.http.HttpRequest;
import org.apache.http.protocol.HTTP;
import requestManagement.Context;
import requestManagement.Service;

import java.util.ArrayList;
import java.util.List;

public class ValidationService implements Service {
    // add adapter for http mapping
    public void processIncomingRequest(Context context) {
        HttpRequest httpRequest = ((HttpRequest) context.getEvent());
        try {
            validateHttp(httpRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processOutgoingResponse(Context context) {
        HttpRequest httpRequest = ((HttpRequest) context.getEvent());
        try {
            validateHttp(httpRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateHttp(HttpRequest http) throws Exception {
        ValidationRuleFactory validationRuleFactory = new ValidationRuleFactory();
        List<ValidationRule> rules = validationRuleFactory.getRulesToRun();

        for ( ValidationRule rule : rules){
            rule.validate(http);
        }
    }
}
