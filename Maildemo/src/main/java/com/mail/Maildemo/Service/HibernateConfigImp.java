package com.mail.Maildemo.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
@Service
public class HibernateConfigImp implements HibernateConfig {

    private Session session;
    private SessionFactory factory;
    private Transaction transaction;

    @Override
    public void connect(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();

        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    @Override
    public void finish(){
        if(factory!=null) {
            factory.close();
        }
        if(session!=null) {
            session.close();
        }
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Transaction getTransaction() {
        return this.transaction;
    }

}
