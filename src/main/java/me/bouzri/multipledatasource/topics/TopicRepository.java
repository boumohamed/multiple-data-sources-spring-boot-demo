package me.bouzri.multipledatasource.topics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<FirstUser, String> {
}
