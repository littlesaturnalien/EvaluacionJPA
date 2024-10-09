package org.cesar.interfaces;

import org.cesar.models.Client;

import java.util.List;

public interface IClient {

    // CRUD
    public void saveClient(Client client);   // Create (On Database)
    public List<Client> getAllClients();    // Read
    public void updateClient(Client client); // Update
    public void deleteClient(Long id);       // Delete
    public Client getClientById(Long id);
}
