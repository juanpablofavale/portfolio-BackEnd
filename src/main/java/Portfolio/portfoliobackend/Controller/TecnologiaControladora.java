package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Tecnologia;
import Portfolio.portfoliobackend.Service.ITecnologiaService;
import java.util.List;
import org.aspectj.bridge.Message;
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
public class TecnologiaControladora {
    @Autowired
    private ITecnologiaService interPers;
    
    @GetMapping("/tecnologias/traer")
    public ResponseEntity<List<Tecnologia>> getTecnologiaes(){
        return new ResponseEntity(interPers.getTecnologias(), HttpStatus.OK);
    }
    
    @PostMapping("/tecnologias/crear")
    public ResponseEntity<?> createTecnologia(@RequestBody Tecnologia e){
        interPers.saveTecnologia(e);
        return new ResponseEntity(new Mensaje("Tecnologia creada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/tecnologias/borrar/{id}")
    public ResponseEntity<?> deleteTecnologia(@PathVariable Integer id){
        System.out.println(id);
        interPers.deleteTecnologia(id);
        return new ResponseEntity(new Mensaje("Tecnologia eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/tecnologias/editar")
    public ResponseEntity<?> editTecnologia(@RequestBody Tecnologia t){
        interPers.saveTecnologia(t);
       
        return new ResponseEntity(new Mensaje("Tecnologia modificada"), HttpStatus.OK);
    }
}