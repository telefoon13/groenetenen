package be.vdab.valueobjects;

import be.vdab.constraints.Postcode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class PostcodeReeks {


	@Postcode
	private Integer vanpostcode;
	@Postcode
	private Integer totpostcode;

	public Integer getVanpostcode() {
		return vanpostcode;
	}

	public Integer getTotpostcode() {
		return totpostcode;
	}

	public void setVanpostcode(Integer vanpostcode) {
		this.vanpostcode = vanpostcode;
	}

	public void setTotpostcode(Integer totpostcode) {
		this.totpostcode = totpostcode;
	}

	public boolean bevat(Integer postcode){
		return postcode >= vanpostcode && postcode <= totpostcode;
	}
}
