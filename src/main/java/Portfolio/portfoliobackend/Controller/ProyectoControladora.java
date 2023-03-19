package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Proyecto;
import Portfolio.portfoliobackend.Service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://juanpablofavale-portfolio.web.app/")
public class ProyectoControladora {
    @Autowired
    private IProyectoService interPers;
    
    @GetMapping("/proyectos/traer")
    public ResponseEntity<List<Proyecto>> getProyectoes(){
        return new ResponseEntity(interPers.getProyectos(), HttpStatus.OK);
    }
    
    @PostMapping("/proyectos/crear")
    public ResponseEntity<?> createProyecto(@RequestBody Proyecto e){
        interPers.saveProyecto(e);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/proyectos/borrar/{id}")
    public ResponseEntity<?> deleteProyecto(@PathVariable Integer id){
        interPers.deleteProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PutMapping("/proyectos/editar")
    public ResponseEntity<?> editProyecto(@RequestBody Proyecto pro){
        interPers.saveProyecto(pro);        
        return new ResponseEntity(new Mensaje("Proyecto modificado"), HttpStatus.OK);
    }
}