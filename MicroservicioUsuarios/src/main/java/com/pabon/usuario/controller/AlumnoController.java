package com.pabon.usuario.controller;


import com.pabon.usuario.entity.Alumno;
import com.pabon.usuario.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class AlumnoController {

    @Autowired
    AlumnoService service;
    
    @Value("${config.balanceador.test}")
    private String balanceadorTest;
    
    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest(){
    	Map<String, Object> response= new HashMap<String, Object>();
    	response.put("balanceador", balanceadorTest);
    	response.put("alumno", service.findAll());
    	
    	return ResponseEntity.ok().body(response);
    			
    			
        
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<?> listarAlumno(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id ){
        Optional<Alumno> ob = service.findById(id);

        if( ob.isEmpty() ){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }


    @PostMapping("/crearAlumno")
    public ResponseEntity<?> crear(@RequestBody Alumno alumno ){
        Alumno alumnoDB = service.save(alumno);

        return ResponseEntity.status(HttpStatus.CREATED ).body( alumnoDB );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> ob = service.findById( id );

        if( ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Alumno alumnoBd = ob.get();
        alumnoBd.setNombre( alumno.getNombre() );
        alumnoBd.setApellido( alumno.getApellido() );
        alumnoBd.setEmail( alumno.getEmail() );

        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(alumnoBd) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar( @PathVariable Long id ){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}