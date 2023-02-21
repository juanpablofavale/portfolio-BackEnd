package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Experiencia;
import Portfolio.portfoliobackend.Service.IExperienciaService;
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
public class ExperienciaControladora {

    @Autowired
    private IExperienciaService interPers;
    
    @GetMapping("/experiencias/traer")
    public List<Experiencia> getExperienciaes(){
        return interPers.getExperiencias();
    }
    
    @PostMapping("/experiencias/crear")
    public String createExperiencia(@RequestBody Experiencia e){
        interPers.saveExperiencia(e);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/experiencias/borrar/{id}")
    public String deleteExperiencia(@PathVariable Integer id){
        interPers.deleteExperiencia(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/experiencias/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Integer id,
                               @RequestParam ("img_logo") String nuevoImgLogo,
                               @RequestParam ("nombre_empresa") String nuevoNombreEmpresa,
                               @RequestParam ("puesto") String nuevoPuesto,
                               @RequestParam ("fecha_desde") Date nuevoFechaDesde,
                               @RequestParam ("fecha_hasta") Date  nuevoFechaHasta,
                               @RequestParam ("persona_id") int nuevaPersonaId){
        
        Experiencia e = interPers.findExperiencia(id);
              
        e.setImg_logo(nuevoImgLogo);
        e.setNombre_empresa(nuevoNombreEmpresa);
        e.setPuesto(nuevoPuesto);
        e.setFecha_desde(nuevoFechaDesde);
        e.setFecha_hasta(nuevoFechaHasta);
        e.setPersona_id(nuevaPersonaId);
        
        interPers.saveExperiencia(e);
       
        return e;
    }
}