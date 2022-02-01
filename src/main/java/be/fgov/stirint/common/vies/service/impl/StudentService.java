package be.fgov.stirint.common.vies.service.impl;

import be.fgov.stirint.common.vies.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.fgov.stirint.common.vies.model.Student;
import be.fgov.stirint.common.vies.service.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public void insertStudent(Student student) {
        studentRepository.save(student);
    }
}
