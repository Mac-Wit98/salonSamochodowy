package proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class PocztyDAOTest {
	private PocztyDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.107:1521:ORCL1");
		datasource.setUsername("MACWITOS");
		datasource.setPassword("bazy");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");

		dao = new PocztyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Poczty> listPoczty = dao.list();
		assertTrue(!listPoczty.isEmpty());
	}

	@Test
	void testSave() {
		Poczty poczty = new Poczty("05-300", "Miñsk Mazowiecki");
		dao.save(poczty);
	}

	@Test
	void testGet() {
		int id = 2;
		Poczty poczty = dao.get(id);
		assertNotNull(poczty);
	}

	@Test
	void testUpdate() {
		Poczty poczty = new Poczty();

		poczty.setNr_poczty(0);
		poczty.setKod_poczty("05-301");
		poczty.setPoczta("Nie MMZ");

		dao.update(poczty);
	}

	@Test
	void testDelete() {
		int id = 0;
		dao.delete(id);
	}

}
