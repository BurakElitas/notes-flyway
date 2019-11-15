package com.burak.courseapp.repository;

import com.burak.courseapp.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,Long> {
}
