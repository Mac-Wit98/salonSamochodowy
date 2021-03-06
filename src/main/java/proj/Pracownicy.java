package proj;

public class Pracownicy {
	private int nr_pracownika;
	private String imie;
	private String nazwisko;
	private String data_urodzenia;
	private String plec;
	private String pesel;
	private String nr_telefonu;
	private String adres_email;
	private String data_zatrudnienia;
	private int nr_salon;
	private int nr_adresu;
	private int nr_stanowiska;

	public Pracownicy(int nr_pracownika, String imie, String nazwisko, String data_urodzenia, String plec, String pesel,
			String nr_telefonu, String adres_email, String data_zatrudnienia, int nr_salon, int nr_adresu,
			int nr_stanowiska) {
		super();
		this.nr_pracownika = nr_pracownika;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia;
		this.plec = plec;
		this.pesel = pesel;
		this.nr_telefonu = nr_telefonu;
		this.adres_email = adres_email;
		this.data_zatrudnienia = data_zatrudnienia;
		this.nr_salon = nr_salon;
		this.nr_adresu = nr_adresu;
		this.nr_stanowiska = nr_stanowiska;
	}

	public Pracownicy(String imie, String nazwisko, String data_urodzenia, String plec, String pesel,
			String nr_telefonu, String adres_email, String data_zatrudnienia, int nr_salon, int nr_adresu,
			int nr_stanowiska) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia;
		this.plec = plec;
		this.pesel = pesel;
		this.nr_telefonu = nr_telefonu;
		this.adres_email = adres_email;
		this.data_zatrudnienia = data_zatrudnienia;
		this.nr_salon = nr_salon;
		this.nr_adresu = nr_adresu;
		this.nr_stanowiska = nr_stanowiska;
	}

	public Pracownicy() {
		super();
	}

	public int getNr_pracownika() {
		return nr_pracownika;
	}

	public void setNr_pracownika(int nr_pracownika) {
		this.nr_pracownika = nr_pracownika;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getData_urodzenia() {
		return data_urodzenia;
	}

	public void setData_urodzenia(String data_urodzenia) {
		this.data_urodzenia = data_urodzenia;
	}

	public String getPlec() {
		return plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getNr_telefonu() {
		return nr_telefonu;
	}

	public void setNr_telefonu(String nr_telefonu) {
		this.nr_telefonu = nr_telefonu;
	}

	public String getAdres_email() {
		return adres_email;
	}

	public void setAdres_email(String adres_email) {
		this.adres_email = adres_email;
	}

	public String getData_zatrudnienia() {
		return data_zatrudnienia;
	}

	public void setData_zatrudnienia(String data_zatrudnienia) {
		this.data_zatrudnienia = data_zatrudnienia;
	}

	public int getNr_salon() {
		return nr_salon;
	}

	public void setNr_salon(int nr_salon) {
		this.nr_salon = nr_salon;
	}

	public int getNr_adresu() {
		return nr_adresu;
	}

	public void setNr_adresu(int nr_adresu) {
		this.nr_adresu = nr_adresu;
	}

	public int getNr_stanowiska() {
		return nr_stanowiska;
	}

	public void setNr_stanowiska(int nr_stanowiska) {
		this.nr_stanowiska = nr_stanowiska;
	}

	@Override
	public String toString() {
		return "Pracownicy [nr_pracownika=" + nr_pracownika + ", imie=" + imie + ", nazwisko=" + nazwisko
				+ ", data_uodzenia=" + data_urodzenia + ", plec=" + plec + ", pesel=" + pesel + ", nr_telefonu="
				+ nr_telefonu + ", adres_email=" + adres_email + ", data_zatrudnienia=" + data_zatrudnienia
				+ ", nr_salon=" + nr_salon + ", nr_adresu=" + nr_adresu + ", nr_stanowiska=" + nr_stanowiska + "]";
	}

}
