package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Persona;
import Portfolio.portfoliobackend.Service.IPersonaService;
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
public class PersonaControladora {
    @Autowired
    private IPersonaService interPers;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return interPers.getPersonas();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona e){
        interPers.savePersona(e);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Integer id){
        interPers.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Integer id,
                               @RequestParam ("nombre_y_apellido") String nuevoNombreyApellido,
                               @RequestParam ("img_perfil") String nuevoImgPerfil,
                               @RequestParam ("subtitulo") String nuevoSubtitulo,
                               @RequestParam ("acerca") String nuevoAcerca,
                               @RequestParam ("usuario_id") int nuevoUsuarioId){
        
        Persona p = interPers.findPersona(id);
        
        
        p.setNombre_y_apellido(nuevoNombreyApellido);
        p.setImg_perfil(nuevoImgPerfil);
        p.setSubtitulo(nuevoSubtitulo);
        p.setAcerca(nuevoAcerca);
        p.setUsuario_id(nuevoUsuarioId);
        
        interPers.savePersona(p);
       
        return p;
    }
}