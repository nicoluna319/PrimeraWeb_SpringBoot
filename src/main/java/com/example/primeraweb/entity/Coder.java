package com.example.primeraweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/*Entity indica qu esta clase sera una entidad y podra ser mapeada*/

@Entity
/*Table nos permite darle configuraciones a la tabla */
@Table(name = "coder")
public class Coder {

    @Id
    /*GeneratedValue permite que el id sera autoincrementable  */
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String name;
    private int age;
    private String clan;

    public Coder() {
    }

    public Coder(Long id, String name, int age, String clan) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clan = clan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "Coder [id=" + id + ", name=" + name + ", age=" + age + ", clan=" + clan + "]";
    }


    

    

    

}
