package com.greensoft.springboot.service;

import com.greensoft.springboot.dto.CountryDto;
import com.greensoft.springboot.dto.StateDto;
import com.greensoft.springboot.entity.Country;
import com.greensoft.springboot.entity.State;

import java.util.List;

public interface StateService {

    public StateDto saveState(StateDto stateDto);

    public StateDto updateState(StateDto dto,Integer countryId);

    public List<StateDto> getAllStates();

    public StateDto getState(Integer stateId);

    public String deleteState(Integer stateId);

    public State findByStateName(String stateName);

}
