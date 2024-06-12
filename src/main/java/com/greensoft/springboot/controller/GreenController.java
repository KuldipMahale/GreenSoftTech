package com.greensoft.springboot.controller;

import com.greensoft.springboot.entity.Customers;
import com.greensoft.springboot.entity.Green;
import com.greensoft.springboot.repository.GreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/green")
public class GreenController {


    @Autowired
    GreenRepository repo;


    @GetMapping("/getAll")
    public ResponseEntity<List<Green>> getAll(){
        System.out.println("-------------------------------------");
        System.out.println(repo.findAll());
        System.out.println("-------------------------------------");
        return  new ResponseEntity<>(repo.findAll(), HttpStatus.OK) ;
    }


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Green> getGreenById(@PathVariable Integer id) {
        Optional<Green> green = repo.findById(id);
        System.out.println("-------------------------------------");
        System.out.println(green.get());
        System.out.println("-------------------------------------");
        return new ResponseEntity<Green>(green.get(),HttpStatus.OK);
    }

    @GetMapping(value = "/getgreen/{userId}")
    public ResponseEntity<Green> getOneGreen(@PathVariable Integer userId){
        Green g = repo.findById(userId).get();
        System.out.println("-------------------------------------");
        System.out.println(g);
        System.out.println("-------------------------------------");
        System.out.println(g.toString());
        System.out.println("-------------------------------------");
        return  new ResponseEntity<>(g,HttpStatus.OK);
    }




}
