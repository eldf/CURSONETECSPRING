package com.bancolombia.backend.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/calculadora")
public class CalculadoraController {



    @GetMapping
    public String saludo(){

        return "Welcome Bancolombia ";
    }

    @GetMapping("/sumar-valor")
    public int suma (@RequestParam("val1") int val1,
                     @RequestParam("val2") int val2
    ){
        return val1+val2;
    }


    @GetMapping("/{name}")
    public String saludo(@PathVariable String name){

        return "Welcome Bancolombia "+name;
    }





    @GetMapping("/name")
    public String saludo2(@RequestParam String name){

        return "Welcome Bancolombia "+name;
    }


/*
    @GetMapping("/dividir-valor")
    public ResponseEntity double dividir (@RequestParam("val1") int val1,
                 @RequestParam("val2") int val2
    )  {

        if(val2!=0){
           double resulto= val1/val2;
           ResponseEntity.status(HttpStatusCode.<> )
        }



    }
*/


}
