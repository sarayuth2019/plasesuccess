package com.powergroup.controller;

import com.powergroup.model.bean.APIResponse;
import com.powergroup.model.service.OrderRepository;
import com.powergroup.model.table.Order;
import com.powergroup.model.table.UserEntity;
import com.powergroup.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ContextUtil contextUtil;

    @PostMapping("/save")
    public Object save(Order order) {
        APIResponse res = new APIResponse();
        orderRepository.save(order);
        res.setMessage("save success...");
        res.setStatus(1);
        res.setData(order);
        return res;
    }

    @PostMapping("/update")
    public Object update(Order order) {
        APIResponse response = new APIResponse();
        orderRepository.save(order);
        response.setStatus(1);
        response.setMessage("update success...");
        response.setData(order);
        return response;
    }

    @GetMapping("/list")
    public Object list() {
        APIResponse res = new APIResponse();
        List<Order> getOrder = orderRepository.findAll();
        res.setData(getOrder);
        res.setStatus(1);
        res.setMessage("List Order....");
        return res;
    }

    @GetMapping("/delete/{id}")
    public Object delete(Order order, @PathVariable int id) {
        APIResponse res = new APIResponse();
        orderRepository.delete(order);
        res.setData(order);
        res.setStatus(1);
        res.setMessage("delete success...");
        return res;
    }

    @PostMapping("/find/name")
    public Object find(String name) {
        APIResponse res = new APIResponse();
        List<Order> getList = this.orderRepository.findByNameOrder(name);
        res.setData(getList);
        res.setMessage("Find By name Order...");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/find/user")
    public Object findUserId(@PathVariable int user) {
        APIResponse res = new APIResponse();
        Optional<UserEntity> dataUser = contextUtil.getUserDataFromContext();
        List<Order> getIdUser = orderRepository.findByUserId(dataUser.get().getUserId());
        res.setData(getIdUser);
        res.setMessage("List Order By user_id success....");
        res.setStatus(1);
        return res;
    }

    @PostMapping("/find/market")
    public Object findMarketId(int market) {
        APIResponse res = new APIResponse();
       // Optional<Customer> dataCustomer = contextUtil.getCustomerDataFromContext();
        List<Order> getCustomer = orderRepository.findByMarketId(market);
        res.setData(getCustomer);
        res.setStatus(1);
        res.setMessage("List marketId....");
        return res;
    }

    @PostMapping("/find/user/{user}")
    public Object findstatus(Order order, @PathVariable int user) {
        APIResponse res = new APIResponse();
        List<Order> checkstatus = orderRepository.findByStatusAndUserId(order.getStatus(), order.getUserId());
        res.setMessage("find success...");
        res.setStatus(1);
        res.setData(checkstatus);
        return res;
    }
}
