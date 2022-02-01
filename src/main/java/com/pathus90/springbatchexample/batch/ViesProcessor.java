package com.pathus90.springbatchexample.batch;

import com.pathus90.springbatchexample.model.Student;
import com.pathus90.springbatchexample.model.Vies;
import org.springframework.batch.item.ItemProcessor;

public class ViesProcessor implements ItemProcessor<Vies, Vies> {

    @Override
    public Vies process(Vies vies) {

        return vies;
    }
}
