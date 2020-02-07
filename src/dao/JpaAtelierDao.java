package dao;

import models.AtelierE;
import models.TacheE;
import org.hibernate.query.Query;

import java.util.Collection;

public class JpaAtelierDao extends JpaDao<AtelierE> implements AtelierDao{
    public AtelierE findFirstAvailable() {
        Query query = session.createQuery("SELECT a FROM AtelierE a ORDER BY datedispo asc");
        return (AtelierE) query.setMaxResults(1).getResultList();
    }

    @Override
    public AtelierE find(Integer idAtelier) {
        Query query = session.createQuery("SELECT a FROM AtelierE a WHERE id = "+idAtelier);
        return (AtelierE) query.getResultList();
    }

    @Override
    public AtelierE find(Class c, Integer id) {
        return null;
    }

    @Override
    public Collection<AtelierE> findAll() {
        Query query = session.createQuery("SELECT a FROM AtelierE a");
        return (Collection<AtelierE>) query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        Query query = session.createQuery("DELETE FROM AtelierE a");
        return (boolean) query.getSingleResult();
    }
}
