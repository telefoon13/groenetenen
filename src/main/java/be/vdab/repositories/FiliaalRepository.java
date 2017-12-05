package be.vdab.repositories;

import be.vdab.entities.Filiaal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface FiliaalRepository extends JpaRepository<Filiaal,Long>{

	List<Filiaal> findByAdresPostcodeBetweenOrderByNaam(int van, int tot);

	List<Filiaal> findByWaardeGebouwNot(BigDecimal waarde);

}
