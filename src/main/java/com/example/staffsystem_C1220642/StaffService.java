package com.example.staffsystem_C1220642;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class StaffService {
    private final Map<Long, Staff> staffs = new ConcurrentHashMap<>();
    private AtomicLong autoId = new AtomicLong();



    //get all staff
    public Collection<Staff> getAll(){
        return staffs.values();
    }

    // get staff by id
    public Staff getById(Long id){
        return staffs.get(id);
    }

//    insert staff
    public Staff insertStaff(Staff newStaff){
        Long staffId = newStaff.getId()== null ?
                autoId.incrementAndGet():newStaff.getId();
        newStaff.setId(staffId);
        staffs.put(staffId,newStaff);

        return newStaff;
    }

    public Staff update(Long id, Staff newSatff){
        if (staffs.containsKey(id)) {
            Staff oldStaff = getById(id);
            oldStaff.setName(newSatff.getName());
            oldStaff.setPhone(newSatff.getPhone());
            return newSatff;
        }
        else{
            return null;
        }
    }

    public String delete(long id){
        if (staffs.containsKey(id)){
            staffs.remove(id);
            return "Deleted successfully";

        }
        else{
            return "This ID is not exits";
        }
    }






}
