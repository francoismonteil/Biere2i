package dao;

import models.TacheE;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaTacheDao extends JpaDao<TacheE> implements TacheDao{
    @Override
    public Collection<TacheE> findAllNotScheduled() {
        Query query = session.createQuery("SELECT t FROM TacheE t WHERE nmachine is null");
        return (Collection<TacheE>) query.getResultList();
    }

    @Override
    public TacheE find(Integer id) {
        Query query = session.createQuery("SELECT t FROM TacheE t WHERE id = " + id);
        return (TacheE) query.getResultList();
    }

    @Override
    public TacheE find(Class c, Integer id) {
        return null;
    }

    @Override
    public Collection<TacheE> findAll() {
        Query query = session.createQuery("SELECT t FROM TacheE t");
        return (Collection<TacheE>) query.getResultList();
    }

    public boolean deleteAll() {
        if(session.createQuery("DELETE FROM TacheE").executeUpdate() > 0){
            return true;
        }
        return false;
    }
}
