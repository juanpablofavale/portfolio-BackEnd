package Portfolio.portfoliobackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
  
@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String imglogo;
    private String nombreinstitucion;
    private String titulo;
    private String fechadesde;
    private String fechahasta;
    private int personaint;
}