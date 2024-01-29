package com.greensoft.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Green {

    @Id
    private Integer id;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "Green{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
