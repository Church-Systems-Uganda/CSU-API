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

    
    public PersonChurchMinistrypayload getById(@PathParam("id") Long id) {
        Optional<PersonChurchMinistrypayload> optionalPayload = service.getById(id);
        return optionalPayload.orElse(null);
    }

    
   
    // Additional methods can be added as necessary
}
