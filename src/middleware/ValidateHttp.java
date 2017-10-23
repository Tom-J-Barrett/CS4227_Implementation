package middleware;

import Validation.Middleware;

import javax.servlet.http.HttpServletRequest;

public class ValidateHttp {

    public ValidateHttp(HttpServletRequest httpRequest) {
    }

    public ValidateHttp() {
        System.out.println("test");
       // Middleware middleware = new Middleware();
        System.out.println("test2");
    }
}
