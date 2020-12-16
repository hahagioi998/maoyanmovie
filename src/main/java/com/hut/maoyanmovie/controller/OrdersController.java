package com.hut.maoyanmovie.controller;

import com.hut.maoyanmovie.bean.Movie;
import com.hut.maoyanmovie.bean.Orders;
import com.hut.maoyanmovie.bean.User;
import com.hut.maoyanmovie.service.MovieService;
import com.hut.maoyanmovie.service.OrdersService;
import com.hut.maoyanmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Cleanmoo
 * @data 2020/12/9
 */

@Controller
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    UserService userService;
    @Autowired
    MovieService movieService;

    @GetMapping("interorders")
    public String interorders(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = userService.selectAll();
        List<Movie> movies = movieService.getAll();
        List<Orders> orders = ordersService.getAll();
        modelMap.put("users",users);
        modelMap.put("movies",movies);
        modelMap.put("orders",orders);
        return "interorders";
    }

    @GetMapping("delOrdersByOid")
    public String delOrdersByOid(Integer oid){
        ordersService.delOrdersByOid(oid);
        return "redirect:/admin_order_list";
    }


    @GetMapping("getOrdersByOid")
    public String getOrdersByOid(ModelMap modelMap,Integer oid){
        Orders orders = ordersService.getOrdersByOid(oid);
        modelMap.put("orders",orders);
        return "/admin/updateOrders";

    }

    @PostMapping("editOrdersByOid")
    public String editOrdersByOid(Orders orders){
        ordersService.editOrdersByOid(orders);
        return "redirect:/admin_order_list";
    }

}