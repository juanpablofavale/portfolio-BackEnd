package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Educacion;
import Portfolio.portfoliobackend.Service.IEducacionService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionControladora {
    @Autowired
    private IEducacionService interPers;
    
    @GetMapping("/educaciones/traer")
    public ResponseEntity<List<Educacion>> getEducaciones(){
        return new ResponseEntity(interPers.getEducaciones(), HttpStatus.OK);
        
    }
    
    @PostMapping("/educaciones/crear")
    public ResponseEntity<?> createEducacion(@RequestBody Educacion e){
        interPers.saveEducacion(e);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/educaciones/borrar/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable Integer id){
        interPers.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/educaciones/editar")
    public ResponseEntity<?> editEducacion(@RequestBody Educacion e){
        interPers.saveEducacion(e);
        return new ResponseEntity(new Mensaje("Educacion modificada"), HttpStatus.OK);
    }
}