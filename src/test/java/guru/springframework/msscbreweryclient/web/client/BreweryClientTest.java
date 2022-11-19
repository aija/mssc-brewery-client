package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void testGetBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }
    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder()
                            .beerName("New Beer").build();
        URI uri = client.newBeer(beerDto);
        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testUpdateBeerById(){
        //given
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();

        client.updateBeer(beerDto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testNewCustomer () {
        //given
        CustomerDto dto = CustomerDto.builder().name("New Name").build();
        URI uri = client.newCustomer(dto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer () {
        //given
        CustomerDto dto = CustomerDto.builder().id(UUID.randomUUID()).name("New Customer").build();
        client.updateCustomerById(dto);
    }

    @Test
    void testDeleteCustomer () {
        client.deleteCustomer(UUID.randomUUID());
    }
}