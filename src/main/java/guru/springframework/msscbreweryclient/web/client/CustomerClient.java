package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.customer", ignoreUnknownFields = false)
public class CustomerClient {
    public final String CUSTOMER_URI_V1 = "/api/v1/customer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById (UUID uuid) {
        return restTemplate.getForObject(apihost + CUSTOMER_URI_V1 + "/" + uuid, CustomerDto.class);
    }

    public URI newCustomer (CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_URI_V1, customerDto);
    }

    public void updateCustomerById (UUID uuid, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_URI_V1 + "/" + uuid, customerDto);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public void deleteCustomer (UUID uuid) {
        restTemplate.delete(apihost + CUSTOMER_URI_V1 + "/" + uuid);
    }
}