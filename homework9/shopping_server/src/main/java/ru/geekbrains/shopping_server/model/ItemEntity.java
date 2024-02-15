package ru.geekbrains.shopping_server.model;


import jakarta.persistence.*;

/**
 * Сущность, описывающая товар.
 */
@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private ItemCategory itemCategory; //Категория товара

    @Column(nullable = false)
    private String itemModel; //Модель устройства

    @Column(nullable = false)
    private String itemDescription; //Описание устройства.

    public ItemEntity(){}

    public ItemEntity(ItemCategory itemCategory, String itemModel, String itemDescription){
        this.itemCategory = itemCategory;
        this.itemModel = itemModel;
        this.itemDescription = itemDescription;
    }

    public Integer getId() {
        return id;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public String getItemModel() {
        return itemModel;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Перечень категорий товаров.
     */
    public enum ItemCategory{
        PHONE, PAD, NOTEBOOK, DESKTOP
    }
}
