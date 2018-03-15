package com.nhb.data;

import com.nhb.data.hisdata.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = CustomerService.class)
@ComponentScan(basePackages = "com.nhb.data")
class DataCenterApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(DataCenterApplication.class, args);
	}
}
