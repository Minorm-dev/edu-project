package com.minorm.eduproject.integration.architect;

import com.minorm.eduproject.database.entity.Role;
import com.minorm.eduproject.database.entity.User;
import com.minorm.eduproject.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RequiredArgsConstructor
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findByEmail_ShouldReturnUser() {
        User user = User.builder()
                .email("test@test.com")
                .password("encodedPass")
                .firstName("John")
                .lastName("Smith")
                .role(Role.ROLE_STUDENT)
                .build();
        entityManager.persistAndFlush(user);

        Optional<User> found = userRepository.findByEmail("test@test.com");

        assertThat(found)
                .isPresent()
                .hasValueSatisfying(u -> {
                    assertThat(u.getFirstName()).isEqualTo("John");
                    assertThat(u.getRole()).isEqualTo(Role.ROLE_STUDENT);
                });
    }

    @Test
    void existsByEmail_ShouldReturnTrueForExistingEmail() {
        User user = User.builder()
                .email("test@test.com")
                .build();
        entityManager.persist(user);

        assertThat(userRepository.existsByEmail("test@test.com")).isTrue();
    }

}
