package test;

import dao.*;
import models.AtelierE;
import models.MachineE;
import models.TacheE;

import java.sql.Timestamp;
import java.util.Date;

public class Test2 {

    public static void main(String[] args) {
        AtelierE a = new AtelierE();
        MachineE m1 = new MachineE();
        MachineE m2 = new MachineE();
        long timeMillis = System.currentTimeMillis();
        TacheE t1 = new TacheE(45, new Timestamp(new Date(timeMillis+60000*120).getTime()), 5.0);
        TacheE t2 = new TacheE(120, new Timestamp(new Date(timeMillis+60000*150).getTime()), 10.0);
        TacheE t3 = new TacheE(70, new Timestamp(new Date(timeMillis+60000*180).getTime()), 4.0);
        TacheE t4 = new TacheE(60, new Timestamp(new Date(timeMillis+60000*300).getTime()), 12.0);
        AtelierDao atelierManager = new JpaAtelierDao();
        MachineDao machineManager = new JpaMachineDao();
        TacheDao tacheManager = new JpaTacheDao();
        tacheManager.deleteAll();
        machineManager.deleteAll();
        atelierManager.deleteAll();
        a.addMachine(m1);
        a.addMachine(m2);
        atelierManager.create(a);
        tacheManager.create(t1);
        tacheManager.create(t2);
        tacheManager.create(t3);
        tacheManager.create(t4);
        // doit afficher les 4 taches
        for(TacheE t : tacheManager.findAllNotScheduled()) {
            System.out.println(t);
        }
        m1.addTache(t1);
        m1.addTache(t2);
        m2.addTache(t3);
        m2.addTache(t4);
        tacheManager.update(t1);
        tacheManager.update(t2);
        tacheManager.update(t3);
        tacheManager.update(t4);
    }

}
