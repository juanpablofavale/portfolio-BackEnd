package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Experiencia;
import Portfolio.portfoliobackend.Repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository exr;
    
    @Override
    public List<Experiencia> getExperiencias(){
        List<Experiencia> lstPers = exr.findAll();
        return lstPers;
    }

    @Override
    public void saveExperiencia(Experiencia p) {
        exr.save(p);
    }

    @Override
    public void deleteExperiencia(Integer id) {
        exr.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Integer id) {
        Experiencia e = exr.findById(id).orElse(null);
        return e;
    }
}
