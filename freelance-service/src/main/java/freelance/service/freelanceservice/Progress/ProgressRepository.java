package freelance.service.freelanceservice.Progress;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProgressRepository  extends JpaRepository<Progree,Long>{
    List<Progree>   findAll();
    List<Progree> findByid(Long id);
}
