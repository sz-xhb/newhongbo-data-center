/** 
 * Project Name:dtu-server-cassandra 
 * File Name:HelloController.java 
 * Package Name:com.nhb.dtu.controller 
 * Date:Jul 31, 201711:33:44 AM 
 * Copyright (c) 2017, lorisun@live.com All Rights Reserved. 
 * 
*/  
  
package com.nhb.data.hisdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @ClassName:HelloController
 * @Function: TODO ADD FUNCTION.
 * @Reason:   TODO ADD REASON.
 * @Date:     Jul 31, 2017 11:33:44 AM
 * @author   sunlei 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
@Controller
public class HelloController
{
	@RequestMapping("/hello")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "https://www.baidu.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
