package proj;

public class Klienci {
	private int nr_klienta;
	private String imie;
	private String nazwisko;
	private String data_urodzenia;
	private String plec;
	private String pesel;
	private String nr_telefonu;
	private String adres_email;
	private int nr_adresu;
	private int nr_salon;

	public Klienci(int nr_klienta, String imie, String nazwisko, String data_urodzenia, String plec, String pesel,
			String nr_telefonu, String adres_email, int nr_adresu, int nr_salon) {
		super();
		this.nr_klienta = nr_klienta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia;
		this.plec = plec;
		this.pesel = pesel;
		this.nr_telefonu = nr_telefonu;
		this.adres_email = adres_email;
		this.nr_adresu = nr_adresu;
		this.nr_salon = nr_salon;
	}

	public Klienci() {
		super();
	}

	public Klienci(String imie, String nazwisko, String data_urodzenia, String plec, String pesel, String nr_telefonu,
			String adres_email, int nr_adresu, int nr_salon) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.data_urodzenia = data_urodzenia;
		this.plec = plec;
		this.pesel = pesel;
		this.nr_telefonu = nr_telefonu;
		this.adres_email = adres_email;
		this.nr_adresu = nr_adresu;
		this.nr_salon = nr_salon;
	}

	public int getNr_klienta() {
		return nr_klienta;
	}

	public void setNr_klienta(int nr_klienta) {
		this.nr_klienta = nr_klienta;
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

	public void setData_urodzenia(String sata_urodzenia) {
		this.data_urodzenia = sata_urodzenia;
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

	public int getNr_adresu() {
		return nr_adresu;
	}

	public void setNr_adresu(int nr_adresu) {
		this.nr_adresu = nr_adresu;
	}

	public int getNr_salon() {
		return nr_salon;
	}

	public void setNr_salon(int nr_salon) {
		this.nr_salon = nr_salon;
	}

	@Override
	public String toString() {
		return "Klienci [nr_klienta=" + nr_klienta + ", imie=" + imie + ", nazwisko=" + nazwisko + ", data_urodzenia="
				+ data_urodzenia + ", plec=" + plec + ", pesel=" + pesel + ", nr_telefonu=" + nr_telefonu
				+ ", adres_email=" + adres_email + ", nr_adresu=" + nr_adresu + ", nr_salon=" + nr_salon + "]";
	}

}
