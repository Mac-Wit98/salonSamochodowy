package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class SamochodyDAOTest {
	private SamochodyDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new SamochodyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Samochody> listSamochody = dao.list();
		assertTrue(!listSamochody.isEmpty());
	}

	@Test
	void testSave() {
		Samochody samochody = new Samochody("2018", "A", "2.0 diesel", 4, "2022-12-12", 1, 3);
		dao.save(samochody);
	}

	@Test
	void testGet() {
		int id = 3;
		Samochody samochody = dao.get(id);
		assertNotNull(samochody);
	}

	@Test
	void testUpdate() {
		Samochody samochody = new Samochody();
		samochody.setNr_samochodu(22);
		samochody.setRok_produkcji("2021");
		samochody.setSkrzynia_biegow("M");
		samochody.setSilnik("Elektryczny");
		samochody.setLiczba_drzwi(2);
		samochody.setData_gwarancji("23-12-12");
		samochody.setNr_salon(2);
		samochody.setNr_modelu(4);

		dao.update(samochody);
	}

	@Test
	void testDelete() {
		int id = 22;
		dao.delete(id);
	}

}
