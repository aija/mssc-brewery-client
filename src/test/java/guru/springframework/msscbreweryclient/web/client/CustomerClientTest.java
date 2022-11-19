package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

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
        CustomerDto dto = CustomerDto.builder().name("New Customer").build();
        client.updateCustomerById(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteCustomer () {
        client.deleteCustomer(UUID.randomUUID());
    }

}