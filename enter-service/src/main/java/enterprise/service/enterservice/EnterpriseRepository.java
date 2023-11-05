package enterprise.service.enterservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import freelance.service.freelanceservice.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    List<Enterprise> findByName(String name);
    List<Enterprise> findByType(String type);
    public List<Enterprise> findByTypeAndSubtype(String type, String subtype);
}
