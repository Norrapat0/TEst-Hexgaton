package freelance.service.freelanceservice.History;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import freelance.service.freelanceservice.Freelance;


@Entity
@Table(name = "history_freelance")
public class HistoryFreelance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name =  "workFreelance_id", referencedColumnName = "id")
    private Freelance freelance;




    
    public HistoryFreelance() {
    }





    public HistoryFreelance(Long id, Freelance freelance) {
        this.id = id;
        this.freelance = freelance;
    }





    public Long getId() {
        return id;
    }





    public void setId(Long id) {
        this.id = id;
    }





    public Freelance getFreelance() {
        return freelance;
    }





    public void setFreelance(Freelance freelance) {
        this.freelance = freelance;
    }
    


    
    
}
