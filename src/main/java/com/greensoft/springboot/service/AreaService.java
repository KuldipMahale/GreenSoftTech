package com.greensoft.springboot.service;

import com.greensoft.springboot.dto.AreaDto;
import com.greensoft.springboot.dto.CityDto;
import com.greensoft.springboot.entity.Area;
import com.greensoft.springboot.entity.City;

import java.util.List;

public interface AreaService {

    public AreaDto saveArea(AreaDto areaDto);

    public AreaDto updateArea(AreaDto areaDto,Integer areaId);

    public List<AreaDto> getAllArea();

    public AreaDto getArea(Integer areaId);

    public String deleteArea(Integer areaId);

    Area findByAreaName(String userName);
}
