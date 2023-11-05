package hom.login.RegisandLogin;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.annotation.Resource;

@Service
public class AccountIMPL implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addAccount(AccountDTO accountDTO) {
    Account account=new Account(accountDTO.getAccountid(), accountDTO.getAccountname(), accountDTO.getEmail(), accountDTO.getNumberCard(), this.passwordEncoder.encode(accountDTO.getPassword()));
    accountRepository.save(account);
    return account.getAccountname();

    }

    AccountDTO accountDTO;
 
    @Override
    public LoginResponse  loginMesage(LoginDTO loginDTO) {
        String msg = "";
        Account account1 = accountRepository.findByEmail(loginDTO.getEmail());
        if (account1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = account1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Account> account = accountRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (account.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
    
        

   
    
}
