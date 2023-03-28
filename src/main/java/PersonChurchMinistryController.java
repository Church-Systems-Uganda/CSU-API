import java.util.List;
import java.util.Optional;

import csu.payload.admin.PersonChurchMinistry.PersonChurchMinistrypayload;
import csu.services.admin.church.PersonChurchMinistryService;
import jakarta.websocket.server.PathParam;


public class PersonChurchMinistryController {

    
    private PersonChurchMinistryService service;

   
    public List<PersonChurchMinistrypayload> getAll() {
        return service.getAll();
    }

    
    
}
