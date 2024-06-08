/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3_lab6;

import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author haing
 */
public class CD {
    private long id;
    private String type;
    private String collection;
    private String title;
    private double price;
    private int year;

    public CD(long id, String type, String collection, String title, double price, int year) {
        this.id = id;
        this.type = type;
        this.collection = collection;
        this.title = title;
        this.price = price;
        this.year = year;
    }

    
    public CD() {
    }

    public String getTitle() {
        return title;
    }

    public String getCollection() {
        return collection;
    }

    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }
    
    
    public void Editob(String obj){
        Scanner sc = new Scanner(System.in);
        switch(obj){
            case "type":
                System.out.println("Input new one: ");
                String temp = sc.next();
                switch (temp){
                    case "audio":
                        this.type = "audio";
                        break;
                    case "video":
                        this.type = "video";
                        break;
                }
                break;
            case "collection":
                System.out.println("Input new one: ");
                String tempCo = sc.next();
                switch (tempCo){
                    case "game":
                        this.type = "game";
                        break;
                    case "movie":
                        this.type = "movie";
                        break;
                    case "music":
                        this.type = "music";
                        break;
                }
                break;
            case "tiltle":
                System.out.println("Input new one: ");
                String tempTi = sc.next();
                this.title = tempTi;
                break;
            case "price":
                System.out.println("Input new one: ");
                Double tempPr = sc.nextDouble();
                this.price = tempPr;
                break;
            case "year":
                System.out.println("Input new one: ");
                int tempY = sc.nextInt();
                this.year = tempY;
                break;
        }
    }
    
    public String toString(){
        return "ID: "+ id + "\n" + "Type: "+ type + "\n" + "Collection: "+ collection + "\n" +"Title: "+ title + "\n" + "Price: "+ price + "\n" +"Year: "+ year;
    }
    
    static  Comparator<CD> compareAboutID = new Comparator<CD>() {
            @Override
            public int compare(CD cd1, CD cd2) {
                if(cd1.getId()>cd2.getId()) return 1;
                if(cd1.getId()<cd2.getId()) return -1;
                return 0;
            }
        };
    
    static  Comparator<CD> compareAboutYear = new Comparator<CD>() {
            @Override
            public int compare(CD cd1, CD cd2) {
                if(cd1.getYear()<cd2.getYear()) return 1;
                if(cd1.getYear()>cd2.getYear()) return -1;
                return 0;
            }
        };
}
