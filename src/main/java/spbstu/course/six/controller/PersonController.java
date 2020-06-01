package spbstu.course.six.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.course.six.table.Person;
import spbstu.course.six.repository.PersonRepositroy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
@RequestMapping("person")
public class PersonController {
  private final PersonRepositroy personRepositroy;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public List<Person> getAll() {
    return StreamSupport
        .stream(personRepositroy.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Person getOne(@PathVariable("id") Person person) {
    return person;
  }

  @PostMapping
  @PreAuthorize("isAuthenticated()")
  public Person saveOne(@RequestBody Person person) {
    return personRepositroy.save(person);
  }

  @PutMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Person updateOne(@PathVariable("id") Person person, @RequestBody Person updatedPerson) {
    BeanUtils.copyProperties(updatedPerson, person, "id");

    return personRepositroy.save(person);
  }

  @DeleteMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Person person) {
    personRepositroy.delete(person);
  }
}
