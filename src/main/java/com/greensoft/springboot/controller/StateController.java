package com.greensoft.springboot.controller;

import com.greensoft.springboot.dto.StateDto;
import com.greensoft.springboot.entity.State;
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
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService service;



    private Log log =  LogFactory.getLog(StateController.class);

    @GetMapping("/msg")
    public ResponseEntity<String> getMsg(){
        return  new ResponseEntity<>("Welcome",HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StateDto> saveState( @RequestBody StateDto state) {
        log.info("Here is My Log ************************************************");
        StateDto stateDto = service.saveState(state);

        return new ResponseEntity<>(stateDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{stateId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StateDto> updateState(@RequestBody StateDto stateDto ,@PathVariable Integer stateId) {
        System.out.println("********************************************");
        StateDto stateDtos = service.updateState(stateDto , stateId);
        return new ResponseEntity<>(stateDtos, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/state-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StateDto>> getAllState() {
        List<StateDto> stateDtos = service.getAllStates();
        return new ResponseEntity<>(stateDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{stateId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StateDto> getStateById(@PathVariable Integer stateId) {
        StateDto stateDto = service.getState(stateId);
        return new ResponseEntity<>(stateDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{stateId}")
    public ResponseEntity<String> deleteState(@PathVariable Integer stateId) {
        String message = service.deleteState(stateId);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/find/{stateName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<State> getStateByName(@PathVariable String stateName) {
        State state = service.findByStateName(stateName);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }
}