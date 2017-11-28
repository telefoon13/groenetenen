package be.vdab.web;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class VoorkeurImpl implements Voorkeur,Serializable {

	private static final long serialVersionUID = 1L;
	private String Foto;

	@Override
	public String getFoto() {
		return Foto;
	}

	@Override
	public void setFoto(String foto) {
		Foto = foto;
	}
}
