package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Educacion;
import Portfolio.portfoliobackend.Service.IEducacionService;
import java.util.Date;
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
    
    @PutMapping("/educaciones/editar/{id}")
    public Educacion editEducacion(@PathVariable Integer id,
                               @RequestParam ("img_logo") String nuevoImgLogo,
                               @RequestParam ("nombre_institucion") String nuevoNombreInstitucion,
                               @RequestParam ("titulo") String nuevoTitulo,
                               @RequestParam ("fecha_desde") Date nuevoFechaDesde,
                               @RequestParam ("fecha_hasta") Date  nuevoFechaHasta,
                               @RequestParam ("persona_id") int nuevaPersonaId){
        
        Educacion e = interPers.findEducacion(id);
        
        e.setImg_logo(nuevoImgLogo);
        e.setNombre_institucion(nuevoNombreInstitucion);
        e.setTitulo(nuevoTitulo);
        e.setFecha_desde(nuevoFechaDesde);
        e.setFecha_hasta(nuevoFechaHasta);
        e.setPersona_int(nuevaPersonaId);
        
        interPers.saveEducacion(e);
       
        return e;
    }
}