package be.vdab.repositories;

import be.vdab.entities.Filiaal;
import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.PostcodeReeks;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.sql.Date;

@Repository
public class JDBCFiliaalRepository implements FiliaalRepository {

	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private static final String BEGIN_SQL = "select id, naam, hoofdFiliaal, straat, huisNr, postcode, gemeente,inGebruikName, waardeGebouw from filialen ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "order by naam";
	private static final String SQL_FIND_BY_POSTCODE = BEGIN_SQL + "where postcode between :van and :tot order by naam";
	private static final String SQL_READ = BEGIN_SQL + " where id = :id";
	private static final String SQL_FIND_AANTAL_FILIALEN = "select count(*) from filialen";
	private static final String SQL_FIND_AANTAL_WERKNEMERS = "select count(*) from werknemers where filiaalId = ?";
	private final SimpleJdbcInsert simpleJdbcInsert;
	private static final String SQL_DELETE = "delete from filialen where id = ?";
	private static final String SQL_UPDATE = "update filialen set naam=:naam,hoofdFiliaal=:hoofdFiliaal, straat=:straat,huisNr=:huisNr, postcode=:postcode, gemeente=:gemeente, inGebruikName=:inGebruikName, waardeGebouw=:waardeGebouw where id = :id";


	JDBCFiliaalRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("filialen");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
	}

	@Override
	public void update(Filiaal filiaal) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", filiaal.getId());
		parameters.put("naam", filiaal.getNaam());
		parameters.put("hoofdFiliaal", filiaal.isHoofdFiliaal());
		parameters.put("straat", filiaal.getAdres().getStraat());
		parameters.put("huisNr", filiaal.getAdres().getHuisNr());
		parameters.put("postcode", filiaal.getAdres().getPostcode());
		parameters.put("gemeente", filiaal.getAdres().getGemeente());
		parameters.put("inGebruikName", Date.valueOf(filiaal.getInGebruikName()));
		parameters.put("waardeGebouw", filiaal.getWaardeGebouw());
		namedParameterJdbcTemplate.update(SQL_UPDATE, parameters);
	}

	@Override
	public void delete(long id) {
		jdbcTemplate.update(SQL_DELETE, id);
	}

	@Override
	public List<Filiaal> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
	}

	@Override
	public long findAantalFilialen() {
		return jdbcTemplate.queryForObject(SQL_FIND_AANTAL_FILIALEN, Long.class);
	}

	@Override
	public long findAantalWerknemers(long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_AANTAL_WERKNEMERS, Long.class, id);
	}

	@Override
	public Optional<Filiaal> read(long id) {
		Map<String, Long> parameters = Collections.singletonMap("id", id);
		try {
			return Optional.of(namedParameterJdbcTemplate.queryForObject(SQL_READ, parameters, rowMapper));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty(); // record niet gevonden
		}
	}

	@Override
	public void create(Filiaal filiaal) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam", filiaal.getNaam());
		kolomWaarden.put("hoofdFiliaal", filiaal.isHoofdFiliaal());
		kolomWaarden.put("straat", filiaal.getAdres().getStraat());
		kolomWaarden.put("huisNr", filiaal.getAdres().getHuisNr());
		kolomWaarden.put("postcode", filiaal.getAdres().getPostcode());
		kolomWaarden.put("gemeente", filiaal.getAdres().getGemeente());
		kolomWaarden.put("inGebruikName", Date.valueOf(filiaal.getInGebruikName()));
		kolomWaarden.put("waardeGebouw", filiaal.getWaardeGebouw());
		Number id = simpleJdbcInsert.executeAndReturnKey(kolomWaarden);
		filiaal.setId(id.longValue());
	}

	public List<Filiaal> findByPostcodeReeks(PostcodeReeks reeks) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("van", reeks.getVanpostcode());
		parameters.put("tot", reeks.getTotpostcode());
		return namedParameterJdbcTemplate.query(SQL_FIND_BY_POSTCODE, parameters,rowMapper);
	}

	private final RowMapper<Filiaal> rowMapper = (resultSet, rowNum) -> {
		return new Filiaal(resultSet.getLong("id"),
				resultSet.getString("naam"),
				resultSet.getBoolean("hoofdFiliaal"),
				resultSet.getBigDecimal("waardeGebouw"),
				resultSet.getDate("inGebruikName").toLocalDate(),
				new Adres(resultSet.getString("straat"),
						resultSet.getString("huisNr"),
						resultSet.getInt("postcode"),
						resultSet.getString("gemeente")));
	};

}
