
package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.Usuario;
import Portfolio.portfoliobackend.Service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioControladora {
    @Autowired
    private IUsuarioService interPers;
    
    @RequestMapping("/hola")
    public String decirHola(){
        return "Hola!";
    }
    
    @GetMapping("/usuarios/traer")
    public List<Usuario> getUsuarioes(){
        return interPers.getUsuarios();
    }
    
    @PostMapping("/usuarios/crear")
    public String createUsuario(@RequestBody Usuario e){
        interPers.saveUsuario(e);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/usuarios/borrar/{id}")
    public String deleteUsuario(@PathVariable Integer id){
        interPers.deleteUsuario(id);
        return "La persona fue eliminada correctamente";
    }
    
    /*@PutMapping("/usuarios/editar/{id}")
    public Usuario editUsuario(@PathVariable Integer id,
                               @RequestParam ("nombre_usuario") String nuevoNombreUsuario,
                               @RequestParam ("contraseña") String nuevaContraseña,
                               @RequestParam ("email") String nuevoEmail,
                               @RequestParam ("telefono") String nuevoTelefono){
        
        Usuario u = interPers.findUsuario(id);

        u.setNombre_usuario(nuevoNombreUsuario);
        u.setContraseña(nuevaContraseña);
        u.setEmail(nuevoEmail);
        u.setTelefono(nuevoTelefono);
        
        interPers.saveUsuario(u);
       
        return u;
    }*/

    @PutMapping("/usuarios/editar/{id}")
    public Usuario editUsuario(@PathVariable Integer id, @RequestBody Usuario us){
        
        Usuario u = interPers.findUsuario(id);

        if (u != null){           
            u.setNombre_usuario(us.getNombre_usuario());
            u.setContraseña(us.getContraseña());
            u.setEmail(us.getEmail());
            u.setTelefono(us.getTelefono());

            interPers.saveUsuario(u);
        }
       
        return u;
    }
}