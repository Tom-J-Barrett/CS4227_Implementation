package validation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class used to return a list of validation rules for a HTTP request.
 * This class adds a parameter validation rule if there is a post request.
 * This can easily be extended for other methods and rules.
 */
public class HttpValidationRuleFactory {

    private Map<String, Runnable> methodRules;
    private List<HttpValidationRule> listOfRules;

    HttpValidationRuleFactory() {
        methodRules = new HashMap();
        populateMethodRules();
    }

    private void populateMethodRules() {
        methodRules.put("GET", () -> getGetRequestValidation());
        methodRules.put("POST", () -> getPostRequestValidation());
    }

    public List<HttpValidationRule> getRulesToRun(String method) {
        listOfRules = new ArrayList<>();

        methodRules.get(method).run();

        return listOfRules;
    }

    private void getPostRequestValidation() {
        getGetRequestValidation();
        listOfRules.add(new HttpParamsHttpValidationRule());
    }

    private void getGetRequestValidation() {
        listOfRules.add(new HttpMethodHttpValidationRule());
        listOfRules.add(new HttpUriHttpValidationRule());
    }
}
