package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_URI_V1 = "/api/v1/customer/";

    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public BeerDto getBeerById(UUID beerId){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId, BeerDto.class);
    }

    public URI newBeer (BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer (BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + beerDto.getId(), beerDto);
    }

    public void deleteBeer (UUID beerId) {
        restTemplate.delete(apihost + BEER_PATH_V1 + beerId);
    }

    public CustomerDto getCustomerById (UUID customerId) {
        return restTemplate.getForObject(apihost + CUSTOMER_URI_V1 + customerId, CustomerDto.class);
    }

    public URI newCustomer (CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_URI_V1, customerDto);
    }

    public void updateCustomerById (CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_URI_V1 + customerDto.getId(), customerDto);
    }

    public void deleteCustomer (UUID customerId) {
        restTemplate.delete(apihost + CUSTOMER_URI_V1 + customerId);
    }

}
