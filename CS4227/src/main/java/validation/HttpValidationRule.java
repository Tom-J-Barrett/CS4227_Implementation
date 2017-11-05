package validation;

import requests.HttpRequest;

/**
 * Interface used for defining Http Validation Rules
 */
public interface HttpValidationRule {
    void validate(HttpRequest httpRequest) throws Exception;
}
