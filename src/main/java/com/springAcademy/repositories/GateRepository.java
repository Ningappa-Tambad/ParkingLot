package com.springAcademy.repositories;

import com.springAcademy.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gateMap;
    private Long id;

    public GateRepository() {
        gateMap=new HashMap<>();
        id=0l;
    }

    public Gate save(Gate gate){

        //update+insert
        if(gate.getId()==0)
        {
            //Insert
            gate.setId(++id);
            gateMap.put(id,gate);
        }
        gateMap.put(gate.getId(),gate);
        return gate;
    }


    public Optional<Gate> findById(Long gateId)
    {
        if(gateMap.containsKey(gateId))
        {
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }

}
