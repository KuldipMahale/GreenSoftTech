package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.dto.StateDto;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.State;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.CityRepo;
import com.greensoft.springboot.repository.StateRepo;
import com.greensoft.springboot.service.CityService;
import com.greensoft.springboot.service.StateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo repo;



    @Autowired
    private ModelMapper mapper;

    @Override
    public CityDto saveCity(CityDto cityDto) {
       return  mapper.map(repo.save(this.mapper.map(cityDto, City.class)), CityDto.class);
    }

    @Override
    public CityDto updateCity(CityDto city, Integer cityId) {
        City existingCity = repo.findById(cityId).get();
        if(repo.findById(cityId).isPresent() && existingCity != null) {
            existingCity.setCityName(city.getCityName());
            existingCity.setDescription(city.getDescription());
            existingCity.setStatus(city.getStatus());
            return  mapper.map(repo.save(existingCity), CityDto.class);
        } else {
            throw new NotFoundException("City Not Found with State Id = " + cityId);
        }
    }


    @Override
    public List<CityDto> getAllCities() {
        if(repo.findAll().isEmpty())
            throw new NotFoundException("City are Not Found");
        return repo.findAll().stream().map(city -> mapper.map(city, CityDto.class)).collect(Collectors.toList());
    }

    @Override
    public CityDto getCity(Integer cityId) {

        City city = repo.findById(cityId).orElseThrow(() -> new NotFoundException("City Not Found with State Id = " + cityId));
        return mapper.map(city, CityDto.class);

    }

    @Override
    public String deleteCity(Integer cityId) {
        repo.findById(cityId).get();
        if(repo.findById(cityId).get() != null) {
            repo.deleteById(cityId);
            return "Deleted Successfuly with City Id :: " + cityId;
        } else {
            throw new NotFoundException("City Not Available with countryId = " + cityId);
        }
    }

    @Override
    public City findByCityName(String cityName){
        return repo.findByCityName(cityName);
    }
}
