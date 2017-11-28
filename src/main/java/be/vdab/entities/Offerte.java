package be.vdab.entities;

import be.vdab.enums.GazonType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

public class Offerte implements Serializable {

	private static final long serialVersionUID = 1L;
	public interface Stap1{}
	public interface Stap2{}

	@NotBlank(groups = Stap1.class)
	@SafeHtml(groups = Stap1.class)
	private String voornaam;
	@NotBlank(groups = Stap1.class)
	@SafeHtml(groups = Stap1.class)
	private String familienaam;
	@NotBlank(groups = Stap1.class)
	@Email(groups = Stap1.class)
	private String emailAdres;
	@NotNull(groups = Stap2.class)
	@Min(value = 1, groups = Stap2.class)
	private Integer oppervlakte;
	private List<String> telefoonNrs = new ArrayList<>();
	private Map<GazonType,Boolean> gazontypes = new LinkedHashMap<>();

	public Offerte() {
		telefoonNrs.add("");
		Arrays.stream(GazonType.values()).forEach(gazonType -> gazontypes.put(gazonType, false));
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public String getEmailAdres() {
		return emailAdres;
	}

	public void setEmailAdres(String emailAdres) {
		this.emailAdres = emailAdres;
	}

	public Integer getOppervlakte() {
		return oppervlakte;
	}

	public void setOppervlakte(Integer oppervlakte) {
		this.oppervlakte = oppervlakte;
	}

	public List<String> getTelefoonNrs() {
		return telefoonNrs;
	}

	public void setTelefoonNrs(List<String> telefoonNrs) {
		this.telefoonNrs = telefoonNrs;
	}

	public Map<GazonType, Boolean> getGazontypes() {
		return gazontypes;
	}

	public void setGazontypes(Map<GazonType, Boolean> gazontypes) {
		this.gazontypes = gazontypes;
	}

	public void nogEenTelefoonNr(){
		telefoonNrs.add("");
	}
}
