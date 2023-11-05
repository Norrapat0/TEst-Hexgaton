package hom.login.RegisandLogin;



public interface AccountService {
    
    String addAccount(AccountDTO accountDTO);
    
    LoginResponse loginMesage(LoginDTO loginDTO);
}
