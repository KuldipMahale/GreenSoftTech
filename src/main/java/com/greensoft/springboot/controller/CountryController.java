package com.greensoft.springboot.controller;

import com.greensoft.springboot.dto.CountryDto;
import com.greensoft.springboot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/msg")
    public ResponseEntity<String> getMsg(){
        return  new ResponseEntity<>("Welcome",HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDto> saveUser(@Valid @RequestBody CountryDto country) {
        CountryDto countryDto = service.saveCountry(country);
        return new ResponseEntity<>(countryDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{countryId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDto> updateCountry( @Valid @RequestBody CountryDto countryDto ,@PathVariable Long countryId) {
        CountryDto countryDtos = service.updateCountry(countryDto , countryId);
        return new ResponseEntity<>(countryDtos, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/user-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryDto>> getAllCustomers() {
        List<CountryDto> countryDtos = service.getAllCountrys();
        return new ResponseEntity<>(countryDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDto> getUserById(@PathVariable Long countryId) {
        CountryDto countryDto = service.getCountry(countryId);
        return new ResponseEntity<>(countryDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{countryId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long countryId) {
        String message = service.deleteCountry(countryId);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }
}
