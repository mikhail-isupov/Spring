package ru.geekbrains.feedback_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.feedback_server.model.FeedbackEntity;
import ru.geekbrains.feedback_server.model.ItemEntity;
import ru.geekbrains.feedback_server.repo.iFeedbackRepo;
import ru.geekbrains.feedback_server.repo.iGoodsRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FeedbackService implements iFeedbackService {
    @Autowired
    iGoodsRepo goodsRepo;

    @Autowired
    iFeedbackRepo feedbackRepo;
    public FeedbackEntity postFeedback(Integer itemId, String feedback){
        ItemEntity item = goodsRepo.findById(itemId).orElseThrow(NoSuchElementException::new);
        return feedbackRepo.save(new FeedbackEntity(feedback, item));
    }

    public List<FeedbackEntity> getFeedback(Integer itemId){
        ItemEntity item = goodsRepo.findById(itemId).orElseThrow(NoSuchElementException::new);
        return feedbackRepo.findByItem(item);
    }
}
