import Validation.ValidationService;
import requestManagement.*;

import java.util.ArrayList;
import java.util.List;

public class Middleware {
    public static void main(String [] args) {
        Dispatcher dispatcher = new Dispatcher(new ArrayList<Service>());
        ValidationService validationService = new ValidationService();
        dispatcher.register(validationService);
        validationService.processIncomingRequest(new Context());
    }
}
