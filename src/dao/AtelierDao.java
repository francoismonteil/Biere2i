package dao;

import models.AtelierE;

import java.util.Collection;

public interface AtelierDao extends Dao<AtelierE> {
    public AtelierE findFirstAvailable();
}
