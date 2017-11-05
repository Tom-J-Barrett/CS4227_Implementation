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
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Middleware {

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

        Host testHost = new Host.HostBuilder("192.168.1.1")
                .withDns("httpbin.org")
                .withState("active")
                .build();

        fleetManager.addHost(testHost);

        HttpValidationService httpValidationService = new HttpValidationService();
        dispatcher.register(httpValidationService);

        Context context = new Context();
        HttpRequest httpRequest = new HttpServletRequestAdapter(httpServletRequest);
        context.setEvent(httpRequest);

        dispatcher.dispatchIncomingRequest(context);

        HttpResponse response = loadBalancer.executeRequest(httpRequest);
        JOptionPane.showMessageDialog(null,"Request :" + httpRequest.getUri() + "   Response: " + response.getStatus());
    }
}
