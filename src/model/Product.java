/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fomri
 */
public enum Product {
    BURGER(1,"burger.jpg", 0.55f), SUSHI(2,"sushi.jpg", 0.78f), TACOS(3,"tacos.jpg", 0.56f);
    private int id;
    private String imageFile;
    private float price;

    Product(int id,String imageFile, float price) {
        this.id = id;
        this.imageFile = imageFile;
        this.price = price;
    }

    public String getImageFile() {
        return imageFile;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
    

}
