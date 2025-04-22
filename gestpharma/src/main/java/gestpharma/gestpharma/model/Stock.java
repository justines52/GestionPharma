package gestpharma.gestpharma.model;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Lot> lots ;
    private String ID_Stock;
    private String ID_lot;
    private int quantity;

    public Stock() {}
    public Stock(String ID_Stock, String ID_lot , int quantity) {
        this.ID_Stock = ID_Stock;
        this.ID_lot = ID_lot;
        this.quantity = quantity;
        this.lots = new ArrayList<>();
    }
    public Stock(String ID_Stock) {
        this.ID_Stock = ID_Stock;
        this.lots = new ArrayList<>();
        this.quantity = 0;
    }

    public void addLot(Lot lot) {
        lots.add(lot);
        quantity++;
    }

    public void removeLot(Lot lot) {
        if (lots.remove(lot)) {
            quantity--;
        }
    }

    //getters

    public ArrayList<Lot> getLots() {
        return lots;
    }
    public String getID_Stock() {
        return ID_Stock;
    }
    public String getID_lot() {
        return ID_lot;
    }
    public int getQuantity() {
        return quantity;
    }

    //setters

    public void setLots(ArrayList<Lot> lots) {
        this.lots = lots;
    }
    public void setID_Stock(String ID_Stock) {
        this.ID_Stock = ID_Stock;
    }
    public void setID_lot(String ID_lot) {
        this.ID_lot = ID_lot;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
