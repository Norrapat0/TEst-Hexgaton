package freelance.service.freelanceservice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelanceRepository extends JpaRepository<Freelance, Long> {
    List<Freelance> findByName(String name);
    List<Freelance> findByType(String type);
    public List<Freelance> findByTypeAndSubtype(String type, String subtype);
}
