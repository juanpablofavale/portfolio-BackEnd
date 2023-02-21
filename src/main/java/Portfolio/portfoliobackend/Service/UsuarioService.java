package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Usuario;
import Portfolio.portfoliobackend.Repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository ur;
    
    @Override
    public List<Usuario> getUsuarios(){
        List<Usuario> lstPers = ur.findAll();
        return lstPers;
    }

    @Override
    public void saveUsuario(Usuario p) {
        ur.save(p);
    }

    @Override
    public void deleteUsuario(Integer id) {
        ur.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Integer id) {
        Usuario p = ur.findById(id).orElse(null);
        return p;
    }
}