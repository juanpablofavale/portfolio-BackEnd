package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Educacion;
import Portfolio.portfoliobackend.Repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository er;
    
    @Override
    public List<Educacion> getEducaciones(){
        List<Educacion> lstPers = er.findAll();
        return lstPers;
    }

    @Override
    public void saveEducacion(Educacion p) {
        er.save(p);
    }

    @Override
    public void deleteEducacion(Integer id) {
        er.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Integer id) {
        Educacion p = er.findById(id).orElse(null);
        return p;
    }
}
