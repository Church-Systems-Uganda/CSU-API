package csu.services.admin.church;
import java.util.List;
import java.util.Optional;

import csu.model.admin.Church.PersonChurch;
import csu.model.membership.Ministry;
import csu.payload.admin.PersonChurchMinistry.PersonChurchMinistrypayload;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class PersonChurchMinistryService {

    @PersistenceContext
    private EntityManager em;

    public List<PersonChurchMinistrypayload> getAll() {
        return em.createQuery("SELECT pcm FROM PersonChurchMinistrypayload pcm", PersonChurchMinistrypayload.class)
            .getResultList();
    }

    public Optional<PersonChurchMinistrypayload> getById(Long id) {
        return Optional.ofNullable(em.find(PersonChurchMinistrypayload.class, id));
    }

   
}
