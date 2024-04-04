package me.bouzri.multipledatasource.web;

import me.bouzri.multipledatasource.topics.FirstUser;
import me.bouzri.multipledatasource.topics.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreatController {
    @Autowired private TopicRepository topicRepository;

    @GetMapping("/create")
    public void create(){
        FirstUser firstUser = new FirstUser();
        firstUser.setName("Mohamed");
        topicRepository.save(firstUser);
    }
}
