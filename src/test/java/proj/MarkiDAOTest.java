package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class MarkiDAOTest {
	private MarkiDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new MarkiDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Marki> listMarki = dao.list();
		assertTrue(!listMarki.isEmpty());
	}

	@Test
	void testSave() {
		Marki marki = new Marki("BMW", "Niemiecki producent samochodow");
		dao.save(marki);
	}

	@Test
	void testGet() {
		int id = 2;
		Marki marki = dao.get(id);
		assertNotNull(marki);
	}

	@Test
	void testUpdate() {
		Marki marki = new Marki();
		marki.setNr_marki(21);
		marki.setNazwa("Opel");
		marki.setOpis("Niemiecka L");

		dao.update(marki);
	}

	@Test
	void testDelete() {
		int id = 22;
		dao.delete(id);
	}

}
