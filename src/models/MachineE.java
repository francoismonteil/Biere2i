package models;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "machine", schema = "Bierre2i")
public class MachineE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp datedispo;
    private double penalitetotale;
    private int natelier;

    @OneToMany(mappedBy = "machine")
    private List<TacheE> taches;

    @ManyToOne
    @JoinColumn(name = "id")
    private AtelierE atelier;

    public MachineE(){
        this.taches = new ArrayList<TacheE>();
        this.datedispo = new Timestamp(System.currentTimeMillis());
    }

    public boolean addTache(TacheE t){
        try {
            this.taches.add(t);
            t.setMachine(this);
            t.setDatedebut(this.datedispo);

            //Mise à jour date dispo
            long duree = new Timestamp(t.getTempsprod()).getTime()*60000+this.datedispo.getTime();
            this.datedispo = new Timestamp(duree);

            //Ajouter pénalité de retard
            if(this.datedispo.getTime() > t.getDatelimite().getTime()){
                this.penalitetotale = this.datedispo.getTime()-t.getDatelimite().getTime()/60000.0*t.getPenaliteretard();
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datedispo")
    public Timestamp getDatedispo() {
        return datedispo;
    }

    public void setDatedispo(Timestamp datedispo) {
        this.datedispo = datedispo;
    }

    @Basic
    @Column(name = "penalitetotale")
    public double getPenalitetotale() {
        return penalitetotale;
    }

    public void setPenalitetotale(double penalitetotale) {
        this.penalitetotale = penalitetotale;
    }

    public AtelierE getAtelier() {
        return atelier;
    }

    public void setAtelier(AtelierE atelier) {
        this.atelier = atelier;
        this.natelier = atelier.getId();
    }

    public int getNatelier() {
        return natelier;
    }

    public void setNatelier(int natelier) {
        this.natelier = natelier;
    }

    public List<TacheE> getTaches() {
        return taches;
    }

    public void setTaches(List<TacheE> taches) {
        this.taches = taches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MachineE machineE = (MachineE) o;
        return id == machineE.id &&
                Double.compare(machineE.penalitetotale, penalitetotale) == 0 &&
                Objects.equals(datedispo, machineE.datedispo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datedispo, penalitetotale);
    }
}
