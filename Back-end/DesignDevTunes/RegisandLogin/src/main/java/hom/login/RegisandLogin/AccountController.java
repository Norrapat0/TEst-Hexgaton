package hom.login.RegisandLogin;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freelance.service.freelanceservice.Account;
import freelance.service.freelanceservice.AccountDTO;
import freelance.service.freelanceservice.Freelance;

@RestController
@CrossOrigin
@RequestMapping("api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/save")
    public ResponseEntity<String> saveAccount(@RequestBody AccountDTO accountDTO) {
        if (accountRepository.existsByEmail(accountDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use.");
        }

        if (accountRepository.existsByAccountname(accountDTO.getAccountname())) {
            return ResponseEntity.badRequest().body("Account name is already in use.");
        }

        String id = accountService.addAccount(accountDTO);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = accountService.loginMesage(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Account>> listAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        if (!accountRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PatchMapping("/list/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable long id, @RequestBody AccountDTO updatedAccountDTO) {
        Optional<Account> optionalAccount = accountRepository.findById(id);

        if (optionalAccount.isPresent()) {
            Account existingAccount = optionalAccount.get();

            if (updatedAccountDTO.getEmail() != null) {
                existingAccount.setEmail(updatedAccountDTO.getEmail());
            }
            if (updatedAccountDTO.getAccountname() != null) {
                existingAccount.setAccountname(updatedAccountDTO.getAccountname());
            }
            if (updatedAccountDTO.getNumberCard() != null) {
                existingAccount.setNumberCard(updatedAccountDTO.getNumberCard());
            }
            if (updatedAccountDTO.getPassword() != null) {
                existingAccount.setPassword(updatedAccountDTO.getPassword());
            }

            // Update associated Freelance entities if provided in the DTO
            if (updatedAccountDTO.getFreelance() != null) {
                List<Freelance> updatedFreelances = updatedAccountDTO.getFreelance();
                existingAccount.getFreelance().clear(); // Clear existing associations

                for (Freelance updatedFreelance : updatedFreelances) {
                    // You may need to map the DTO fields to the entity fields
                    Freelance newFreelance = new Freelance();
                    newFreelance.setName(updatedFreelance.getName());
                    newFreelance.setPrice(updatedFreelance.getPrice());
                    newFreelance.setTime(updatedFreelance.getTime());
                    newFreelance.setDescription(updatedFreelance.getDescription());
                    existingAccount.getFreelance().add(newFreelance); // Add to the collection
                }
            }

            // Save the updated account
            accountRepository.save(existingAccount);

            return new ResponseEntity<>("Account and Freelances updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }
    }
}
