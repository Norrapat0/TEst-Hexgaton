package freelance.service.freelanceservice.Progress;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import freelance.service.freelanceservice.Enterprise;
import freelance.service.freelanceservice.Freelance;

@Entity
@Table(name = "Progress")
public class Progree {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name =  "enterprise_id", referencedColumnName = "id")
    private  Enterprise enterprise ;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name =  "freelancer_id", referencedColumnName = "id")
    private Freelance freelancer ;

    private String status;
   
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Freelance getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelance freelancer) {
        this.freelancer = freelancer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
