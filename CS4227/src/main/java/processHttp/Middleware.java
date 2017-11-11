package processHttp;

import requestManagement.*;
import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.healthCheck.HealthCheck;
import requestManagement.fleetManager.healthCheck.HealthCheckImplementation;
import requestManagement.fleetManager.hosts.Host;
import requestManagement.loadBalancer.LbClientSideRandom;
import requestManagement.loadBalancer.LoadBalancer;
import requests.HttpRequest;
import requests.adapters.HttpServletRequestAdapter;
import responses.HttpResponse;
import validation.HttpValidationService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

import java.util.logging.Logger;



public class Middleware {

    private final static Logger LOGGER = Logger.getLogger(Middleware.class.getName());
    private String responseToUser;

    public Middleware() {}

    public void runMiddleware(HttpServletRequest httpServletRequest) throws IOException {
        Dispatcher dispatcher = new Dispatcher(new ArrayList<Service>());
        FleetManager fleetManager = FleetManager.getInstance();
        LoadBalancer loadBalancer = LoadBalancer.getBuilder()
                .withFleetManager(fleetManager)
                .withLoadBalancingStrategy(new LbClientSideRandom(fleetManager))
                .build();
        HealthCheck healthCheck = new HealthCheckImplementation(fleetManager);

        RequestManager requestManager = RequestManager.getBuilder()
                .withFleetManager(fleetManager)
                .withLoadBalancer(loadBalancer)
                .withDispatcher(dispatcher)
                .withHealthChecker(healthCheck)
                .build();

        Host host = new Host.HostBuilder("192.168.1.1")
                .withDns("httpbin.org")
                .withState("active")
                .withMaxConnections(3)
                .withPort(80)
                .build();

        fleetManager.addHost(host);
        requestManager.initialiseFleet();

        HttpValidationService httpValidationService = new HttpValidationService();
        dispatcher.register(httpValidationService);

        HttpRequest httpRequest = new HttpServletRequestAdapter(httpServletRequest);

        LOGGER.info("Original URL: " + httpServletRequest.getRequestURL());
        LOGGER.info("HTTP Request URL: " + httpRequest.getUri());

        HttpResponse response =  requestManager.handleRequest(httpRequest);

        responseToUser = String.format("Initial Request URL: %s | Response: %s | Status: %s", httpServletRequest.getRequestURL(), response.getStatus(), response.getStatusCode());
    }

    public String getResponseToUser() {
        return responseToUser;
    }
}
