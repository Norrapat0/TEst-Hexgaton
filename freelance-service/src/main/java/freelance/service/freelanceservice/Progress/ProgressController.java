package freelance.service.freelanceservice.Progress;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@CrossOrigin
public class ProgressController {

    @Autowired
    private ProgressRepository progressRepository;

    @GetMapping
    public List<Progree> getAllHistory() {
        return progressRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createHistoryEntity(@RequestBody Progree progree) {
        progressRepository.save(progree);
        return ResponseEntity.ok("Create success!!");
    }

    @PutMapping("/{id}")
    public Progree updateFreelance(@PathVariable Long id, @RequestBody Progree updatedprogree) {
        Progree existingprogree = progressRepository.findById(id).orElse(null);

        if (existingprogree != null) {
            existingprogree.setStatus(updatedprogree.getStatus());
            existingprogree.setEnterprise(updatedprogree.getEnterprise());
            existingprogree.setFreelancer(updatedprogree.getFreelancer());
            return progressRepository.save(existingprogree);
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Progree patchProgress(@PathVariable Long id, @RequestBody Progree patchedProgress) {
        Progree existingProgress = progressRepository.findById(id).orElse(null);

        if (existingProgress != null) {
            if (patchedProgress.getStatus() != null) {
                existingProgress.setStatus(patchedProgress.getStatus());
            }
            if (patchedProgress.getEnterprise() != null) {
                existingProgress.setEnterprise(patchedProgress.getEnterprise());
            }
            if (patchedProgress.getFreelancer() != null) {
                existingProgress.setFreelancer(patchedProgress.getFreelancer());
            }
            return progressRepository.save(existingProgress);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnterprises(@PathVariable Long id) {
        try {

            Progree progree = progressRepository.findById(id).orElse(null);
            if (progree != null) {
                // Set the foreign key value to null (assuming the relationship allows this)
                progree.setEnterprise(null);
                progree.setFreelancer(null);
                progressRepository.save(progree);
            }
            progressRepository.deleteById(id);
            return ResponseEntity.ok("Enterprise deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.ok("Enterprise deleted notsuccessfully.");
        }
    }
}
