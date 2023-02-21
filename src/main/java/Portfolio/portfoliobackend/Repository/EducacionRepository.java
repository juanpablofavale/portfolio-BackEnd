package Portfolio.portfoliobackend.Repository;

import Portfolio.portfoliobackend.Model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer>{
    
}
