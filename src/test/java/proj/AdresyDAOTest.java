package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class AdresyDAOTest {
	private AdresyDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new AdresyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Adresy> listAdresy = dao.list();
		assertTrue(!listAdresy.isEmpty());
	}

	@Test
	void testSave() {
		Adresy adresy = new Adresy("Kraków", "Wawelska", "12", 3);
		dao.save(adresy);
	}

	@Test
	void testGet() {
		int id = 21;
		Adresy adresy = dao.get(id);
		assertNotNull(adresy);
	}

	@Test
	void testUpdate() {
		Adresy adresy = new Adresy();
		adresy.setNr_adresu(21);
		adresy.setMiasto("Warszawa");
		adresy.setUlica("Z³ota");
		adresy.setNr_lokalu("2");
		adresy.setNr_poczty(3);

		dao.update(adresy);
	}

	@Test
	void testDelete() {
		int id = 21;
		dao.delete(id);
	}

}
