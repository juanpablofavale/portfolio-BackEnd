package Portfolio.portfoliobackend.Service;

import Portfolio.portfoliobackend.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> getUsuarios();
    
    public void saveUsuario(Usuario e);
    
    public void deleteUsuario(Integer id);
    
    public Usuario findUsuario(Integer id);
}