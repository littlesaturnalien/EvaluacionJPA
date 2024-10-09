package interfaces;

import models.Client;

import java.util.List;

public interface iClient {
    public void save(Client client);
    public Client getClient(Long id);
    public void update(Client client);
    public void delete(Client client);
    public List<Client> getAllClients();
}
