// package com.history.history;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import freelance.service.freelanceservice.HistoryEntity;
// import freelance.service.freelanceservice.Account;

// import java.util.ArrayList;
// import java.util.List;
// // import hom.login.RegisandLogin.AccountRepository;

// import javax.ws.rs.core.Response;

// @CrossOrigin
// @RestController
// @RequestMapping("/historys")
// public class HistoryController {

//     @Autowired
//     private HistoryRepository historyRepository;

//     // @Autowired
//     // private AccountRepository accountRepository;

//     @GetMapping
//     public List<HistoryEntity> getAllHistory() {
//         return historyRepository.findAll();
//     }

//     // @GetMapping("/accountid/{id}")
//     // public List<HistoryEntity> findByAccount(@PathVariable Long id) {
//     // // Retrieve the Account object based on the 'id' parameter, or use a service
//     // to do this
//     // Account account = accountRepository.findById(id).orElse(null);

//     // if (account != null) {
//     // return historyRepository.findByAccount(account.getAccountid());
//     // } else {
//     // // Handle the case when the Account with the given 'id' is not found
//     // return new ArrayList<>();

//     // }
//     // }

//     @PostMapping
//     public ResponseEntity<String> createHistoryEntity(@RequestBody HistoryEntity historyEntity) {
//         historyRepository.save(historyEntity);
//         return ResponseEntity.ok("Create success!!");
//     }

// }
