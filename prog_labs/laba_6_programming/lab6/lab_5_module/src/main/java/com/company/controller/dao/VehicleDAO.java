package com.company.controller.dao;

import com.company.vehicle.Vehicle;
import com.company.vehicle.VehicleSQL;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class VehicleDAO {
    public void save(VehicleSQL vehicleSQL) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(vehicleSQL);
        tx.commit();
        session.close();
    }

    public void update(VehicleSQL vehicleSQL) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(vehicleSQL);
        tx.commit();
        session.close();
    }

    public void delete(VehicleSQL vehicleSQL) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(vehicleSQL);
        tx.commit();
        session.close();
    }

    public List getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from VehicleSQL ");
        List vehicleSQL = query.list();
        session.close();
        return vehicleSQL;
    }

    public VehicleSQL get(VehicleSQL vehicleSQL) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from VehicleSQL where capacity=:capacity and name=:name and enginePower=:enginePower");
        VehicleSQL vehicleSQL1 = (VehicleSQL) query
                .setParameter("capacity", vehicleSQL.getCapacity())
                .setParameter("name", vehicleSQL.getName())
                .setParameter("enginePower", vehicleSQL.getEnginePower()).uniqueResult();
        session.close();
        return vehicleSQL1;
    }
}
