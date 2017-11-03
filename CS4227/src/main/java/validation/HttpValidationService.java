package validation;

import requestManagement.Context;
import requestManagement.Service;
import requests.HttpRequest;

import java.util.List;

/**
 * Service used for HTTP validation
 */
public class HttpValidationService implements Service {

    public void processIncomingRequest(Context context) {
        HttpRequest httpRequest = (HttpRequest) context.getEvent();
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
        HttpValidationRuleFactory httpValidationRuleFactory = new HttpValidationRuleFactory();
        List<HttpValidationRule> rules = httpValidationRuleFactory.getRulesToRun(http.getMethod());

        for (HttpValidationRule rule : rules){
            rule.validate(http);
        }
    }
}
