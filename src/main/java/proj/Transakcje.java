package proj;

public class Transakcje {
	private int nr_transakcji;
	private String data;
	private double kwota;
	private String czy_leasing;
	private String data_leasingu;
	private double kwota_miesieczna;
	private int nr_klienta;
	private int nr_egzemplarzu;

	public Transakcje(int nr_transakcji, String data, double kwota, String czy_leasing, String data_leasingu,
			double kwota_miesieczna, int nr_klienta, int nr_egzemplarzu) {
		super();
		this.nr_transakcji = nr_transakcji;
		this.data = data;
		this.kwota = kwota;
		this.czy_leasing = czy_leasing;
		this.data_leasingu = data_leasingu;
		this.kwota_miesieczna = kwota_miesieczna;
		this.nr_klienta = nr_klienta;
		this.nr_egzemplarzu = nr_egzemplarzu;
	}

	public Transakcje(String data, double kwota, String czy_leasing, String data_leasingu, double kwota_miesieczna,
			int nr_klienta, int nr_egzemplarzu) {
		super();
		this.data = data;
		this.kwota = kwota;
		this.czy_leasing = czy_leasing;
		this.data_leasingu = data_leasingu;
		this.kwota_miesieczna = kwota_miesieczna;
		this.nr_klienta = nr_klienta;
		this.nr_egzemplarzu = nr_egzemplarzu;
	}

	public Transakcje() {
		super();
	}

	public int getNr_transakcji() {
		return nr_transakcji;
	}

	public void setNr_transakcji(int nr_transakcji) {
		this.nr_transakcji = nr_transakcji;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public String getCzy_leasing() {
		return czy_leasing;
	}

	public void setCzy_leasing(String czy_leasing) {
		this.czy_leasing = czy_leasing;
	}

	public String getData_leasingu() {
		return data_leasingu;
	}

	public void setData_leasingu(String data_leasingu) {
		this.data_leasingu = data_leasingu;
	}

	public double getKwota_miesieczna() {
		return kwota_miesieczna;
	}

	public void setKwota_miesieczna(double kwota_miesieczna) {
		this.kwota_miesieczna = kwota_miesieczna;
	}

	public int getNr_klienta() {
		return nr_klienta;
	}

	public void setNr_klienta(int nr_klienta) {
		this.nr_klienta = nr_klienta;
	}

	public int getNr_egzemplarzu() {
		return nr_egzemplarzu;
	}

	public void setNr_egzemplarzu(int nr_egzemplarzu) {
		this.nr_egzemplarzu = nr_egzemplarzu;
	}

	@Override
	public String toString() {
		return "Transakcje [nr_transakcji=" + nr_transakcji + ", data=" + data + ", kwota=" + kwota + ", czy_leasing="
				+ czy_leasing + ", data_leasingu=" + data_leasingu + ", kwota_miesieczna=" + kwota_miesieczna
				+ ", nr_klienta=" + nr_klienta + ", nr_egzemplarzu=" + nr_egzemplarzu + "]";
	}

}
