package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class TransakcjeDAOTest {

	private TransakcjeDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new TransakcjeDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Transakcje> listTransakcje = dao.list();
		assertTrue(!listTransakcje.isEmpty());
	}

	@Test
	void testSave() {
		Transakcje transakcje = new Transakcje("2020-10-15", 99000, "T", "2022-10-15", 4000.5, 2, 2);
		dao.save(transakcje);
	}

	@Test
	void testGet() {
		int id = 21;
		Transakcje transakcje = dao.get(id);
		assertNotNull(transakcje);
	}

	@Test
	void testUpdate() {
		Transakcje transakcje = new Transakcje();
		transakcje.setNr_transakcji(21);
		transakcje.setData("2021-04-17");
		transakcje.setKwota(120000);
		transakcje.setCzy_leasing("N");
		transakcje.setData_leasingu("21-04-18");
		transakcje.setKwota_miesieczna(2525);
		transakcje.setNr_klienta(3);
		transakcje.setNr_egzemplarzu(1);

		dao.update(transakcje);
	}

	@Test
	void testDelete() {
		int id = 21;
		dao.delete(id);
	}

}
