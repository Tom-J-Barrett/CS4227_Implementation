package middleware;

import processHttp.Middleware;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ProcessHttpRequest {

    public ProcessHttpRequest(HttpServletRequest httpRequest) throws IOException {
        Middleware middleware = new Middleware();
        middleware.runMiddleware(httpRequest);
    }
}
