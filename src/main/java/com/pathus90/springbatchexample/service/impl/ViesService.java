package com.pathus90.springbatchexample.service.impl;

import com.pathus90.springbatchexample.model.Student;
import com.pathus90.springbatchexample.model.Vies;
import com.pathus90.springbatchexample.repository.IStudentRepository;
import com.pathus90.springbatchexample.repository.IViesRepository;
import com.pathus90.springbatchexample.service.IStudentService;
import com.pathus90.springbatchexample.service.IViesService;
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
