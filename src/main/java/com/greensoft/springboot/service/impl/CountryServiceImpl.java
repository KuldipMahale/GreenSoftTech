package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.CountryDto;
import com.greensoft.springboot.entity.Country;
import com.greensoft.springboot.repository.CountryRepo;
import com.greensoft.springboot.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CountryDto saveCountry(CountryDto countryDto) {
       return  mapper.map(repo.save(this.mapper.map(countryDto, Country.class)), CountryDto.class);
    }

    @Override
    public CountryDto updateCountry(CountryDto country, Long countryId) {
        repo.findById(countryId);

        return null;
    }

    @Override
    public List<CountryDto> getAllCountrys() {
        return null;
    }

    @Override
    public CountryDto getCountry(Long countryId) {
        return null;
    }

    @Override
    public String deleteCountry(Long countryId) {
        return null;
    }
}
