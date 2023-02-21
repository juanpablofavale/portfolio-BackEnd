package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Tecnologia;
import java.util.List;

public interface ITecnologiaService {
    public List<Tecnologia> getTecnologias();
    
    public void saveTecnologia(Tecnologia e);
    
    public void deleteTecnologia(Integer id);
    
    public Tecnologia findTecnologia(Integer id);
}
