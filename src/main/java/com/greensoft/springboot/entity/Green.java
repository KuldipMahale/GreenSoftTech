package com.greensoft.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


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
