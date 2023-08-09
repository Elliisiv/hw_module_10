package planet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.module_10.entity.Client;
import org.module_10.entity.Planet;
import org.module_10.services.PlanetCrudService;
import org.module_10.util.DatabaseMigration;
import org.module_10.util.HibernateUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlanetCrudServiceTest {
    private PlanetCrudService service;
    @BeforeEach
    void beforeEach(){
        new DatabaseMigration().initDb();
        service = new PlanetCrudService();
    }
    @AfterEach
    void afterEach(){
        HibernateUtil.getInstance().close();
    }
    @Test
    void testCreatingNewPlanetWorkOk(){
        Planet original = new Planet();
        original.setId("TN1");
        original.setName("TestName");

        String createdId = service.create(original);

        Planet saved = service.getById(createdId);

        Assertions.assertEquals(original.getId(), saved.getId());
        Assertions.assertEquals(original.getName(), saved.getName());

        System.out.println("saved = " + saved);
    }


    @Test
    void testGetByIdPlanetWorkOk(){
        Planet planet1 = new Planet();
        planet1.setId("TN1");
        planet1.setName("TestName");

        String createdId = service.create(planet1);

        Planet retrievedPlanet = service.getById(createdId);

        assertNotNull(retrievedPlanet);
        assertEquals(planet1.getName(), retrievedPlanet.getName());

    }
//    @Test
//     void testUpdatePlanetWorks() {
//        Planet newPlanet = new Planet();
//        newPlanet.setId("TN1");
//        newPlanet.setName("TestName");
//
//        String planetId = service.create(newPlanet);
//
//        Planet retrievedPlanet = service.getById(planetId);
//        retrievedPlanet.setName("Updated Mars");
//        service.update(retrievedPlanet);
//
//        Planet updatedPlanet = service.getById(planetId);
//
//        assertEquals("Updated Mars", updatedPlanet.getName());
//
//        service.deleteById(Long.parseLong(planetId));
//    }
//    @Test
//     void testListAllPlanetsWorks() {
//        List<Planet> planets = service.listAll();
//
//        assertNotNull(planets);
//        assertEquals(7, planets.size());
//    }

//    @Test
//     void testDeletePlanetWorks() {
//        Planet newPlanet = new Planet();
//        newPlanet.setId("TN1");
//        newPlanet.setName("TestName");
//
//        String planetId = service.create(newPlanet);
//
//        service.deleteById((planetId));
//
//        Planet deletedPlanet = service.getById(planetId);
//
//        assertNull(deletedPlanet);
//    }
}
