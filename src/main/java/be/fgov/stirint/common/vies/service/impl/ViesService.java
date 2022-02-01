package be.fgov.stirint.common.vies.service.impl;

import be.fgov.stirint.common.vies.model.Vies;
import be.fgov.stirint.common.vies.repository.IViesRepository;
import be.fgov.stirint.common.vies.service.IViesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViesService implements IViesService {

    @Autowired
    private IViesRepository viesRepository;

    @Override
    public void insertVies(Vies vies) {
        viesRepository.save(vies);
    }
}
