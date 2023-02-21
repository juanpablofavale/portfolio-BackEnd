package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas();
    
    public void savePersona(Persona e);
    
    public void deletePersona(Integer id);
    
    public Persona findPersona(Integer id);
}
