package Validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationRuleFactory {

    ValidationRuleFactory() {    }

    public List<ValidationRule> getRulesToRun() {
        List<ValidationRule> listOfRules = new ArrayList<ValidationRule>();
        listOfRules.add(new HttpMethodValidationRule());
        listOfRules.add(new HttpUrlValidationRule());
        listOfRules.add(new HttpParamsValidationRule());

        return listOfRules;
    }
}
