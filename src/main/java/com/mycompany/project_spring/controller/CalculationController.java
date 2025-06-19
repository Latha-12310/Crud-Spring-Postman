package com.mycompany.project_spring.controller;

import com.mycompany.project_spring.modal.CalculateMul;
import com.mycompany.project_spring.modal.Details;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculationController {

    @GetMapping("/hello")
    public String sayHello(){
        return  "Hello";
    }

    @GetMapping("/add")
    public  Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2){
        return  num1+num2;
    }
    @GetMapping("/sub/{num1}/{num2}")
    public  Double substract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        Double result=null;
        if(num1>num2){
            result=num1-num2;
        }
        else{
            result=num2-num1;
        }
        return  result;
    }

        @PostMapping("/multiply")
        public  Double multiply(@RequestBody CalculateMul calculateMul){
           Double result=null;
           result=calculateMul.getNum1()*calculateMul.getNum2()* calculateMul.getNum3();
           return  result;
        }

}
