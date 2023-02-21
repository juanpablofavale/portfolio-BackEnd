package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Proyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Portfolio.portfoliobackend.Repository.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository pro;
    
    @Override
    public List<Proyecto> getProyectos(){
        List<Proyecto> lstPers = pro.findAll();
        return lstPers;
    }

    @Override
    public void saveProyecto(Proyecto p) {
        pro.save(p);
    }

    @Override
    public void deleteProyecto(Integer id) {
        pro.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Integer id) {
        Proyecto p = pro.findById(id).orElse(null);
        return p;
    }
}