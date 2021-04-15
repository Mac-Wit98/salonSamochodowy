package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class Egzemplarze_samDAOTest {
	private Egzemplarze_samDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new Egzemplarze_samDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Egzemplarze_sam> listEgzemplarze = dao.list();
		assertTrue(!listEgzemplarze.isEmpty());
	}

	@Test
	void testSave() {
		Egzemplarze_sam egzemplarz = new Egzemplarze_sam("U5YFF52428L011111", 12000, "Bia³y", 3, 2);
		dao.save(egzemplarz);
	}

	@Test
	void testGet() {
		int id = 21;
		Egzemplarze_sam egzemplarz = dao.get(id);
		assertNotNull(egzemplarz);
	}

	@Test
	void testUpdate() {
		Egzemplarze_sam egzemplarz = new Egzemplarze_sam();
		egzemplarz.setNr_egzemplarzu(21);
		egzemplarz.setNumer_vin("ABC123");
		egzemplarz.setCena(121212);
		egzemplarz.setKolor("Niebieski");
		egzemplarz.setNr_samochodu(2);
		egzemplarz.setNr_fabryki(2);

		dao.update(egzemplarz);
	}

	@Test
	void testDelete() {
		int id = 21;
		dao.delete(id);
	}

}
