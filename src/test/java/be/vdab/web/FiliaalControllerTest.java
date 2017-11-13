package be.vdab.web;

import be.vdab.entities.Filiaal;
import be.vdab.services.FiliaalService;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FiliaalControllerTest {

	private FiliaalController filiaalController;
	private List<Filiaal> filialen;
	private FiliaalService filiaalService;

	@Before
	public void setUp() throws Exception {
		filialen= Collections.emptyList();
		filiaalService = mock(FiliaalService.class);
		when(filiaalService.findAll()).thenReturn(filialen);
		filiaalController = new FiliaalController(filiaalService);
	}

	@Test
	public void findAllActiveerJuisteView(){
		assertEquals("filialen/filialen",filiaalController.findAll().getViewName());
	}

	@Test
	public void findAllMaaktRequestAttribuutFilialen(){
		assertSame(filialen,filiaalController.findAll().getModelMap().get("filialen"));
	}

}