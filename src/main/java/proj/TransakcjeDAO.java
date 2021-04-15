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
public class TransakcjeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public TransakcjeDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Transakcje> list() {
		String sql = "SELECT * FROM TRANSAKCJE";
		List<Transakcje> listTransakcje = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Transakcje.class));
		return listTransakcje;
	}

	/* (C)reate - Insert new record */
	public void save(Transakcje transakcje) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("transakcje").usingColumns("data", "kwota", "czy_leasing", "data_leasingu",
				"kwota_miesieczna", "nr_klienta", "nr_egzemplarzu");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(transakcje);
		insertActor.execute(param);
	}

	public Transakcje get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM TRANSAKCJE WHERE NR_TRANSAKCJI = " + args[0];
		Transakcje transakcje = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Transakcje.class));
		return transakcje;
	}

	/* (U)pdate - data inside database */
	public void update(Transakcje transakcje) {
		String sql = "UPDATE TRANSAKCJE SET data=:data, kwota=:kwota,"
				+ " czy_leasing=:czy_leasing, data_leasingu=:data_leasingu, kwota_miesieczna=:kwota_miesieczna,"
				+ " nr_klienta=:nr_klienta, nr_egzemplarzu=:nr_egzemplarzu  WHERE nr_transakcji=:nr_transakcji";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(transakcje);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */

	public void delete(int id) {
		String sql = "DELETE FROM TRANSAKCJE WHERE NR_TRANSAKCJI = ?";
		jdbcTemplate.update(sql, id);
	}
}
