package dao;

import models.TacheE;

import java.util.Collection;

public interface TacheDao extends Dao<TacheE> {
    public Collection<TacheE> findAllNotScheduled();
}
