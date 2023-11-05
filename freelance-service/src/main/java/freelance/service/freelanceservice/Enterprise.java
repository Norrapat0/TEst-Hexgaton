package freelance.service.freelanceservice;

import javax.persistence.*;


@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String price;
    private int time;
    private String description;
    private String type;
    private String subtype;
    private String location;
    private String workprocess;
    private String examplejob;
    private int fixtime;
    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
     
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public Enterprise() {
    }

    

    public Enterprise(Long id, String name, String price, int time, String description, String type, String subtype,
            String location, String workprocess, String examplejob, int fixtime, Account account) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
        this.description = description;
        this.type = type;
        this.subtype = subtype;
        this.location = location;
        this.workprocess = workprocess;
        this.examplejob = examplejob;
        this.fixtime = fixtime;
        this.account = account;
    }

    public String getworkprocess() {
        return workprocess;
    }

    public void setworkprocess(String workprocess) {
        this.workprocess = workprocess;
    }

    public String getExamplejob() {
        return examplejob;
    }

    public void setExamplejob(String examplejob) {
        this.examplejob = examplejob;
    }

    public int getFixtime() {
        return fixtime;
    }

    public void setFixtime(int fixtime) {
        this.fixtime = fixtime;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}
