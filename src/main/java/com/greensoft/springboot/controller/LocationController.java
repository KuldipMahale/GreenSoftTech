package com.greensoft.springboot.controller;

import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.dto.LocationDto;
import com.greensoft.springboot.entity.Area;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.Location;
import com.greensoft.springboot.entity.State;
import com.greensoft.springboot.service.AreaService;
import com.greensoft.springboot.service.CityService;
import com.greensoft.springboot.service.LocationService;
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
@RequestMapping("/loc")
public class LocationController {

    @Autowired
    private LocationService service;

    @Autowired
    private AreaService areaService;



    private Log log =  LogFactory.getLog(LocationController.class);

    @GetMapping("/msg")
    public ResponseEntity<String> getMsg(){
        return  new ResponseEntity<>("Welcome",HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationDto> saveLoc(@Valid @RequestBody LocationDto loc) {
        log.info("Here is My Log ************************************************");
        LocationDto locationDto = service.saveLocation(loc);
        return new ResponseEntity<>(locationDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{locId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationDto> updateLoc( @Valid @RequestBody LocationDto loc ,@PathVariable Integer locId) {
        System.out.println("********************************************");
        LocationDto locationDtos = service.updateLocation(loc , locId);
        return new ResponseEntity<>(locationDtos, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/loc-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocationDto>> getAllLoc() {
        List<LocationDto> locDtos = service.getAllLocations();
        return new ResponseEntity<>(locDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{locId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocationDto> getLocById(@PathVariable Integer locId) {
        LocationDto locDto = service.getLocation(locId);
        return new ResponseEntity<>(locDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{locId}")
    public ResponseEntity<String> deleteloc(@PathVariable Integer locId) {
        String message = service.deleteLocation(locId);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/find/{locName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getLocationByName(@PathVariable String locName) {
        Location loc = service.findByLocName(locName);
        return new ResponseEntity<>(loc, HttpStatus.OK);
    }

    @GetMapping(value = "/find-area/{areaName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Area> getStateByName(@PathVariable String areaName) {
        Area area = areaService.findByAreaName(areaName);
        return new ResponseEntity<>(area, HttpStatus.OK);
    }
}