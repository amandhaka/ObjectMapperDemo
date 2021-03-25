package com.example.jsondemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class IdObject {
    @Id
    private Long id;
    private String $oid;
}
