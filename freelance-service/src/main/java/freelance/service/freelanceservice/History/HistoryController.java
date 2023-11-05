package freelance.service.freelanceservice.History;
// package freelance.service.freelanceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
// import hom.login.RegisandLogin.AccountRepository;

@CrossOrigin
@RestController
@RequestMapping("/historys")
public class HistoryController {

    @Autowired
    private HistoryRepositoryEnterprise historyRepository;


    @Autowired
    private HistoryRepositoryFreelance historyRepositoryFreelance;
   
    // @Autowired
    // private AccountRepository accountRepository;

    /**Enterprise */
    @GetMapping("/enterprise")
    public List<HistoryEnterprise> getAllHistory_Enterprises(){
        return historyRepository.findAll();
    }

    @PostMapping("/enterprise")
    public HistoryEnterprise addHistory_Enterprise(@RequestBody HistoryEnterprise history){
        return historyRepository.save(history);
    }







    /**Freelance */
    @GetMapping("/freelance")
    public List<HistoryFreelance> getAllHistory_freelance(){
        return historyRepositoryFreelance.findAll();
    }
    

      @PostMapping("/freelance")
    public HistoryFreelance addHistory_Freelance(@RequestBody HistoryFreelance history){
        return historyRepositoryFreelance.save(history);
    }



// @GetMapping("/accountid/{id}")
// public List<HistoryEntity> findByAccount(@PathVariable Long id) {
//     // Retrieve the Account object based on the 'id' parameter, or use a service to do this
//     Account account = accountRepository.findById(id).orElse(null);

//     if (account != null) {
//         return historyRepository.findByAccount(account.getAccountid());
//     } else {
//         // Handle the case when the Account with the given 'id' is not found
//         return new ArrayList<>();
        
//     }
// }

  




}
