package com.mail.Maildemo.Service;

import org.hibernate.Session;


public interface HibernateConfig {
    void connect();
    void commit();

    Session getSession();

}
