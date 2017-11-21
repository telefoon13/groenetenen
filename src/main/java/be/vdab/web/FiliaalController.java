package be.vdab.web;

import be.vdab.entities.Filiaal;
import be.vdab.exceptions.FiliaalHeeftNogWerknemersException;
import be.vdab.services.FiliaalService;
import be.vdab.valueobjects.PostcodeReeks;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/filialen")
public class FiliaalController {

	private static final String FILIALEN_VIEW = "filialen/filialen";
	private static final String FILIAAL_VIEW = "filialen/filiaal";
	private static final String TOEVOEGEN_VIEW = "filialen/toevoegen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/filialen";
	private static final Logger LOGGER = Logger.getLogger(FiliaalController.class.getName());
	private final FiliaalService filiaalService;
	private static final String REDIRECT_URL_FILIAAL_NIET_GEVONDEN = "redirect:/filialen";
	private static final String REDIRECT_URL_NA_VERWIJDEREN = "redirect:/filialen/{id}/verwijderd";
	private static final String REDIRECT_URL_HEEFT_NOG_WERKNEMERS = "redirect:/filialen/{id}";
	private static final String VERWIJDERD_VIEW = "filialen/verwijderd";
	private static final String PER_POSTCODE_VIEW = "filialen/perpostcode";

	FiliaalController(FiliaalService filiaalService){
		this.filiaalService = filiaalService;
	}

	@GetMapping
	ModelAndView findAll(){
		return new ModelAndView(FILIALEN_VIEW,"filialen",filiaalService.findAll()).addObject("aantalFilialen", filiaalService.findAantalFilialen());
	}

	@GetMapping("toevoegen")
	String createForm(){
		return TOEVOEGEN_VIEW;
	}

	@GetMapping("{id}")
	ModelAndView read(@PathVariable long id){
		ModelAndView modelAndView = new ModelAndView(FILIAAL_VIEW);
		filiaalService.read(id).ifPresent(filiaal -> modelAndView.addObject(filiaal));
		return modelAndView;
	}

	@GetMapping("{id}/verwijderd")
	String deleted(String naam) {
		return VERWIJDERD_VIEW;
	}

	@GetMapping("perpostcode")
	ModelAndView findByPostcodeReeks(){
		PostcodeReeks reeks = new PostcodeReeks();
		return new ModelAndView(PER_POSTCODE_VIEW).addObject(reeks);
	}

	@GetMapping(params = {"vanpostcode", "totpostcode"})
	ModelAndView findByPostcodeReeks(@Valid PostcodeReeks reeks, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(PER_POSTCODE_VIEW);
		if ( ! bindingResult.hasErrors()){
			List<Filiaal> filialen = filiaalService.findByPostcodeReeks(reeks);
			if (filialen.isEmpty()){
				bindingResult.reject("geenFilialen");
			} else {
				modelAndView.addObject("filialen", filialen);
			}
		}
		return modelAndView;
	}

	@PostMapping
	String create(){
		LOGGER.info("Filiaal record toegevoegd aan DataBase");
		return REDIRECT_URL_NA_TOEVOEGEN;
	}

	@PostMapping("{id}/verwijderen")
	String delete(@PathVariable long id, RedirectAttributes redirectAttributes) {
		Optional<Filiaal> optionalFiliaal = filiaalService.read(id);
		if (! optionalFiliaal.isPresent()) {
			return REDIRECT_URL_FILIAAL_NIET_GEVONDEN;
		}
		try {
			filiaalService.delete(id);
			redirectAttributes.addAttribute("id", id).addAttribute("naam", optionalFiliaal.get().getNaam());
			return REDIRECT_URL_NA_VERWIJDEREN;
		} catch (FiliaalHeeftNogWerknemersException ex) {
			redirectAttributes.addAttribute("id", id).addAttribute("fout", "Filiaal heeft nog werknemers");
			return REDIRECT_URL_HEEFT_NOG_WERKNEMERS;
		}
	}
}
