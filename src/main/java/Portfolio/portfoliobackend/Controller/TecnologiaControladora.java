package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Tecnologia;
import Portfolio.portfoliobackend.Service.ITecnologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TecnologiaControladora {
    @Autowired
    private ITecnologiaService interPers;
    
    @GetMapping("/tecnologias/traer")
    public List<Tecnologia> getTecnologiaes(){
        return interPers.getTecnologias();
    }
    
    @PostMapping("/tecnologias/crear")
    public String createTecnologia(@RequestBody Tecnologia e){
        interPers.saveTecnologia(e);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/tecnologias/borrar/{id}")
    public String deleteTecnologia(@PathVariable Integer id){
        interPers.deleteTecnologia(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/tecnologias/editar/{id}")
    public Tecnologia editTecnologia(@PathVariable Integer id,
                               @RequestParam ("nombre") String nuevoNombre,
                               @RequestParam ("img_logo") String nuevoImgLogo,
                               @RequestParam ("porcentaje") int nuevoPorcentaje,
                               @RequestParam ("persona_id") int nuevaPersonaId){
        
        Tecnologia t = interPers.findTecnologia(id);
              
        t.setNombre(nuevoNombre);
        t.setImg_logo(nuevoImgLogo);
        t.setPorcentaje(nuevoPorcentaje);
        t.setPersona_id(nuevaPersonaId);
    
        interPers.saveTecnologia(t);
       
        return t;
    }
}