package com.greensoft.springboot.service.impl;

import com.greensoft.springboot.entity.DummyUsers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DummyUserServices {
    private List<DummyUsers> store = new ArrayList<>();

    public DummyUserServices(){
        store.add(new DummyUsers(UUID.randomUUID().toString(),"Kuldip","kuldip123@gmail.com"));
        store.add(new DummyUsers(UUID.randomUUID().toString(),"Sandip","sandil111@gmail.com"));
        store.add(new DummyUsers(UUID.randomUUID().toString(),"Pradip","pradip123@gmail.com"));
    }

    public List<DummyUsers> getUsers() {
        return this.store;
    }
}
