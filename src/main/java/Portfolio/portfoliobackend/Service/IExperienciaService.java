package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> getExperiencias();
    
    public void saveExperiencia(Experiencia e);
    
    public void deleteExperiencia(Integer id);
    
    public Experiencia findExperiencia(Integer id);
}