package com.example.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Coder> fingPaginated(int page, int size){
        if(page< 0){
            page = 1;
        }

        /*Crear objeto de paginacion */

        Pageable objPageable= PageRequest.of(page, size);
        return this.objCoderRepository.findAll(objPageable);
    }
/*Servicio para guardar un coder */
    public Coder insert (Coder objCoder){
        return this.objCoderRepository.save(objCoder);
    }
/*Servicio para actualizar un coder */

public Coder update(Long id, Coder objCoder){
    /*Buscar al coder con ese id */


    Coder objCoderDB = this.findById(id);
    if(objCoder == null) return null;
    objCoderDB = objCoder;
    return this.objCoderRepository.save(objCoderDB);
}

public Coder findById(Long id){
    return this.objCoderRepository.findById(id).orElse(null);
}

public void delete(Long id, Coder objCoder){


    Coder objCoderDB = this.findById(id);

    this.objCoderRepository.delete(objCoderDB);
}



}
