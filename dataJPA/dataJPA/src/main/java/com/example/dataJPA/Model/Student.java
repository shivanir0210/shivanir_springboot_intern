package com.example.dataJPA.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    //@GeneratedValue (Strategy = Generatedtype  Identity) --> with this it automatically
    // assign id so that no same data occur in db
    //@min,@NotNull,@NotBlank,@NotEmpty,@size()


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="name can't be blank")
    private String name;
    private String tech;
    private String gender;
    private String email;
    private String password;

}
