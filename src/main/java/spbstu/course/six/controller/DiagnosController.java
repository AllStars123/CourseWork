package spbstu.course.six.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.course.six.table.Diagnos;
import spbstu.course.six.repository.DiagnosRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
@RequestMapping("diagnos")
public class DiagnosController {
  private final DiagnosRepository diagnosRepository;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public List<Diagnos> getAll() {
    return StreamSupport
        .stream(diagnosRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Diagnos getOne(@PathVariable("id") Diagnos diagnos) {
    return diagnos;
  }

  @PostMapping
  @PreAuthorize("isAuthenticated()")
  public Diagnos saveOne(@RequestBody Diagnos diagnos) {
    return diagnosRepository.save(diagnos);
  }

  @PutMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Diagnos updateOne(@PathVariable("id") Diagnos diagnos, @RequestBody Diagnos updatedDiagnos) {
    BeanUtils.copyProperties(updatedDiagnos, diagnos, "id");

    return diagnosRepository.save(diagnos);
  }

  @DeleteMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Diagnos diagnos) {
    diagnosRepository.delete(diagnos);
  }
}
