package Portfolio.portfoliobackend.Repository;

import Portfolio.portfoliobackend.Model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Integer>{
    
}