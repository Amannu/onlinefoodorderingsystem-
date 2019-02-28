package com.g39.onlinefoodorderingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.g39.onlinefoodorderingsystem.domains.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

}
