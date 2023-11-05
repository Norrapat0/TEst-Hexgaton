package hom.login.RegisandLogin;

import java.util.List;

public class AccountDTO {
    private Long id;
    private String accountname;
    private String email;
    private String password;
    private String numberCard;

    private String descrip ;


    public AccountDTO() {
    }

    public AccountDTO(Long id, String accountname, String email, String numberCard, String password) {
        this.id = id;
        this.accountname = accountname;
        this.email = email;
        this.password = password;
        this.numberCard = numberCard;
    }

    public Long getAccountid() {
        return id;
    }

    public void setAccountid(Long id) {
        this.id = id;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }
   


    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Override
    public String toString() {
        return "AccountDTO [accountid=" + id + ", accountname=" + accountname + ", email=" + email
                + ", password=" + password + "]";
    }


}