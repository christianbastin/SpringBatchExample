package be.fgov.stirint.common.vies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.fgov.stirint.common.vies.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
