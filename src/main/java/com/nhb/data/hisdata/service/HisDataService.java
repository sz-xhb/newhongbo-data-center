package com.nhb.data.hisdata.service;

import com.nhb.data.hisdata.repository.Customer;
import com.nhb.data.hisdata.repository.MessageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HisDataService {

    @Autowired
    private RestTemplate restTemplate;

    public MessageWrapper<Customer> getCutomer(int id)
    {
        Customer customer = restTemplate.exchange("http://system-center/customer/{id}", HttpMethod.GET, null,
                new ParameterizedTypeReference<Customer>()
                {}, id).getBody();

        return new MessageWrapper<Customer>(customer, "server called using eureka with rest template");
    }
}
