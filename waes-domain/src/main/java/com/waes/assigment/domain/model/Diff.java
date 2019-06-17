package com.waes.assigment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "diff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diff {

    @Id
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "left")
    private String left;

    @Lob
    @Column(name = "right")
    private String right;

    @Transient
    private String side;

    public Diff(Long id) {
        this.id = id;
    }



}