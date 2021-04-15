package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class PracowinicyDAOTest {
	private PracowinicyDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new PracowinicyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Pracownicy> listPracownicy = dao.list();
		assertTrue(!listPracownicy.isEmpty());
	}

	@Test
	void testSave() {
		Pracownicy pracownicy = new Pracownicy("Mar", "Mar", "1998-12-12", "M", "98989811111", "48902122123",
				"asd@wppl", "2005-06-01", 1, 2, 1);
		dao.save(pracownicy);
	}

	@Test
	void testGet() {
		int id = 21;
		Pracownicy pracownicy = dao.get(id);
		assertNotNull(pracownicy);
	}

	@Test
	void testUpdate() {
		Pracownicy pracownicy = new Pracownicy();
		pracownicy.setNr_pracownika(21);
		pracownicy.setImie("NNN");
		pracownicy.setNazwisko("WWW");
		pracownicy.setData_urodzenia("1955-12-12");
		pracownicy.setPlec("K");
		pracownicy.setPesel("1111111111");
		pracownicy.setNr_telefonu("123456789");
		pracownicy.setAdres_email("aaaa@wp.pl");
		pracownicy.setData_zatrudnienia("2020-01-01");
		pracownicy.setNr_salon(2);
		pracownicy.setNr_adresu(5);
		pracownicy.setNr_stanowiska(4);

		dao.update(pracownicy);
	}

	@Test
	void testDelete() {
		int id = 21;
		dao.delete(id);
	}

}
