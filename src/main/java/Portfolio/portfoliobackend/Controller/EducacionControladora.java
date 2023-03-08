package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Educacion;
import Portfolio.portfoliobackend.Service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionControladora {
    @Autowired
    private IEducacionService interPers;
    
    @GetMapping("/educaciones/traer")
    public List<Educacion> getEducaciones(){
        return interPers.getEducaciones();
    }
    
    @PostMapping("/educaciones/crear")
    public String createEducacion(@RequestBody Educacion e){
        interPers.saveEducacion(e);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/educaciones/borrar/{id}")
    public String deleteEducacion(@PathVariable Integer id){
        interPers.deleteEducacion(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/educaciones/editar")
    public Educacion editEducacion(@RequestBody Educacion e){
        interPers.saveEducacion(e);
        return e;
    }
}