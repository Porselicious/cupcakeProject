/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author jonab
 */
public class ShoppingBasket {

    private ArrayList<CupCake> basket = new ArrayList();
    private int totalPrice;


    public ShoppingBasket() {
    }

    public int getTotalPrice() {
        for (int i = 0; i < basket.size(); i++) {
            totalPrice += basket.get(i).getFullPrice();
        }
        return totalPrice;
    }
    
    public ArrayList<CupCake> getBasket() {
        return basket;
    }
    
}
