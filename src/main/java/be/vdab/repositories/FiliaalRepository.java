package be.vdab.repositories;

import be.vdab.entities.Filiaal;

import java.util.List;
import java.util.Optional;

public interface FiliaalRepository {
	void create(Filiaal filiaal);
	Optional<Filiaal> read(long id);
	void update(Filiaal filiaal);
	void delete(long id);
	List<Filiaal> findAll();
	long findAantalFilialen();
	long findAantalWerknemers(long id);
}
