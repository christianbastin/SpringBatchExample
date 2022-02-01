package be.fgov.stirint.common.vies.batch;

import be.fgov.stirint.common.vies.model.Vies;
import be.fgov.stirint.common.vies.service.IViesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ViesWriter implements ItemWriter<Vies> {

    @Autowired
    private IViesService viesService;

    @Override
    public void write(List<? extends Vies> viesList) {
        viesList.stream().forEach(vies -> {
            log.info("Enregistrement en base de l'objet {}", vies);
            viesService.insertVies(vies);
        });
    }
}
