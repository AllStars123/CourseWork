package spbstu.course.six.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.six.domain.Ward;

@Repository
public interface WardRepository extends CrudRepository<Ward, Long> {
}
