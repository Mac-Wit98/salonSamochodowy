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
public class PocztyDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PocztyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Poczty> list() {
		String sql = "SELECT * FROM POCZTY";
		List<Poczty> listPoczty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczty.class));
		return listPoczty;
	}

	/* (C)reate - Insert new record */
	public void save(Poczty poczty) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("poczty").usingColumns("nr_poczty","kod_poczty", "poczta");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczty);
		insertActor.execute(param);
	}

	/* (R)ead - read data from database */
	public Poczty get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM POCZTY WHERE NR_POCZTY = " + args[0];
		Poczty poczty = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Poczty.class));
		return poczty;
	}

	/* (U)pdate - data inside database */
	public void update(Poczty poczty) {
		String sql = "UPDATE POCZTY SET kod_poczty=:kod_poczty, poczta=:poczta WHERE nr_poczty=:nr_poczty";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczty);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */
	public void delete(int id) {
		String sql = "DELETE FROM POCZTY WHERE NR_POCZTY = ?";
		jdbcTemplate.update(sql, id);
	}
}
