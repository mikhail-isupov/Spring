package ru.geekbrains.feedback_server.service;

import ru.geekbrains.feedback_server.model.FeedbackEntity;

import java.util.List;

public interface iFeedbackService {
    FeedbackEntity postFeedback(Integer itemId, String feedback);
    List<FeedbackEntity> getFeedback(Integer itemId);
}
