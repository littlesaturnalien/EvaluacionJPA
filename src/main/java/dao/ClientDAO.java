package dao;

import interfaces.iClient;
import models.Client;

import java.util.List;

public class ClientDAO implements iClient {
    @Override
    public void save(Client client) {

    }

    @Override
    public Client getClient(Long id) {
        return null;
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public List<Client> getAllClients() {
        return List.of();
    }
}
