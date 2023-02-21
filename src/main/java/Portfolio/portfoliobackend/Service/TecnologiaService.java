package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Tecnologia;
import Portfolio.portfoliobackend.Repository.TecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService{
    
    @Autowired
    private TecnologiaRepository tr;
    
    @Override
    public List<Tecnologia> getTecnologias(){
        List<Tecnologia> lstPers = tr.findAll();
        return lstPers;
    }

    @Override
    public void saveTecnologia(Tecnologia p) {
        tr.save(p);
    }

    @Override
    public void deleteTecnologia(Integer id) {
        tr.deleteById(id);
    }

    @Override
    public Tecnologia findTecnologia(Integer id) {
        Tecnologia p = tr.findById(id).orElse(null);
        return p;
    }
}