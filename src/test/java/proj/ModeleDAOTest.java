package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class ModeleDAOTest {
	private ModeleDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new ModeleDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Modele> listModele = dao.list();
		assertTrue(!listModele.isEmpty());
	}

	@Test
	void testSave() {
		Modele modele = new Modele("CLA", "Osobowy, czarny", 1);
		dao.save(modele);
	}

	@Test
	void testGet() {
		int id = 3;
		Modele modele = dao.get(id);
		assertNotNull(modele);
	}

	@Test
	void testUpdate() {
		Modele modele = new Modele();
		modele.setNrModelu(2);
		modele.setNazwaModelu("A6");
		modele.setOpis("test");
		modele.setNrMarki(3);

		dao.update(modele);
	}

	@Test
	void testDelete() {
		int id = 21;
		dao.delete(id);
	}

}
