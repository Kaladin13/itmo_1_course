package com.company.controller.dao;

import com.company.command.UserDTO;
import com.company.vehicle.ParsedVehicle;
import com.company.vehicle.VehicleSQL;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private  HibernateSessionFactory() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(UserDTO.class);
                configuration.addAnnotatedClass(VehicleSQL.class);
                StandardServiceRegistryBuilder registryBuilder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(registryBuilder.build());
            }
            catch (Exception e) {
                System.out.println("Exception in factory - ".concat(e.getLocalizedMessage()));
            }
        }
        return sessionFactory;
    }

}
