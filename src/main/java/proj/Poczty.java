package proj;

public class Poczty {
	private int nr_poczty;
	private String kod_poczty;
	private String poczta;

	public Poczty(int nr_poczty, String kod_poczty, String poczta) {
		super();
		this.nr_poczty = nr_poczty;
		this.kod_poczty = kod_poczty;
		this.poczta = poczta;
	}

	public Poczty(String kod_poczty, String poczta) {
		super();
		this.kod_poczty = kod_poczty;
		this.poczta = poczta;
	}

	public Poczty() {
		super();
	}

	public int getNr_poczty() {
		return nr_poczty;
	}

	public void setNr_poczty(int nr_poczty) {
		this.nr_poczty = nr_poczty;
	}

	public String getKod_poczty() {
		return kod_poczty;
	}

	public void setKod_poczty(String kod_poczty) {
		this.kod_poczty = kod_poczty;
	}

	public String getPoczta() {
		return poczta;
	}

	public void setPoczta(String poczta) {
		this.poczta = poczta;
	}

	@Override
	public String toString() {
		return "Poczty [nr_poczty=" + nr_poczty + ", kod_poczty=" + kod_poczty + ", poczta=" + poczta + "]";
	}

}
