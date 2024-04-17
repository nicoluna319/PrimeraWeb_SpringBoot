package com.example.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.primeraweb.entity.Coder;
import com.example.primeraweb.repository.CoderRepository;

/*Indica que esta clase sera un servicio */
@Service
public class CoderService {
    /*AutoWired le indica a Spring Boot que esta es una inyeccion de dependencias */
    @Autowired
    private CoderRepository objCoderRepository;

    /*Servicio para listar todos los coders */

    public List<Coder> findAll(){
        return this.objCoderRepository.findAll();
    }


}
