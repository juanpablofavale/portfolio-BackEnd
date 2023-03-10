package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Persona;
import Portfolio.portfoliobackend.Service.IPersonaService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControladora {
    @Autowired
    private IPersonaService interPers;
    
    @GetMapping("/personas/traer")
    public ResponseEntity<List<Persona>> getPersonas(){
        return new ResponseEntity(interPers.getPersonas(), HttpStatus.OK);
        
    }
    
    @PostMapping("/personas/crear")
    public ResponseEntity<?> createPersona(@RequestBody Persona e){
        interPers.savePersona(e);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Integer id){
        interPers.deletePersona(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/personas/editar")
    public ResponseEntity<?> editPersona(@RequestBody Persona p){
        interPers.savePersona(p);
        return new ResponseEntity(new Mensaje("Persona modificada"), HttpStatus.OK);
    }
}