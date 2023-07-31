package com.greensoft.springboot.service;

import com.greensoft.springboot.dto.CountryDto;

import java.util.List;

public interface CountryService {

    public CountryDto saveCountry(CountryDto country);

    public CountryDto updateCountry(CountryDto country,Long countryId);

    public List<CountryDto> getAllCountrys();

    public CountryDto getCountry(Long countryId);

    public String deleteCountry(Long countryId);
}
