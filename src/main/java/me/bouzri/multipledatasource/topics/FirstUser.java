package me.bouzri.multipledatasource.topics;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
public class FirstUser {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
}
