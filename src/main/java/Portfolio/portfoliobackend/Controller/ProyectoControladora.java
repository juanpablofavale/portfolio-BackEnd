package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Proyecto;
import Portfolio.portfoliobackend.Service.IProyectoService;
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
public class ProyectoControladora {
    @Autowired
    private IProyectoService interPers;
    
    @GetMapping("/proyectos/traer")
    public List<Proyecto> getProyectoes(){
        return interPers.getProyectos();
    }
    
    @PostMapping("/proyectos/crear")
    public String createProyecto(@RequestBody Proyecto e){
        interPers.saveProyecto(e);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/proyectos/borrar/{id}")
    public String deleteProyecto(@PathVariable Integer id){
        interPers.deleteProyecto(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/proyectos/editar")
    public Proyecto editProyecto(@RequestBody Proyecto pro){
        interPers.saveProyecto(pro);        
        return pro;
    }
}