package client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.module_10.entity.Client;
import org.module_10.services.ClientCrudService;
import org.module_10.util.DatabaseMigration;
import org.module_10.util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClientCrudServiceTest {
    private ClientCrudService crudService;
    @BeforeEach
    void beforeEach(){
        new DatabaseMigration().initDb();
        crudService = new ClientCrudService();
    }
    @AfterEach
    void afterEach(){
        HibernateUtil.getInstance().close();
    }
    @Test
    void testCreatingNewClientWorkOk(){
        Client newClient = new Client();
        newClient.setName("Test Client");

        long createId = crudService.create(newClient);

        Client saved = crudService.getById(createId);

        Assertions.assertEquals(newClient.getName(),saved.getName());

        System.out.println("saved ="+saved);

        crudService.deleteById(newClient.getId());
    }
    @Test
    void testGetByIdClientWorkOk(){
        Client client1 = new Client();
        client1.setName("Get By Id");
        long createId = crudService.create(client1);

        Client retrievedClient = crudService.getById(createId);

        Assertions.assertNotNull(retrievedClient);
        assertEquals(client1.getName(), retrievedClient.getName());

        crudService.deleteById(createId);
    }
    @Test
    void testDeleteByIdClientWorkOk(){
        Client client1 = new Client();
        client1.setName("Delete By Id");
        long createId = crudService.create(client1);

        crudService.deleteById(createId);

        Client deleted = crudService.getById(createId);

        Assertions.assertNull(deleted);

    }
    @Test
    void testUpdateClientTableWorkOk(){
        Client newClient = new Client();
        newClient.setName("Update Client");
        long createId = crudService.create(newClient);

        Client retrievedClient = crudService.getById(createId);
        retrievedClient.setName("Updated Client");
        crudService.update(retrievedClient);

        Client updatedClient = crudService.getById(createId);

        assertEquals("Updated Client", updatedClient.getName());

        crudService.deleteById(createId);
    }

    @Test
     void testGetAllClientsWorksOk(){
        List<Client> clients = crudService.listAll();

        Assertions.assertNotNull(clients);
        Assertions.assertFalse(clients.isEmpty());

        Assertions.assertEquals(11, clients.size());
    }

}
