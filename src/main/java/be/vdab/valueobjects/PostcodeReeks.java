package be.vdab.valueobjects;

import be.vdab.constraints.Postcode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PostcodeReeks implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public boolean bevat(Integer postcode){
		return postcode >= vanpostcode && postcode <= totpostcode;
	}
}
