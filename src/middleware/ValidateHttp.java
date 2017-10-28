package middleware;

import Validation.Middleware;

import javax.servlet.http.HttpServletRequest;

public class ValidateHttp {

    public ValidateHttp(HttpServletRequest httpRequest) {
        Middleware middleware = new Middleware();
        middleware.runValidation(httpRequest);
    }
}
