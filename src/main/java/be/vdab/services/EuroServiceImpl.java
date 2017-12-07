package be.vdab.services;

import be.vdab.restclients.KoersenClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class EuroServiceImpl implements EuroService {

	private final KoersenClient koersenClient;

	EuroServiceImpl(KoersenClient koersenClient) {
		this.koersenClient = koersenClient;
	}

	@Override
	public BigDecimal naarDollar(BigDecimal euro) {
		return euro.multiply(koersenClient.getDollarKoers()).setScale(2, RoundingMode.HALF_UP);
	}
}
