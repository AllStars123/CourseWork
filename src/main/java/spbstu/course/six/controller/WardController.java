package spbstu.course.six.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.course.six.table.Ward;
import spbstu.course.six.repository.WardRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("ward")
@RequiredArgsConstructor
public class WardController {
  private final WardRepository wardRepository;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public List<Ward> getAll() {
    return StreamSupport
        .stream(wardRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Ward getOne(@PathVariable("id") Ward ward) {
    return ward;
  }

  @PostMapping
  @PreAuthorize("isAuthenticated()")
  public Ward saveOne(@RequestBody Ward ward) {
    return wardRepository.save(ward);
  }

  @PutMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Ward updateOne(@PathVariable("id") Ward ward, @RequestBody Ward updatedWard) {
    BeanUtils.copyProperties(updatedWard, ward, "id");

    return wardRepository.save(ward);
  }

  @DeleteMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Ward ward) {
    wardRepository.delete(ward);
  }
}
