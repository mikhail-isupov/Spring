package ru.geekbrains.feedback_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.feedback_server.model.FeedbackEntity;
import ru.geekbrains.feedback_server.service.iFeedbackService;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController implements iFeedbackController{
    @Autowired
    iFeedbackService feedbackService;

    @PostMapping("/{itemId}")
    public FeedbackEntity postFeedback(@PathVariable Integer itemId, @RequestBody String feedback){
        return feedbackService.postFeedback(itemId, feedback);
    }

    @GetMapping("/{itemId}")
    public List<FeedbackEntity> getFeedback(@PathVariable Integer itemId){
        return feedbackService.getFeedback(itemId);
    }
}
