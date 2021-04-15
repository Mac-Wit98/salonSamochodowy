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
public class KlienciDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public KlienciDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Klienci> list() {
		String sql = "SELECT * FROM KLIENCI";
		List<Klienci> listKlienci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
		return listKlienci;
	}

	/* (C)reate - Insert new record */
	public void save(Klienci klienci) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("klienci").usingColumns("imie", "nazwisko", "data_urodzenia", "plec", "pesel",
				"nr_telefonu", "adres_email", "nr_adresu", "nr_salon");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klienci);
		insertActor.execute(param);
	}

	public Klienci get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM KLIENCI WHERE NR_KLIENTA = " + args[0];
		Klienci klienci = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klienci.class));
		return klienci;
	}

	/* (U)pdate - data inside database */
	public void update(Klienci klienci) {
		String sql = "UPDATE KLIENCI SET imie=:imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia, plec=:plec, pesel=:pesel,"
				+ " nr_telefonu=:nr_telefonu, adres_email=:adres_email, nr_adresu=:nr_adresu, nr_salon=:nr_salon   WHERE nr_klienta=:nr_klienta";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klienci);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */

	public void delete(int id) {
		String sql = "DELETE FROM KLIENCI WHERE NR_KLIENTA = ?";
		jdbcTemplate.update(sql, id);
	}
}
