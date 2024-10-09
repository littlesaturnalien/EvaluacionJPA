package org.cesar.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.cesar.interfaces.IClient;
import org.cesar.models.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ClientDAO implements IClient {

    private static final Logger logger = Logger.getLogger(ClientDAO.class.getName());

    @Override
    public void saveClient(Client client) {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerAdmin.getInstance();
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
            logger.info("Client Saved | Name: " + client.getFullName() + " | Id: " + client.getId());
        } catch (Exception e){
            if(entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();}
            logger.severe(e.getMessage());
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public List<Client> getAllClients() {
        EntityManager entityManager = null;
        List<Client> clients = new ArrayList<>();
        try {
            entityManager = EntityManagerAdmin.getInstance();
            TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
            clients = query.getResultList();
        } catch (Exception e){
            logger.severe("Error searching faculty with Id " + "\nError: " + e.getMessage());
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        if(clients.isEmpty()){logger.info("No Faculty Found");}
        return clients;
    }

    @Override
    public void updateClient(Client client) {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerAdmin.getInstance();
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.getTransaction().commit();
            logger.info("Client Updated");
        } catch (Exception e) {
            if(entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();}
            logger.severe("Error updating client with Id " + client.getId() + "\nError: " + e.getMessage());
        }
    }

    @Override
    public void deleteClient(Long id) {
        EntityManager entityManager = null;
        try {
            entityManager = EntityManagerAdmin.getInstance();
            entityManager.getTransaction().begin();
            Client client = entityManager.find(Client.class, id);
            entityManager.remove(client);
            entityManager.getTransaction().commit();
            logger.info("Client with Id" + id + " has been deleted.");
        } catch (Exception e) {
            if(entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            logger.severe("Error deleting client with Id " + id + "\nError: " + e.getMessage());
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public Client getClientById(Long id) {
        EntityManager entityManager = null;
        Client client = null;
        try{
            entityManager = EntityManagerAdmin.getInstance();
            TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c WHERE c.id = :id ", Client.class);
            query.setParameter("id", id);
            client = query.getSingleResult();
        } catch (Exception e){
            logger.severe("Error searching faculty with Id " + id + "\nError: " + e.getMessage());
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return client;
    }


}
