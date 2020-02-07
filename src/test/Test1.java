package test;

import models.AtelierE;
import models.MachineE;
import models.TacheE;

import java.sql.Timestamp;
import java.util.Date;

public class Test1 {

    public static void main(String[] args) {
        AtelierE a = new AtelierE();
        MachineE m1 = new MachineE();
        MachineE m2 = new MachineE();
        long timeMillis = System.currentTimeMillis();
        TacheE t1 = new TacheE(45, new Timestamp(new Date(timeMillis+60000*120).getTime()), 5.0);
        TacheE t2 = new TacheE(120, new Timestamp(new Date(timeMillis+60000*150).getTime()), 10.0);
        TacheE t3 = new TacheE(70, new Timestamp(new Date(timeMillis+60000*180).getTime()), 4.0);
        TacheE t4 = new TacheE(60, new Timestamp(new Date(timeMillis+60000*300).getTime()), 12.0);
        a.addMachine(m1);
        a.addMachine(m2);
        m1.addTache(t1);
        m1.addTache(t2);
        m2.addTache(t3);
        m2.addTache(t4);
    }

}
