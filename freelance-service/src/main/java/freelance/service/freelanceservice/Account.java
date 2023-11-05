package freelance.service.freelanceservice;

import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty
    private String accountname;

    @Column(name = "email", length = 255)
    @NotEmpty
    private String email;

    @Column(name = "password", length = 255)
    @NotEmpty
    private String password;

    @Column(name = "number_card", length = 13)
    private String numberCard;

    @Column(name = "descrip")
    private String descrip ;

    public Account() {
    }

    public Account(Long id, String accountname, String email, String numberCard, String password) {
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

}