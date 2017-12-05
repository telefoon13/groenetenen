package be.vdab.services;

import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@ReadOnlyTransactionalService
public class DefaultWerknemerService implements WerknemerService {

	private final WerknemerRepository werknemerRepository;

	DefaultWerknemerService(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Page<Werknemer> findAll(Pageable pageable) {
		return werknemerRepository.findAll(pageable);
	}
}
