package Validation;

import org.apache.http.HttpRequest;
import requestManagement.*;

import java.util.ArrayList;

public class Middleware {
    public Middleware() {
        System.out.println("Validation.Middleware code!");
    }

    public void Middleware(Object httpRequest) {
        Dispatcher dispatcher = new Dispatcher(new ArrayList<Service>());
        ValidationService validationService = new ValidationService();
        dispatcher.register(validationService);
        Context context = new Context();
        context.setEvent(((HttpRequest) httpRequest));
        validationService.processIncomingRequest(context);
    }
}
