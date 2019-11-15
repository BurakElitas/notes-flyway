package com.burak.courseapp.service;

import com.burak.courseapp.dto.TopicRequest;
import com.burak.courseapp.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopics();
    Topic getTopic(Long id);
    Topic addTopic(Topic topic);
    Topic updateTopic(Topic topic, TopicRequest topicRequest);
    void deleteTopic(Long id);
}
