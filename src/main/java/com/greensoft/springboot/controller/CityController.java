package com.greensoft.springboot.controller;

import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.State;
import com.greensoft.springboot.service.CityService;
import com.greensoft.springboot.service.StateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService service;

    @Autowired
    private StateService stateService;



    private Log log =  LogFactory.getLog(CityController.class);

    @GetMapping("/msg")
    public ResponseEntity<String> getMsg(){
        return  new ResponseEntity<>("Welcome",HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDto> saveState(@RequestBody CityDto city) {
        log.info("Here is My Log ************************************************");
        CityDto cityDto = service.saveCity(city);
        return new ResponseEntity<>(cityDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{cityId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDto> updateState(@RequestBody CityDto cityDto ,@PathVariable Integer cityId) {
        System.out.println("********************************************");
        CityDto cityDtos = service.updateCity(cityDto , cityId);
        return new ResponseEntity<>(cityDtos, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/city-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDto>> getAllState() {
        List<CityDto> areaDtos = service.getAllCities();
        return new ResponseEntity<>(areaDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{cityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDto> getStateById(@PathVariable Integer cityId) {
        CityDto cityDto = service.getCity(cityId);
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{cityId}")
    public ResponseEntity<String> deleteState(@PathVariable Integer cityId) {
        String message = service.deleteCity(cityId);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/find/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCityByName(@PathVariable String cityName) {
        City city = service.findByCityName(cityName);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping(value = "/find-states/{stateName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<State> getStateByName(@PathVariable String stateName) {
        State state = stateService.findByStateName(stateName);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }
}