package org.cesar.models.interfaces;

import org.cesar.models.Client;

import java.util.List;

public interface IClient {

    // CRUD
    public void saveFaculty(Client client);   // Create (On Database)
    public List<Client> getAllFaculties();    // Read
    public void updateFaculty(Client client); // Update
    public void deleteFaculty(Long id);       // Delete

}
