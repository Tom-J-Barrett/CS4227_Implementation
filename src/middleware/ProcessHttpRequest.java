package middleware;

import processHttp.Middleware;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ProcessHttpRequest {

    private Middleware middleware;

    public ProcessHttpRequest(HttpServletRequest httpRequest) throws IOException {
        middleware = new Middleware();
        middleware.runMiddleware(httpRequest);
    }

    public String getResponse(){
        return middleware.getResponseToUser();
    }
}
