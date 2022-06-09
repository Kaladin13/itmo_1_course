package com.company.controller.dao;

import com.company.command.UserDTO;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAO {

    public boolean checkIfLoginExists(String login) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from UserDTO where login=:login");
        UserDTO userDTO = (UserDTO) query.setParameter("login", login).uniqueResult();
        session.close();
        return userDTO != null;
    }

    public void save(UserDTO userDTO) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(userDTO);
        tx.commit();
        session.close();
    }

    public boolean contains(UserDTO userDTO) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from UserDTO where login=:login and password=:password");

        UserDTO user = (UserDTO) query
                .setParameter("login", userDTO.getLogin())
                .setParameter("password", userDTO.getPassword())
                .uniqueResult();
        session.close();
        return user != null;
    }

    public UserDTO get(UserDTO userDTO) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from UserDTO where login=:login and password=:password");

        UserDTO user = (UserDTO) query
                .setParameter("login", userDTO.getLogin())
                .setParameter("password", userDTO.getPassword())
                .uniqueResult();
        session.close();
        return user;
    }

}
