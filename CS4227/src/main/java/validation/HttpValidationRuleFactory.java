package validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to return a list of validation rules for a HTTP request.
 * This class adds a parameter validation rule if there is a post request.
 * This can easily be extended for other methods and rules.
 */
public class HttpValidationRuleFactory {

    HttpValidationRuleFactory() {    }

    public List<HttpValidationRule> getRulesToRun(String method) {
        List<HttpValidationRule> listOfRules = new ArrayList<>();
        listOfRules.add(new HttpMethodHttpValidationRule());
        listOfRules.add(new HttpUriHttpValidationRule());

        switch (method) {
            case "POST" : listOfRules = getPostRequestValidation(listOfRules); break;
        }

        return listOfRules;
    }

    private List<HttpValidationRule> getPostRequestValidation(List<HttpValidationRule> listOfRules) {
        listOfRules.add(new HttpParamsHttpValidationRule());

        return listOfRules;
    }
}
