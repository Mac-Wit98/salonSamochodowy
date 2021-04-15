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
public class MarkiDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MarkiDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Marki> list() {
		String sql = "SELECT * FROM MARKI";
		List<Marki> listMarki = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Marki.class));
		return listMarki;
	}

	/* (C)reate - Insert new record */
	public void save(Marki marki) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("marki").usingColumns("nazwa", "opis");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(marki);
		insertActor.execute(param);
	}

	/* (R)ead - read data from database */
	public Marki get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM MARKI WHERE NR_MARKI = " + args[0];
		Marki marki = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Marki.class));
		return marki;
	}

	/* (U)pdate - data inside database */
	public void update(Marki marki) {
		String sql = "UPDATE MARKI SET nazwa=:nazwa, opis=:opis WHERE nr_marki=:nr_marki";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(marki);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */
	public void delete(int id) {
		String sql = "DELETE FROM MARKI WHERE NR_MARKI = ?";
		jdbcTemplate.update(sql, id);
	}
}
