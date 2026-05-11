package com.example.feedbackservice.controller;

import com.example.feedbackservice.model.Feedback;
import com.example.feedbackservice.repository.FeedbackRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback create(@Valid @RequestBody Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @GetMapping
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }
}