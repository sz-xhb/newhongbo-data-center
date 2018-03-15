package com.nhb.data.hisdata.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhb.data.hisdata.repository.Customer;

@FeignClient(value = "system-center")
public interface CustomerService {

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Customer getUserById(@PathVariable("id") int id);

    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    Customer getUserByPost(@RequestBody Map<String, String> ids);
}
