package Portfolio.portfoliobackend.Repository;

import Portfolio.portfoliobackend.Model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    
}