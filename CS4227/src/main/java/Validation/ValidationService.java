package Validation;

import requestManagement.Context;
import requestManagement.Service;

import java.util.ArrayList;
import java.util.List;

public class ValidationService implements Service {

    public void processIncomingRequest(Context context) {
        validateHttp(context);
    }

    public void processOutgoingResponse(Context context) {
        validateHttp(context);
    }

    public void validateHttp(Context context) {
        List<ValidationRule> rules = new ArrayList<ValidationRule>();
        rules.add(new HttpValidationRule());

        for ( ValidationRule rule : rules){
            rule.validate(context);
        }
    }
}
