package be.vdab.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FoutController {

	public final static String VIEW = "fout";

	@ExceptionHandler(Exception.class)
	public String foutPagina(){
		return VIEW;
	}
}
