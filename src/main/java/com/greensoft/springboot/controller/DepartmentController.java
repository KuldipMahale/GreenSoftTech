package com.greensoft.springboot.controller;

import com.greensoft.springboot.dto.DepartmentDto;
import com.greensoft.springboot.entity.Department;
import com.greensoft.springboot.entity.Location;
import com.greensoft.springboot.service.DepartmentService;
import com.greensoft.springboot.service.LocationService;
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
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Autowired
    private LocationService locationService;



    private Log log =  LogFactory.getLog(DepartmentController.class);

    @GetMapping("/msg")
    public ResponseEntity<String> getMsg(){
        return  new ResponseEntity<>("Welcome",HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentDto> saveDept(@RequestBody DepartmentDto dept) {
        log.info("Here is My Log ************************************************");
        DepartmentDto dto = service.saveDepartment(dept);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{deptId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentDto> updateDept( @RequestBody DepartmentDto deptDto ,@PathVariable Integer deptId) {
        System.out.println("********************************************");
        DepartmentDto deptDtos = service.updateDepartment(deptDto , deptId);
        return new ResponseEntity<>(deptDtos, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/dept-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentDto>> getAllDept() {
        System.out.println("----------------------------------------------------------");
        List<DepartmentDto> deptDtos = service.getAllDepartment();
        System.out.println("----------------------------------------------------------");
        return new ResponseEntity<>(deptDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{deptId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentDto> getDeptById(@PathVariable Integer deptId) {
        DepartmentDto deptDto = service.getDepartment(deptId);
        return new ResponseEntity<>(deptDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{deptId}")
    public ResponseEntity<String> deleteState(@PathVariable Integer deptId) {
        String message = service.deleteDepartment(deptId);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/find/{deptcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> getCityByName(@PathVariable String deptcode) {
        Department dept = service.findByDeptCode(deptcode);
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }

    @GetMapping(value = "/find-loc/{locname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> getStateByName(@PathVariable String locname) {
        Location loc = locationService.findByLocName(locname);
        return new ResponseEntity<>(loc, HttpStatus.OK);
    }
}