package spbstu.course.six.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.six.domain.Person;

@Repository
public interface PersonRepositroy extends CrudRepository<Person, Long> {
}
