package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.dto.LocationDto;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.Location;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.CityRepo;
import com.greensoft.springboot.repository.LocationRepo;
import com.greensoft.springboot.service.CityService;
import com.greensoft.springboot.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepo repo;



    @Autowired
    private ModelMapper mapper;

    @Override
    public LocationDto saveLocation(LocationDto locationDto) {
       return  mapper.map(repo.save(this.mapper.map(locationDto, Location.class)), LocationDto.class);
    }

    @Override
    public LocationDto updateLocation(LocationDto locationDto, Integer locId) {
        Location existingLoc = repo.findById(locId).get();
        if(repo.findById(locId).isPresent() && existingLoc != null) {
            existingLoc.setLocName(locationDto.getLocName());
            existingLoc.setLocCode(locationDto.getLocCode());
            existingLoc.setAddress(locationDto.getAddress());
            existingLoc.setPhoneNo(locationDto.getPhoneNo());
            existingLoc.setEmail(locationDto.getEmail());
            existingLoc.setArea(locationDto.getArea());
            return  mapper.map(repo.save(existingLoc), LocationDto.class);
        } else {
            throw new NotFoundException("Location Not Found with Loc Id = " + locId);
        }
    }


    @Override
    public List<LocationDto> getAllLocations() {
        if(repo.findAll().isEmpty())
            throw new NotFoundException("Location are Not Found");
        return repo.findAll().stream().map(loc -> mapper.map(loc, LocationDto.class)).collect(Collectors.toList());
    }

    @Override
    public LocationDto getLocation(Integer locId) {

        Location location = repo.findById(locId).orElseThrow(() -> new NotFoundException("Location Not Found with Loc Id = " + locId));
        return mapper.map(location, LocationDto.class);

    }

    @Override
    public String deleteLocation(Integer locId) {
        repo.findById(locId).get();
        if(repo.findById(locId).get() != null) {
            repo.deleteById(locId);
            return "Deleted Successfuly with Location Id :: " + locId;
        } else {
            throw new NotFoundException("Location Not Available with locId = " + locId);
        }
    }

    @Override
    public Location findByLocName(String locName){
        return repo.findByLocName(locName);
    }
}
