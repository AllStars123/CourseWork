package spbstu.course.six.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.six.domain.Diagnos;

@Repository
public interface DiagnosRepository extends CrudRepository<Diagnos, Long> {
}
