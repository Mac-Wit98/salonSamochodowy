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
public class ModeleDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * Constructor for jdbcTemplate
	 */
	public ModeleDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * List for data from database
	 */
	public List<Modele> list() {
		String sql = "SELECT * FROM MODELE";
		List<Modele> listModele = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Modele.class));
		return listModele;
	}

	/* (C)reate - Insert new record */
	public void save(Modele modele) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("modele").usingColumns("nazwa_modelu", "opis", "nr_marki");

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(modele);
		insertActor.execute(param);
	}

	/* (R)ead - read data from database */
	/**
	 * 
	 * @param id = nr_Modelu
	 * @return
	 */
	public Modele get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM MODELE WHERE NR_MODELU = " + args[0];
		Modele modele = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Modele.class));
		return modele;
	}

	/* (U)pdate - data inside database */
	public void update(Modele modele) {
		String sql = "UPDATE MODELE SET nazwa_modelu=:nazwaModelu, opis=:opis, nr_marki=:nrMarki WHERE nr_modelu=:nrModelu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(modele);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}

	/* (D)elete - choosen data */
	/**
	 * 
	 * @param id = nr_Modelu
	 */
	public void delete(int id) {
		String sql = "DELETE FROM MODELE WHERE NR_MODELU = ?";
		jdbcTemplate.update(sql, id);
	}
}
