package org.module_10;

import org.module_10.entity.Client;
import org.module_10.entity.Planet;
import org.module_10.services.ClientCrudService;
import org.module_10.services.PlanetCrudService;
import org.module_10.util.DatabaseMigration;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseMigration migration = new DatabaseMigration();
        migration.initDb();

        ClientCrudService clientCrudService = new ClientCrudService();
//        Client client = new Client();
//        client.setName("Jane Doe");
//        long clientId = clientCrudService.create(client);
//
//        Client retrievedClient = clientCrudService.getById(clientId);
//        System.out.println("Retrieved Client: " + retrievedClient);

//        List<Client> allClients = clientCrudService.listAll();
//        System.out.println(allClients);

        // Test Planet
//        PlanetCrudService planetCrudService = new PlanetCrudService();
//        Planet planet = new Planet();
//        planet.setId("SAT5");
//        planet.setName("Saturn");
//        String planetId = planetCrudService.create(planet);

//        Planet retrievedPlanet = planetCrudService.getById(planetId);
//        System.out.println("Retrieved Planet: " + retrievedPlanet);
    }
}
