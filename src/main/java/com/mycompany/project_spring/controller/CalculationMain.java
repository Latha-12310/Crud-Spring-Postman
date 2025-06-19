package com.mycompany.project_spring.controller;

public class CalculationMain {
    public  static  void  main(String[] args){
        CalculationController cc=new CalculationController();
        Double result=cc.add(10.3,20.7);
        System.out.println(result);

    }
}
