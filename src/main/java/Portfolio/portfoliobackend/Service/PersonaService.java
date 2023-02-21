package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Persona;
import Portfolio.portfoliobackend.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository pr;
    
    @Override
    public List<Persona> getPersonas(){
        List<Persona> lstPers = pr.findAll();
        return lstPers;
    }

    @Override
    public void savePersona(Persona p) {
        pr.save(p);
    }

    @Override
    public void deletePersona(Integer id) {
        pr.deleteById(id);
    }

    @Override
    public Persona findPersona(Integer id) {
        Persona p = pr.findById(id).orElse(null);
        return p;
    }
}
