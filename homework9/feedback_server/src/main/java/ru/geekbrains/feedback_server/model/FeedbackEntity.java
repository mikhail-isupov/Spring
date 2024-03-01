package ru.geekbrains.feedback_server.model;

import jakarta.persistence.*;

@Entity
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String itemFeedback;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ItemEntity item;

    public FeedbackEntity(){}

    public FeedbackEntity(String itemFeedback, ItemEntity item){
        this.itemFeedback = itemFeedback;
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public ItemEntity getItem() {
        return item;
    }

    public String getItemFeedback() {
        return itemFeedback;
    }
}
