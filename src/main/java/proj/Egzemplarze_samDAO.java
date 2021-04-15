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
public class Egzemplarze_samDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Egzemplarze_samDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Egzemplarze_sam> list() {
		String sql = "SELECT * FROM EGZEMPLARZE_SAM";
		List<Egzemplarze_sam> listEgzsam = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Egzemplarze_sam.class));
		return listEgzsam;
	}

	/* (C)reate - Insert new record */
	public void save(Egzemplarze_sam egzemplarze_sam) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("egzemplarze_sam").usingColumns("nr_egzemplarzu", "numer_vin", "cena", "kolor",
				"nr_samochodu", "nr_fabryki");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(egzemplarze_sam);
		insertActor.execute(param);
	}

	/* (R)ead - read data from database */
	public Egzemplarze_sam get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM EGZEMPLARZE_SAM WHERE NR_EGZEMPLARZU = " + args[0];
		Egzemplarze_sam egzemplarze_sam = jdbcTemplate.queryForObject(sql,
				BeanPropertyRowMapper.newInstance(Egzemplarze_sam.class));
		return egzemplarze_sam;
	}

	/* (U)pdate - data inside database */
	public void update(Egzemplarze_sam egzemplarze_sam) {
		String sql = "UPDATE EGZEMPLARZE_SAM SET numer_vin=:numer_vin, cena=:cena, kolor=:kolor, nr_samochodu=:nr_samochodu, nr_fabryki=:nr_fabryki"
				+ " WHERE nr_egzemplarzu=:nr_egzemplarzu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(egzemplarze_sam);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */
	public void delete(int id) {
		String sql = "DELETE FROM EGZEMPLARZE_SAM WHERE NR_EGZEMPLARZU = ?";
		jdbcTemplate.update(sql, id);
	}
}
