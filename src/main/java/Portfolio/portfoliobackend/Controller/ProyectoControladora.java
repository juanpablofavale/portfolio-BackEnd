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
    
    @PutMapping("/proyectos/editar/{id}")
    public Proyecto editProyecto(@PathVariable Integer id,
                               @RequestParam ("nombre") String nuevoNombre,
                               @RequestParam ("imagen") String nuevoImagen,
                               @RequestParam ("descripcion") String nuevoDescripcion,
                               @RequestParam ("enlace") String nuevoEnlace,
                               @RequestParam ("persona_id") int nuevaPersonaId){
               
        Proyecto pro = interPers.findProyecto(id);
        
        pro.setNombre(nuevoNombre);
        pro.setImagen(nuevoImagen);
        pro.setDescripcion(nuevoDescripcion);
        pro.setEnlace(nuevoEnlace);
        pro.setPersona_int(nuevaPersonaId);
        
        interPers.saveProyecto(pro);
       
        return pro;
    }
}