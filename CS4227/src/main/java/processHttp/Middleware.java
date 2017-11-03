package processHttp;

import requestManagement.*;
import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.healthCheck.HealthCheck;
import requestManagement.fleetManager.healthCheck.HealthCheckImplementation;
import requestManagement.loadBalancer.LoadBalancer;
import requests.HttpRequest;
import requests.adapters.HttpServletRequestAdapter;
import validation.HttpValidationService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class Middleware {

    public Middleware() {}

    public void runMiddleware(HttpServletRequest httpServletRequest) {
        Dispatcher dispatcher = new Dispatcher(new ArrayList<Service>());
        LoadBalancer loadBalancer = null;
        FleetManager fleetManager = FleetManager.getInstance();
        HealthCheck healthCheck = new HealthCheckImplementation(fleetManager);

        RequestManager requestManager = RequestManager.getBuilder()
                .withFleetManager(fleetManager)
                .withLoadBalancer(loadBalancer)
                .withDispatcher(dispatcher)
                .withHealthChecker(healthCheck)
                .build();

        HttpValidationService httpValidationService = new HttpValidationService();
        dispatcher.register(httpValidationService);

        Context context = new Context();
        HttpRequest httpRequest = new HttpServletRequestAdapter(httpServletRequest);
        context.setEvent(httpRequest);

        dispatcher.dispatchIncomingRequest(context);
    }
}
