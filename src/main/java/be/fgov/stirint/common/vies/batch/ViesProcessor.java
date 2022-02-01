package be.fgov.stirint.common.vies.batch;

import be.fgov.stirint.common.vies.model.Vies;
import org.springframework.batch.item.ItemProcessor;

public class ViesProcessor implements ItemProcessor<Vies, Vies> {

    @Override
    public Vies process(Vies vies) {

        return vies;
    }
}
