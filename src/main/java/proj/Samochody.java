package proj;

public class Samochody {
	private int nr_samochodu;
	private String rok_produkcji;
	private String skrzynia_biegow;
	private String silnik;
	private int liczba_drzwi;
	private String data_gwarancji;
	private int nr_salon;
	private int nr_modelu;

	public Samochody(int nr_samochodu, String rok_produkcji, String skrzynia_biegow, String silnik, int liczba_drzwi,
			String data_gwarancji, int nr_salon, int nr_modelu) {
		super();
		this.nr_samochodu = nr_samochodu;
		this.rok_produkcji = rok_produkcji;
		this.skrzynia_biegow = skrzynia_biegow;
		this.silnik = silnik;
		this.liczba_drzwi = liczba_drzwi;
		this.data_gwarancji = data_gwarancji;
		this.nr_salon = nr_salon;
		this.nr_modelu = nr_modelu;
	}

	public Samochody(String rok_produkcji, String skrzynia_biegow, String silnik, int liczba_drzwi,
			String data_gwarancji, int nr_salon, int nr_modelu) {
		super();
		this.rok_produkcji = rok_produkcji;
		this.skrzynia_biegow = skrzynia_biegow;
		this.silnik = silnik;
		this.liczba_drzwi = liczba_drzwi;
		this.data_gwarancji = data_gwarancji;
		this.nr_salon = nr_salon;
		this.nr_modelu = nr_modelu;
	}

	public Samochody() {
		super();
	}

	public int getNr_samochodu() {
		return nr_samochodu;
	}

	public void setNr_samochodu(int nr_samochodu) {
		this.nr_samochodu = nr_samochodu;
	}

	public String getRok_produkcji() {
		return rok_produkcji;
	}

	public void setRok_produkcji(String rok_produkcji) {
		this.rok_produkcji = rok_produkcji;
	}

	public String getSkrzynia_biegow() {
		return skrzynia_biegow;
	}

	public void setSkrzynia_biegow(String skrzynia_biegow) {
		this.skrzynia_biegow = skrzynia_biegow;
	}

	public String getSilnik() {
		return silnik;
	}

	public void setSilnik(String silnik) {
		this.silnik = silnik;
	}

	public int getLiczba_drzwi() {
		return liczba_drzwi;
	}

	public void setLiczba_drzwi(int liczba_drzwi) {
		this.liczba_drzwi = liczba_drzwi;
	}

	public String getData_gwarancji() {
		return data_gwarancji;
	}

	public void setData_gwarancji(String data_gwarancji) {
		this.data_gwarancji = data_gwarancji;
	}

	public int getNr_salon() {
		return nr_salon;
	}

	public void setNr_salon(int nr_salon) {
		this.nr_salon = nr_salon;
	}

	public int getNr_modelu() {
		return nr_modelu;
	}

	public void setNr_modelu(int nr_modelu) {
		this.nr_modelu = nr_modelu;
	}

	@Override
	public String toString() {
		return "Samochody [nr_samochodu=" + nr_samochodu + ", rok_produkcji=" + rok_produkcji + ", skrzynia_biegow="
				+ skrzynia_biegow + ", silnik=" + silnik + ", liczba_drzwi=" + liczba_drzwi + ", data_gwarancji="
				+ data_gwarancji + ", nr_salon=" + nr_salon + ", nr_modelu=" + nr_modelu + "]";
	}

}
