package com.example.staffsystem_C1220642;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/staffs")
public class StaffController {
    private final StaffService service;
    public StaffController(StaffService service){
        this.service = service;
    }

//    get all staffs
    @GetMapping
    public Collection<Staff> getAllStaff(){
        return service.getAll();
    }

//    get staffs by id
    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable long id){
        return service.getById(id);
    }

    @PostMapping()
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff newStaff){
        Staff savedStaff = service.insertStaff(newStaff);
        HttpHeaders postHeader = new HttpHeaders();
        postHeader.add("Posting","postin with response entity");
        return ResponseEntity.status(HttpStatus.OK).headers(postHeader).body(savedStaff);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id,@RequestBody Staff newStaff){
        service.update(id,newStaff);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }

}
