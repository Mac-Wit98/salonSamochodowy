package proj;

public class Marki {
	private int nr_marki;
	private String nazwa;
	private String opis;

	public Marki(int nr_marki, String nazwa, String opis) {
		super();
		this.nr_marki = nr_marki;
		this.nazwa = nazwa;
		this.opis = opis;
	}

	public Marki(String nazwa, String opis) {
		super();
		this.nazwa = nazwa;
		this.opis = opis;
	}

	public Marki() {
		super();
	}

	public int getNr_marki() {
		return nr_marki;
	}

	public void setNr_marki(int nr_marki) {
		this.nr_marki = nr_marki;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "Marki [nr_marki=" + nr_marki + ", nazwa=" + nazwa + ", opis=" + opis + "]";
	}

}
