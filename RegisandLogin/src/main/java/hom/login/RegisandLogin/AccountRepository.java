package hom.login.RegisandLogin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@EnableJpaRepositories
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findOneByEmailAndPassword(String email, String password);
    List<Account>   findAll();
    Account findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByAccountname(String accountname);
}

