package freelance.service.freelanceservice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class FreelanceDTO {
    private Long id;
    private String name;
    private String price;
    private int time;
    private String description;
    private String type;
    private Account account;
    private String subtype;
    private String companyName;
    public FreelanceDTO() {
    }
    
    public FreelanceDTO(Long id, String name, String price, int time, String description, String type, Account account,
            String subtype, String companyName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
        this.description = description;
        this.type = type;
        this.account = account;
        this.subtype = subtype;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public String getSubtype() {
        return subtype;
    }
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    
}
