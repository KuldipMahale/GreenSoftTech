package com.greensoft.springboot.service;

import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.dto.CountryDto;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.entity.Country;

import java.util.List;

public interface CityService {

    public CityDto saveCity(CityDto cityDto);

    public CityDto updateCity(CityDto cityDto,Integer cityId);

    public List<CityDto> getAllCities();

    public CityDto getCity(Integer cityId);

    public String deleteCity(Integer countryId);

    City findByCityName(String userName);
}
