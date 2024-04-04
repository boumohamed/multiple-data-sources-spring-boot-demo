package me.bouzri.multipledatasource.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
public class SecondUser {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
}
