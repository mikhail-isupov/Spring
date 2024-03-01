package ru.geekbrains.feedback_server.controller;

import ru.geekbrains.feedback_server.model.FeedbackEntity;

import java.util.List;

public interface iFeedbackController {

    FeedbackEntity postFeedback(Integer itemId, String feedback);
    List<FeedbackEntity> getFeedback(Integer itemId);
}
