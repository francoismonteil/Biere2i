package dao;

import models.AtelierE;
import models.MachineE;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaMachineDao extends JpaDao<MachineE> implements MachineDao {
    @Override
    public MachineE find(Integer id) {
        Query query = session.createQuery("SELECT m FROM MachineE m WHERE id = " + id);
        return (MachineE) query.getResultList();
    }

    @Override
    public MachineE find(Class c, Integer id) {
        return null;
    }

    @Override
    public Collection<MachineE> findAll() {
        Query query = session.createQuery("SELECT m FROM MachineE m");
        return (Collection<MachineE>) query.getResultList();
    }

    public boolean deleteAll() {
        Query query = session.createQuery("DELETE FROM MachineE m");
        return (boolean) query.getSingleResult();
    }
}
