package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.CountryDto;
import com.greensoft.springboot.entity.Country;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.CountryRepo;
import com.greensoft.springboot.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Country existingCountry = repo.findById(countryId).get();
        if(repo.findById(countryId).isPresent() && existingCountry != null) {
            existingCountry.setCountryName(country.getCountryName());
            existingCountry.setDiscription(country.getDiscription());
            existingCountry.setStatus(country.getStatus());
            return  mapper.map(repo.save(existingCountry), CountryDto.class);
        } else {
            throw new NotFoundException("Country Not Found with countryId = " + countryId);
        }
    }




    @Override
    public List<CountryDto> getAllCountrys() {
        if(repo.findAll().isEmpty())
            throw new NotFoundException("User are Not Found");
        return repo.findAll().stream().map(country -> mapper.map(country, CountryDto.class)).collect(Collectors.toList());
    }

    @Override
    public CountryDto getCountry(Long countryId) {

        Country country = repo.findById(countryId).orElseThrow(() -> new NotFoundException("Country Not Found with countryId = " + countryId));
        return mapper.map(country, CountryDto.class);

//        repo.findById(countryId).get();
//        if(repo.findById(countryId).get() != null)
//            return mapper.map(repo.findById(countryId).get(), CountryDto.class);
//        else
//            throw new NotFoundException("Country Not Found with countryId = "+countryId);
//    }
    }

    @Override
    public String deleteCountry(Long countryId) {
        repo.findById(countryId).get();
        if(repo.findById(countryId).get() != null) {
            repo.deleteById(countryId);
            return "Deleted Successfuly with countryId :: " + countryId;
        } else {
            throw new NotFoundException("Country Not Available with countryId = " + countryId);
        }
    }

    @Override
    public Country findByCountryName(String userName){
        return repo.findByCountryName(userName);
    }
}
