package com.mail.Maildemo.Service;

import org.hibernate.Session;
import org.hibernate.Transaction;


public interface HibernateConfig {
    void connect();
    void finish();

    Session getSession();

    Transaction getTransaction();

}
