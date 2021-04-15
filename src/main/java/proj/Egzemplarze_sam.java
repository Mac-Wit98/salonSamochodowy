package proj;

public class Egzemplarze_sam {
	private int nr_egzemplarzu;
	private String numer_vin;
	private double cena;
	private String kolor;
	private int nr_samochodu;
	private int nr_fabryki;

	public Egzemplarze_sam(int nr_egzemplarzu, String numer_vin, double cena, String kolor, int nr_samochodu,
			int nr_fabryki) {
		super();
		this.nr_egzemplarzu = nr_egzemplarzu;
		this.numer_vin = numer_vin;
		this.cena = cena;
		this.kolor = kolor;
		this.nr_samochodu = nr_samochodu;
		this.nr_fabryki = nr_fabryki;
	}

	public Egzemplarze_sam(String numer_vin, double cena, String kolor, int nr_samochodu, int nr_fabryki) {
		super();
		this.numer_vin = numer_vin;
		this.cena = cena;
		this.kolor = kolor;
		this.nr_samochodu = nr_samochodu;
		this.nr_fabryki = nr_fabryki;
	}

	public Egzemplarze_sam() {
		super();
	}

	public int getNr_egzemplarzu() {
		return nr_egzemplarzu;
	}

	public void setNr_egzemplarzu(int nr_egzemplarzu) {
		this.nr_egzemplarzu = nr_egzemplarzu;
	}

	public String getNumer_vin() {
		return numer_vin;
	}

	public void setNumer_vin(String numer_vin) {
		this.numer_vin = numer_vin;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getKolor() {
		return kolor;
	}

	public void setKolor(String kolor) {
		this.kolor = kolor;
	}

	public int getNr_samochodu() {
		return nr_samochodu;
	}

	public void setNr_samochodu(int nr_samochodu) {
		this.nr_samochodu = nr_samochodu;
	}

	public int getNr_fabryki() {
		return nr_fabryki;
	}

	public void setNr_fabryki(int nr_fabryki) {
		this.nr_fabryki = nr_fabryki;
	}

	@Override
	public String toString() {
		return "Egzemplarze_sam [nr_egzemplarzu=" + nr_egzemplarzu + ", numer_vin=" + numer_vin + ", cena=" + cena
				+ ", kolor=" + kolor + ", nr_samochodu=" + nr_samochodu + ", nr_fabryki=" + nr_fabryki + "]";
	}

}
