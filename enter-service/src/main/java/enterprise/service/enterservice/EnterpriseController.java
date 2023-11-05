package enterprise.service.enterservice;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import freelance.service.freelanceservice.Enterprise;
import freelance.service.freelanceservice.Freelance;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @GetMapping
    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Enterprise getEnterpriseById(@PathVariable Long id) {
        return enterpriseRepository.findById(id).orElse(null);
    }

    @GetMapping("/type/{type}")
    public List<Enterprise> findEnterprisesByType(@PathVariable String type) {
        return enterpriseRepository.findByType(type);
    }

    @GetMapping("/type/{type}/{subtype}")
    public List<Enterprise> findFreelanceByTypeandSubtype(@PathVariable String type, @PathVariable String subtype) {
        return enterpriseRepository.findByTypeAndSubtype(type, subtype);
    }

    @PostMapping
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    @PutMapping("/{id}")
    public Enterprise updateEnterprise(@PathVariable Long id, @RequestBody Enterprise updatedEnterprise) {
        Enterprise existingEnterprise = enterpriseRepository.findById(id).orElse(null);

        if (existingEnterprise != null) {
            existingEnterprise.setName(updatedEnterprise.getName());
            existingEnterprise.setPrice(updatedEnterprise.getPrice());
            existingEnterprise.setTime(updatedEnterprise.getTime());
            existingEnterprise.setDescription(updatedEnterprise.getDescription());
            existingEnterprise.setType(updatedEnterprise.getType());
            existingEnterprise.setAccount(updatedEnterprise.getAccount());
            existingEnterprise.setSubtype(updatedEnterprise.getSubtype());
            existingEnterprise.setLocation(updatedEnterprise.getLocation());
            existingEnterprise.setworkprocess(updatedEnterprise.getworkprocess());
            existingEnterprise.setExamplejob(updatedEnterprise.getExamplejob());
            existingEnterprise.setFixtime(updatedEnterprise.getFixtime());
            return enterpriseRepository.save(existingEnterprise);
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Enterprise patchEnterprise(@PathVariable Long id, @RequestBody Enterprise patchedEnterprise) {
        Enterprise existingEnterprise = enterpriseRepository.findById(id).orElse(null);

        if (existingEnterprise != null) {
            // ตรวจสอบและทำการปรับปรุงข้อมูลที่ต้องการ
            if (patchedEnterprise.getName() != null) {
                existingEnterprise.setName(patchedEnterprise.getName());
            }
            if (patchedEnterprise.getPrice() != null) {
                existingEnterprise.setPrice(patchedEnterprise.getPrice());
            }
            // if (patchedEnterprise.getTime() != null) {
            // existingEnterprise.setTime(patchedEnterprise.getTime());
            // }
            if (patchedEnterprise.getDescription() != null) {
                existingEnterprise.setDescription(patchedEnterprise.getDescription());
            }
            if (patchedEnterprise.getType() != null) {
                existingEnterprise.setType(patchedEnterprise.getType());
            }
            if (patchedEnterprise.getSubtype() != null) {
                existingEnterprise.setType(patchedEnterprise.getSubtype());
            }

            if (patchedEnterprise.getLocation() != null) {
                existingEnterprise.setLocation(patchedEnterprise.getLocation());
            }

            return enterpriseRepository.save(existingEnterprise);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEnterprise(@PathVariable Long id) {
        enterpriseRepository.deleteById(id);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<String> deleteEnterprises(@PathVariable Long id) {
        try {
            
            Enterprise enterprise = enterpriseRepository.findById(id).orElse(null);
            if (enterprise != null) {
                // Set the foreign key value to null (assuming the relationship allows this)
                enterprise.setAccount(null);
                enterpriseRepository.save(enterprise);
            }
            enterpriseRepository.deleteById(id);
            return ResponseEntity.ok("Enterprise deleted successfully.");
        } catch (Exception e) {
             return ResponseEntity.ok("Enterprise deleted notsuccessfully.");
        }
    }

    

}
