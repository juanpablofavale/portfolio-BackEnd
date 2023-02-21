package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> getProyectos();
    
    public void saveProyecto(Proyecto e);
    
    public void deleteProyecto(Integer id);
    
    public Proyecto findProyecto(Integer id);
}