package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "atelier", schema = "Bierre2i")
public class AtelierE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp datedispo;

    @OneToMany(mappedBy = "atelier")
    private List<MachineE> machines;

    public AtelierE() {
        this.machines = new ArrayList<MachineE>();
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

    public boolean addMachine(MachineE m){
        try {
            this.machines.add(m);
            m.setAtelier(this);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtelierE atelierE = (AtelierE) o;
        return id == atelierE.id &&
                Objects.equals(datedispo, atelierE.datedispo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datedispo);
    }
}
