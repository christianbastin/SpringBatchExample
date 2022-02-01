package be.fgov.stirint.common.vies.model;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class ViesFieldSetMapper implements FieldSetMapper<Vies> {
    @Override
    public Vies mapFieldSet(FieldSet fieldSet) {
        return Vies.builder()
                .idVies(fieldSet.readString(0))
                .isoCode(fieldSet.readString(1))
                .vatNumber(fieldSet.readString(2))
                .build();
    }
}

