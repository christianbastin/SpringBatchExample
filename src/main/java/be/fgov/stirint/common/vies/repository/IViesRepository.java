package be.fgov.stirint.common.vies.repository;

import be.fgov.stirint.common.vies.model.Vies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViesRepository extends JpaRepository<Vies, Long> {
}
