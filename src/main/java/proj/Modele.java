package proj;

public class Modele {
	private int nr_Modelu;
	private String nazwa_Modelu;
	private String opis;
	private int nr_Marki;

	public Modele() {
		super();
	}

	public Modele(String nazwa_Modelu, String opis, int nr_Marki) {
		super();
		this.nazwa_Modelu = nazwa_Modelu;
		this.opis = opis;
		this.nr_Marki = nr_Marki;
	}

	public Modele(int nr_Modelu, String nazwa_Modelu, String opis, int nr_Marki) {
		super();
		this.nr_Modelu = nr_Modelu;
		this.nazwa_Modelu = nazwa_Modelu;
		this.opis = opis;
		this.nr_Marki = nr_Marki;
	}

	public int getNrModelu() {
		return nr_Modelu;
	}

	public void setNrModelu(int nr_Modelu) {
		this.nr_Modelu = nr_Modelu;
	}

	public String getNazwaModelu() {
		return nazwa_Modelu;
	}

	public void setNazwaModelu(String nazwa_Modelu) {
		this.nazwa_Modelu = nazwa_Modelu;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getNrMarki() {
		return nr_Marki;
	}

	public void setNrMarki(int nr_Marki) {
		this.nr_Marki = nr_Marki;
	}

	@Override
	public String toString() {
		return "Modele [nr_Modelu=" + nr_Modelu + ", nazwa_Modelu=" + nazwa_Modelu + ", opis=" + opis + ", nr_Marki="
				+ nr_Marki + "]";
	}

}
