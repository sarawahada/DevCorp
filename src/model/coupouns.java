/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class coupouns {
    private int id_coupouns;
   private String text_coupouns;
   private String code_coupouns;
   private String date_1;
      private String date_2;
      private int id_promo1;
      private int duree_coupouns;

   

    public coupouns() {
    }

    public coupouns(int id_coupouns, String text_coupouns, String code_coupouns, String date_1, String date_2, int id_promo1, int duree_coupouns) {
        this.id_coupouns = id_coupouns;
        this.text_coupouns = text_coupouns;
        this.code_coupouns = code_coupouns;
        this.date_1 = date_1;
        this.date_2 = date_2;
        this.id_promo1 = id_promo1;
        this.duree_coupouns = duree_coupouns;
    }

    public coupouns(String text_coupouns, String code_coupouns, String date_1, String date_2, int id_promo1, int duree_coupouns) {
        this.text_coupouns = text_coupouns;
        this.code_coupouns = code_coupouns;
        this.date_1 = date_1;
        this.date_2 = date_2;
        this.id_promo1 = id_promo1;
        this.duree_coupouns = duree_coupouns;
    }
    

    public int getDuree_coupouns() {
        return duree_coupouns;
    }

    public void setDuree_coupouns(int duree_coupouns) {
        this.duree_coupouns = duree_coupouns;
    }

   

    public String getDate_1() {
        return date_1;
    }

    public void setDate_1(String date_1) {
        this.date_1 = date_1;
    }

    public String getDate_2() {
        return date_2;
    }

    public void setDate_2(String date_2) {
        this.date_2 = date_2;
    }

    public int getId_promo1() {
        return id_promo1;
    }

    public void setId_promo1(int id_promo1) {
        this.id_promo1 = id_promo1;
    }

 
    public int getId_coupouns() {
        return id_coupouns;
    }

    public void setId_coupouns(int id_coupouns) {
        this.id_coupouns = id_coupouns;
    }

    public String getText_coupouns() {
        return text_coupouns;
    }

    public void setText_coupouns(String text_coupouns) {
        this.text_coupouns = text_coupouns;
    }

    public String getCode_coupouns() {
        return code_coupouns;
    }

    public void setCode_coupouns(String code_coupouns) {
        this.code_coupouns = code_coupouns;
    }

    @Override
    public String toString() {
        return "coupouns{" + "id_coupouns=" + id_coupouns + ", text_coupouns=" + text_coupouns + ", code_coupouns=" + code_coupouns + ", date_1=" + date_1 + ", date_2=" + date_2 + ", id_promo1=" + id_promo1 + ", duree_coupouns=" + duree_coupouns + '}';
    }

     
    public int compareTo(coupouns c) {
        return Long.compare(this.id_coupouns, c.id_coupouns);
    }

  
   
}

