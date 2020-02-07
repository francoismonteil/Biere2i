package models;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tache", schema = "Bierre2i")
public class TacheE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tempsprod;
    private Timestamp datedebut;
    private Timestamp datelimite;
    private Double penaliteretard;
    private int nmachine;

    @ManyToOne
    @JoinColumn(name = "id")
    private MachineE machine;

    public TacheE(){};

    public TacheE(int tempsprod, Timestamp datedebut, Double penaliteretard){
        this.tempsprod = tempsprod;
        this.datedebut = datedebut;
        this.penaliteretard = penaliteretard;

        //Mise à jour date limite
        long duree = new Timestamp(this.tempsprod*60000).getTime()+datedebut.getTime();
        this.datelimite = new Timestamp(duree);
    }

    public MachineE getMachine() {
        return machine;
    }

    public void setMachine(MachineE machine) {
        this.machine = machine;
        this.setNmachine(machine.getId());
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
    @Column(name = "tempsprod")
    public int getTempsprod() {
        return tempsprod;
    }

    public void setTempsprod(int tempsprod) {
        this.tempsprod = tempsprod;
    }

    @Basic
    @Column(name = "datedebut")
    public Timestamp getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Timestamp datedebut) {
        this.datedebut = datedebut;
    }

    @Basic
    @Column(name = "datelimite")
    public Timestamp getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(Timestamp datelimite) {
        this.datelimite = datelimite;
    }

    @Basic
    @Column(name = "penaliteretard")
    public Double getPenaliteretard() {
        return penaliteretard;
    }

    public void setPenaliteretard(Double penaliteretard) {
        this.penaliteretard = penaliteretard;
    }


    public int getNmachine() {
        return nmachine;
    }

    public void setNmachine(int nmachine) {
        this.nmachine = nmachine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TacheE tacheE = (TacheE) o;
        return id == tacheE.id &&
                tempsprod == tacheE.tempsprod &&
                Objects.equals(datedebut, tacheE.datedebut) &&
                Objects.equals(datelimite, tacheE.datelimite) &&
                Objects.equals(penaliteretard, tacheE.penaliteretard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tempsprod, datedebut, datelimite, penaliteretard);
    }
}
