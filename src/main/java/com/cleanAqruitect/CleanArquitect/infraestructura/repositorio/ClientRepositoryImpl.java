package com.cleanAqruitect.CleanArquitect.infraestructura.repositorio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Client;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.ClientRepository;
import com.cleanAqruitect.CleanArquitect.infraestructura.dao.ClientDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientDao clientDao;

    @Override
    public Client getById(Long id) {
        return clientDao.getById(id);
    }

    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientDao.findAll();
    }

    @Override
    public Client update(Client client, Long clientId) {
        return null;
    }

    @Override
    public void deleteById(Long clientId) {
        clientDao.deleteById(clientId);
    }

    @Override
    public Client findClientByIdentif(String id){
      return clientDao.getClientByIdent(id);
    }
}
