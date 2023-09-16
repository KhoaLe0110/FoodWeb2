/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnk.controller;

import com.lnk.pojo.Foods;
import com.lnk.service.FoodsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jackie's PC
 */
@RestController
@RequestMapping("/api")
public class ApiCartController {

    @Autowired
    private FoodsService foodsService;

    @GetMapping("/api/foods")
    
    public ResponseEntity<List<Foods>> listFoods(@RequestParam Map<String,String> params) {
        List<Foods> foods = this.foodsService.getFoods(params);
            
        return new ResponseEntity<>(foods, HttpStatus.OK);

    }
}
