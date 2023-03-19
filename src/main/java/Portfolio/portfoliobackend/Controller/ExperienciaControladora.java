package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Experiencia;
import Portfolio.portfoliobackend.Service.IExperienciaService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://juanpablofavale-portfolio.web.app/")
public class ExperienciaControladora {

    @Autowired
    private IExperienciaService interPers;
    
    @GetMapping("/experiencias/traer")
    public ResponseEntity<List<Experiencia>> getExperienciaes(){
        return new ResponseEntity(interPers.getExperiencias(), HttpStatus.OK);
    }
    
    @PostMapping("/experiencias/crear")
    public ResponseEntity<?> createExperiencia(@RequestBody Experiencia e){
        interPers.saveExperiencia(e);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/experiencias/borrar/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable Integer id){
        interPers.deleteExperiencia(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/experiencias/editar")
    public ResponseEntity<?> editExperiencia(@RequestBody Experiencia e){
        interPers.saveExperiencia(e);
        return new ResponseEntity(new Mensaje("Experiencia modificada"), HttpStatus.OK);
    }
}