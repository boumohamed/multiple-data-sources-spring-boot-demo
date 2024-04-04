package me.bouzri.multipledatasource.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<SecondUser, String> {
}
