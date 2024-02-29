package com.app.apirest.models;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="person")
public class PersonModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String firsName;

    @NonNull
    private String lastName;
    private String email;
    private Integer numeroTelefono;
    private String ciudad;
    private String pais;
}
