package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.AreaDto;
import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.entity.Area;
import com.greensoft.springboot.entity.City;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.AreaRepo;
import com.greensoft.springboot.repository.CityRepo;
import com.greensoft.springboot.service.AreaService;
import com.greensoft.springboot.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepo repo;



    @Autowired
    private ModelMapper mapper;

    @Override
    public AreaDto saveArea(AreaDto areaDto) {
       return  mapper.map(repo.save(this.mapper.map(areaDto, Area.class)), AreaDto.class);
    }

    @Override
    public AreaDto updateArea(AreaDto area, Integer areaId) {
        Area existingArea = repo.findById(areaId).get();
        if(repo.findById(areaId).isPresent() && existingArea != null) {
            existingArea.setAreaName(area.getAreaName());
            existingArea.setDescription(area.getDescription());
            existingArea.setCity(area.getCity());
          //  existingArea.setState(area.getState());
            return  mapper.map(repo.save(existingArea), AreaDto.class);
        } else {
            throw new NotFoundException("Area Not Found with State Id = " + areaId);
        }
    }


    @Override
    public List<AreaDto> getAllArea() {
        if(repo.findAll().isEmpty())
            throw new NotFoundException("Area are Not Found");
        return repo.findAll().stream().map(area -> mapper.map(area, AreaDto.class)).collect(Collectors.toList());
    }

    @Override
    public AreaDto getArea(Integer areaId) {

        Area area = repo.findById(areaId).orElseThrow(() -> new NotFoundException("Area Not Found with State Id = " + areaId));
        return mapper.map(area, AreaDto.class);

    }

    @Override
    public String deleteArea(Integer areaId) {
        repo.findById(areaId).get();
        if(repo.findById(areaId).get() != null) {
            repo.deleteById(areaId);
            return "Deleted Successfuly with Area Id :: " + areaId;
        } else {
            throw new NotFoundException("City Not Available with countryId = " + areaId);
        }
    }

    @Override
    public Area findByAreaName(String cityName){
        return repo.findByAreaName(cityName);
    }
}
