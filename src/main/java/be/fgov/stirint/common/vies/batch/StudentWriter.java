package be.fgov.stirint.common.vies.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import be.fgov.stirint.common.vies.model.Student;
import be.fgov.stirint.common.vies.service.IStudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentWriter implements ItemWriter<Student> {

    @Autowired
    private IStudentService studentService;

    @Override
    public void write(List<? extends Student> students) {
        students.stream().forEach(student -> {
            log.info("Enregistrement en base de l'objet {}", student);
            studentService.insertStudent(student);
        });
    }
}
