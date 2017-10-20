package Validation;

import requestManagement.Context;
import requestManagement.Service;

public class ValidationService implements Service {

    public void processIncomingRequest(Context context) {
        ValidationRule validationRule = new HttpValidationRule();
    }

    public void processOutgoingResponse(Context context) {

    }
}
