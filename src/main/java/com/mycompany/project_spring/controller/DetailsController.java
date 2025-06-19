package com.mycompany.project_spring.controller;

import com.mycompany.project_spring.modal.Details;
import com.mycompany.project_spring.repository.DetailRepository;
import com.mycompany.project_spring.service.detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/latha/details")
public class DetailsController {

    @Autowired
    private detailsService detailsService;

    @PostMapping("/save")
    public  ResponseEntity<Details> saveDetails(@RequestBody Details details){
     details=detailsService.saveDetails(details);

        ResponseEntity<Details> responseEntity=new ResponseEntity<>(details, HttpStatus.CREATED);
        return  responseEntity;
    }

    @GetMapping("/get")
    public ResponseEntity< List<Details>> getAllDetails(){
        List<Details> detailsList= detailsService.getAllDetails();
        ResponseEntity< List<Details>> responseEntity=new ResponseEntity<>(detailsList,HttpStatus.OK);
        return responseEntity;
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<Details> updateDetails(@RequestBody Details details, @PathVariable Long id){
        System.out.println(id);
        details = detailsService.updateDetails(details, id);
        return new ResponseEntity<>(details, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteDetail(@PathVariable Long id){
        detailsService.deleteDetail(id);
        ResponseEntity<Void> responseEntity=new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return responseEntity;
    }


    @PatchMapping("/update-price/{id}")
    public ResponseEntity<Details> updateDetailPrice(@RequestBody Details details, @PathVariable Long id) {
        System.out.println("ID: " + id);
        details = detailsService.updateDetailPrice(details, id);
        System.out.println(">> Controller - ID: " + id);
        System.out.println(">> Controller - Price from body: " + details.getPrice());

        return new ResponseEntity<>(details, HttpStatus.OK);
    }


}
