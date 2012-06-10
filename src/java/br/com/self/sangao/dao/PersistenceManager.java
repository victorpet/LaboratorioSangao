/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.dao;

import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author treinamento
 */
public class PersistenceManager {

    private static PersistenceManager entity;
    private EntityManagerFactory emf;

    public static PersistenceManager getInstance(){
        if (entity == null)
            entity = new PersistenceManager();
        return entity;
    }

    public PersistenceManager() {
        createEntityManager();
    }

    public EntityManager getConnection() {
        return emf.createEntityManager();
    }

    private void createEntityManager() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("hibernate.connection.url", "");
        map.put("hibernate.dialect", "");
        map.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        map.put("hibernate.connection.username", "postgres");
        map.put("hibernate.connection.password", "postgres");
        
        emf = Persistence.createEntityManagerFactory("unit", map);
    }
}
