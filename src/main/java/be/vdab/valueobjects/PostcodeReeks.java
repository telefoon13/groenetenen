package be.vdab.valueobjects;

public class PostcodeReeks {

	private final static int MIN_POSTCODE = 1000;
	private final static int MAX_POSTCODE = 9999;

	private Integer vanpostcode;
	private Integer totpostcode;

	public Integer getVanpostcode() {
		return vanpostcode;
	}

	public void setVanpostcode(Integer vanpostcode) {
		this.vanpostcode = vanpostcode;
	}

	public Integer getTotpostcode() {
		return totpostcode;
	}

	public void setTotpostcode(Integer totpostcode) {
		this.totpostcode = totpostcode;
	}

	public boolean bevat(Integer postcode){
		return postcode >= vanpostcode && postcode <= totpostcode;
	}

	public void valideer(int postcode){
		if (postcode < MIN_POSTCODE || postcode > MAX_POSTCODE){
			throw new IllegalArgumentException();
		}
	}
}
