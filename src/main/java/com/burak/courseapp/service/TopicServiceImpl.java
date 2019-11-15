package com.burak.courseapp.service;

import com.burak.courseapp.dto.TopicRequest;
import com.burak.courseapp.model.Topic;
import com.burak.courseapp.repository.TopicRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository){
        this.topicRepository=topicRepository;
    }

    @Override
    public List<Topic> getAllTopics() {
        List<Topic> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    @Override
    public Topic getTopic(Long id) {
        return topicRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Topic not found with "+id));
    }

    @Override
    @Transactional
    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    @Transactional
    public Topic updateTopic(Topic topic, TopicRequest topicRequest) {
        topic.setName(topicRequest.getName());
        topic.setDescription(topicRequest.getDescription());
        return topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
