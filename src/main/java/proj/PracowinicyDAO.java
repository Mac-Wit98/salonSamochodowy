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
public class PracowinicyDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PracowinicyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Pracownicy> list() {
		String sql = "SELECT * FROM PRACOWNICY";
		List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
		return listPracownicy;
	}

	/* (C)reate - Insert new record */
	public void save(Pracownicy pracownicy) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("pracownicy").usingColumns("imie", "nazwisko", "data_urodzenia", "plec", "pesel",
				"nr_telefonu", "adres_email", "data_zatrudnienia", "nr_salon", "nr_adresu", "nr_stanowiska");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
		insertActor.execute(param);
	}

	public Pracownicy get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM PRACOWNICY WHERE NR_PRACOWNIKA = " + args[0];
		Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
		return pracownicy;
	}

	/* (U)pdate - data inside database */
	public void update(Pracownicy pracownicy) {
		String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia, plec=:plec, pesel=:pesel,"
				+ " nr_telefonu=:nr_telefonu, data_zatrudnienia=:data_zatrudnienia, nr_salon=:nr_salon, nr_adresu=:nr_adresu, nr_stanowiska=:nr_stanowiska   WHERE nr_pracownika=:nr_pracownika";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */

	public void delete(int id) {
		String sql = "DELETE FROM PRACOWNICY WHERE NR_PRACOWNIKA = ?";
		jdbcTemplate.update(sql, id);
	}
}
