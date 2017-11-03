package middleware;

import processHttp.Middleware;

import javax.servlet.http.HttpServletRequest;

public class ProcessHttpRequest {

    public ProcessHttpRequest(HttpServletRequest httpRequest) {
        Middleware middleware = new Middleware();
        middleware.runMiddleware(httpRequest);
    }
}
