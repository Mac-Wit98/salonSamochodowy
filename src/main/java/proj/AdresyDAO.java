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
public class AdresyDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AdresyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Adresy> list() {
		String sql = "SELECT * FROM ADRESY";
		List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
		return listAdresy;
	}

	/* (C)reate - Insert new record */
	public void save(Adresy adresy) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("adresy").usingColumns("miasto", "ulica", "nr_lokalu", "nr_poczty");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
		insertActor.execute(param);
	}

	/* (R)ead - read data from database */
	public Adresy get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM ADRESY WHERE NR_ADRESU = " + args[0];
		Adresy adresy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
		return adresy;
	}

	/* (U)pdate - data inside database */
	public void update(Adresy adresy) {
		String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, nr_lokalu=:nr_lokalu, nr_poczty=:nr_poczty"
				+ " WHERE nr_adresu=:nr_adresu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */
	public void delete(int id) {
		String sql = "DELETE FROM ADRESY WHERE NR_ADRESU = ?";
		jdbcTemplate.update(sql, id);
	}
}
