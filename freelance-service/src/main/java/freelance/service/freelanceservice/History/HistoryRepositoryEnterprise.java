package freelance.service.freelanceservice.History;
// package freelance.service.freelanceservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepositoryEnterprise extends JpaRepository<HistoryEnterprise,Long>{
        List<HistoryEnterprise> findByid(Long id);
        // List<HistoryEntity> findByAccount(Long accountid);

}
