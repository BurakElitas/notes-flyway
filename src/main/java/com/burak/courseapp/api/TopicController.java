package com.burak.courseapp.api;

import com.burak.courseapp.dto.TopicRequest;
import com.burak.courseapp.dto.TopicResponse;
import com.burak.courseapp.model.Topic;
import com.burak.courseapp.service.TopicService;
import io.swagger.annotations.SwaggerDefinition;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController extends BaseController{
    private final TopicService topicService;

    public TopicController(ModelMapper modelMapper, TopicService topicService) {
        super(modelMapper);
        this.topicService = topicService;
    }

    @RequestMapping(value = "/topics",method = RequestMethod.GET)
    public List<TopicResponse> getAllTopics(){
        List<Topic> topics=topicService.getAllTopics();
        List<TopicResponse> topicResponses=mapAll(topics,TopicResponse.class);
        return topicResponses;
    }

    @RequestMapping(value = "/topics/{id}",method = RequestMethod.GET)
    public TopicResponse getTopic(@PathVariable("id") Long id){
        Topic topic=topicService.getTopic(id);
        TopicResponse topicResponse=map(topic,TopicResponse.class);
        return topicResponse;
    }

    @RequestMapping(value = "/topics",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTopic(@RequestBody TopicRequest topicRequest){
        Topic topic=map(topicRequest,Topic.class);
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTopic(@RequestBody TopicRequest topicRequest,@PathVariable("id") Long id){
        Topic topic=topicService.getTopic(id);
        topicService.updateTopic(topic,topicRequest);
    }

    @RequestMapping(value = "/topics/{id}",method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable("id") Long id){
        topicService.deleteTopic(id);
    }
}
