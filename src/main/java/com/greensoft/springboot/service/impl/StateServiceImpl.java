package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.dto.StateDto;
import com.greensoft.springboot.entity.Country;
import com.greensoft.springboot.entity.State;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.StateRepo;
import com.greensoft.springboot.service.StateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepo repo;



    @Autowired
    private ModelMapper mapper;

    @Override
    public StateDto saveState(StateDto stateDto) {
       return  mapper.map(repo.save(this.mapper.map(stateDto, State.class)), StateDto.class);
    }

    @Override
    public StateDto updateState(StateDto state, Integer stateId) {
        State existingState = repo.findById(stateId).get();
        if(repo.findById(stateId).isPresent() && existingState != null) {
            existingState.setStateName(state.getStateName());
            existingState.setDiscription(state.getDiscription());
            existingState.setStatus(state.getStatus());
            existingState.setCountry(state.getCountry());
            return  mapper.map(repo.save(existingState), StateDto.class);
        } else {
            throw new NotFoundException("State Not Found with State Id = " + stateId);
        }
    }


    @Override
    public List<StateDto> getAllStates() {
        if(repo.findAll().isEmpty())
            throw new NotFoundException("State are Not Found");
        return repo.findAll().stream().map(state -> mapper.map(state, StateDto.class)).collect(Collectors.toList());
    }

    @Override
    public StateDto getState(Integer stateId) {

        State state = repo.findById(stateId).orElseThrow(() -> new NotFoundException("State Not Found with State Id = " + stateId));
        return mapper.map(state, StateDto.class);

//        repo.findById(countryId).get();
//        if(repo.findById(countryId).get() != null)
//            return mapper.map(repo.findById(countryId).get(), CountryDto.class);
//        else
//            throw new NotFoundException("Country Not Found with countryId = "+countryId);
//    }
    }

    @Override
    public String deleteState(Integer stateId) {
        repo.findById(stateId).get();
        if(repo.findById(stateId).get() != null) {
            repo.deleteById(stateId);
            return "Deleted Successfuly with State Id :: " + stateId;
        } else {
            throw new NotFoundException("State Not Available with countryId = " + stateId);
        }
    }

    @Override
    public State findByStateName(String stateName){
        return repo.findByStateName(stateName).get();
    }
}
