package com.greensoft.springboot.service;

import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.dto.LocationDto;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    public LocationDto saveLocation(LocationDto locationDto);

    public LocationDto updateLocation(LocationDto locationDto,Integer locId);

    public List<LocationDto> getAllLocations();

    public LocationDto getLocation(Integer locId);

    public String deleteLocation(Integer locId);

    Location findByLocName(String userName);
}
