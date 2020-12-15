package com.hut.maoyanmovie.controller;

import com.hut.maoyanmovie.bean.Orders;
import com.hut.maoyanmovie.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Cleanmoo
 * @data 2020/12/9
 */

@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("interorders")
    public String interorders(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
        List<User> users = userService.selectAll();
        List<Movie> movies = movieService.getAll();

        modelMap.put("movies",movies);
         */
           // HttpSession session = request.getSession();
           // String uids = session.getAttribute("uid").toString();
           // Integer uid = Integer.parseInt(uids);
           // List<Orders> orders = ordersService.selectByuid(uid);
          // modelMap.put("orders",orders);
        return "interorders";
    }

}