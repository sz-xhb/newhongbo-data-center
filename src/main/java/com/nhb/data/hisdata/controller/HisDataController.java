package com.nhb.data.hisdata.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nhb.data.hisdata.repository.Customer;
import com.nhb.data.hisdata.repository.MessageWrapper;
import com.nhb.data.hisdata.service.CustomerService;
import com.nhb.data.hisdata.service.HisDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "数据管理")
public class HisDataController {

    private static final Logger logger = LoggerFactory.getLogger(HisDataController.class);

    /**
     * RestTemplate方式服务间调用
     */
    @Autowired
    private HisDataService hisDataService;

    /**
     * FeignClient方式服务间调用
     */
    @Autowired
    private CustomerService customerService;

    @ApiOperation(value="restTemplate获取用户列表", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/customer-client-rest/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageWrapper<Customer> getCustomer(@PathVariable int id) {
        logger.debug("Reading customer using restTemplate client with ID " + id);
        return hisDataService.getCutomer(id);
    }

    @ApiOperation(value="feign方式获取用户列表", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/customer-client-feign/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerByFeign(@PathVariable int id) {
        logger.debug("Reading customer using feign client with ID " + id);
        return customerService.getUserById(id);
    }

    @ApiOperation(value="feign方式获取用户列表", notes="根据url的id来获取用户详细信息")
    @PostMapping(value = "/customer-client", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerByPostFeign(@RequestBody Map<String, String> requestParam) {
    	String id = requestParam.get("id");
        logger.debug("Reading customer using feign client with ID " + id);
        return customerService.getUserByPost(requestParam);
    }
}
