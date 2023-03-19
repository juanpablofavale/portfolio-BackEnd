
package Portfolio.portfoliobackend.Controller;

import Portfolio.portfoliobackend.Model.RespuestaUsuario;
import Portfolio.portfoliobackend.Model.Usuario;
import Portfolio.portfoliobackend.Service.IUsuarioService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://juanpablofavale-portfolio.web.app/")
public class UsuarioControladora {
    @Autowired
    private IUsuarioService interPers;
    
    @RequestMapping("/hola")
    public String decirHola(){
        return "Hola!";
    }
    
    @GetMapping("/usuarios/traer")
    public ResponseEntity<List<Usuario>> getUsuarioes(){
        return new ResponseEntity(interPers.getUsuarios(), HttpStatus.OK);
    }
    
    @PostMapping("/usuarios/existe")
    public ResponseEntity<?> getUsuario(@RequestBody Usuario u){
        RespuestaUsuario rta = new RespuestaUsuario("", 0);
        
        String mensaje = "Usuario Inexistente";
        List<Usuario> usuarios = interPers.getUsuarios();
        for(Usuario usu : usuarios){
            if (u.getNombreusuario().equals(usu.getNombreusuario())){
                if(u.getContraseña().equals(usu.getContraseña())){
                    rta.setMensaje("Usuario y Contraseña Correctos");
                    rta.setCodigo(0);
                }else{
                    rta.setMensaje("Contraseña Incorrecta");
                    rta.setCodigo(1);
                }
            }else{
                    rta.setMensaje("Usuario Inexistente");
                    rta.setCodigo(2);
            }
        }
        return new ResponseEntity( rta, HttpStatus.OK);
    }

    @PostMapping("/usuarios/crear")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario e){
        interPers.saveUsuario(e);
        return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/usuarios/borrar/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id){
        interPers.deleteUsuario(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }
    
    @PutMapping("/usuarios/editar")
    public ResponseEntity<?> editUsuario(@RequestBody Usuario u){
        interPers.saveUsuario(u);
       
        return new ResponseEntity(new Mensaje("Usuario modificado"), HttpStatus.OK);
    }
}