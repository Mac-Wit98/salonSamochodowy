package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class KlienciDAOTest {
	private KlienciDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new KlienciDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Klienci> listKlienci = dao.list();
		assertTrue(!listKlienci.isEmpty());
	}

	@Test
	void testSave() {
		Klienci klienci = new Klienci("Mar", "Mar", "1998-12-12", "M", "98989811111", "48902122123", "asdas@wp.pl", 2,
				2);
		dao.save(klienci);
	}

	@Test
	void testGet() {
		int id = 30;
		Klienci klienci = dao.get(id);
		assertNotNull(klienci);
	}

	@Test
	void testUpdate() {
		Klienci klienci = new Klienci();
		klienci.setNr_klienta(30);
		klienci.setImie("Naryz");
		klienci.setNazwisko("Narnar");
		klienci.setData_urodzenia("1988-12-01");
		klienci.setPlec("K");
		klienci.setPesel("10101011111");
		klienci.setNr_telefonu("42512432657");
		klienci.setAdres_email("sadasd@wp.pl");
		klienci.setNr_adresu(1);
		klienci.setNr_salon(1);
		dao.update(klienci);
	}

	@Test
	void testDelete() {
		int id = 30;
		dao.delete(id);
	}

}
