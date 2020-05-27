package spbstu.course.six.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spbstu.course.six.auth.User;
import spbstu.course.six.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return userRepository.findByUsername(s);
  }

  public User save(User user) {
    return userRepository.save(user);
  }
}
