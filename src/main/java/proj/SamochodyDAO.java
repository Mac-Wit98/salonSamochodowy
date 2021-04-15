package proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class SamochodyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public SamochodyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Samochody> list() {
		String sql = "SELECT * FROM SAMOCHODY";
		List<Samochody> listSamochody = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Samochody.class));
		return listSamochody;
	}

	/* (C)reate - Insert new record */
	public void save(Samochody samochody) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("samochody").usingColumns("rok_produkcji", "skrzynia_biegow", "silnik",
				"liczba_drzwi", "data_gwarancji", "nr_salon", "nr_modelu");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(samochody);
		insertActor.execute(param);
	}

	public Samochody get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM SAMOCHODY WHERE NR_SAMOCHODU = " + args[0];
		Samochody samochody = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Samochody.class));
		return samochody;
	}

	/* (U)pdate - data inside database */
	public void update(Samochody samochody) {
		String sql = "UPDATE SAMOCHODY SET rok_produkcji=:rok_produkcji, skrzynia_biegow=:skrzynia_biegow,"
				+ " silnik=:silnik, liczba_drzwi=:liczba_drzwi, data_gwarancji=:data_gwarancji,"
				+ " nr_salon=:nr_salon, nr_modelu=:nr_modelu  WHERE nr_samochodu=:nr_samochodu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(samochody);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */

	public void delete(int id) {
		String sql = "DELETE FROM SAMOCHODY WHERE NR_SAMOCHODU = ?";
		jdbcTemplate.update(sql, id);
	}
}
