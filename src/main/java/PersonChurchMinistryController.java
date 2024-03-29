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

    
    public PersonChurchMinistrypayload create(PersonChurchMinistrypayload payload) {
        return service.create(payload);
    }

    public void deleteById(@PathParam("id") Long id) {
        service.deleteById(id);
    }
    
    // Additional methods can be added as necessary
}
