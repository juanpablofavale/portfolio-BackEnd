package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> getEducaciones();
    
    public void saveEducacion(Educacion e);
    
    public void deleteEducacion(Integer id);
    
    public Educacion findEducacion(Integer id);
}