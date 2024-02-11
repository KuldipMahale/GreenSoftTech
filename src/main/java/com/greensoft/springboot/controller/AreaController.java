package com.greensoft.springboot.controller;

import com.greensoft.springboot.dto.AreaDto;
import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.entity.Area;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.State;
import com.greensoft.springboot.service.AreaService;
import com.greensoft.springboot.service.CityService;
import com.greensoft.springboot.service.StateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService service;

    @Autowired
    private CityService cityService;

    @Autowired
    private StateService stateService;



    private Log log =  LogFactory.getLog(AreaController.class);

    @GetMapping("/msg")
    public ResponseEntity<String> getMsg(){
        return  new ResponseEntity<>("Welcome",HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaDto> saveState(@Valid @RequestBody AreaDto area) {
        log.info("Here is My Log ************************************************");
        AreaDto areaDto = service.saveArea(area);
        return new ResponseEntity<>(areaDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{areaId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaDto> updateArea( @Valid @RequestBody AreaDto areaDto ,@PathVariable Integer areaId) {
        System.out.println("********************************************");
        AreaDto areaDtos = service.updateArea(areaDto , areaId);
        return new ResponseEntity<>(areaDtos, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/area-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AreaDto>> getAllAreas() {
        List<AreaDto> areaDtos = service.getAllArea();
        return new ResponseEntity<>(areaDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{areaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AreaDto> getAreaById(@PathVariable Integer areaId) {
        AreaDto areaDto = service.getArea(areaId);
        return new ResponseEntity<>(areaDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{areaId}")
    public ResponseEntity<String> deleteState(@PathVariable Integer areaId) {
        String message = service.deleteArea(areaId);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/find/{areaName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Area> getAreaByName(@PathVariable String areaName) {
        Area area = service.findByAreaName(areaName);
        return new ResponseEntity<>(area, HttpStatus.OK);
    }

    @GetMapping(value = "/find-states/{stateName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<State> getStateByName(@PathVariable String stateName) {
        State state = stateService.findByStateName(stateName);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }

    @GetMapping(value = "/find-city/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCityByName(@PathVariable String cityName) {
        City city = cityService.findByCityName(cityName);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}