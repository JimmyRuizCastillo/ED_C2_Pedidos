package models;

import java.util.ArrayList;

public class Pedido {
    private int ID;
    private ArrayList<String> orden = new ArrayList<String>();
    public Pedido(int ID, ArrayList<String> orden){
        this.ID = ID;
        this.orden = orden;
    }
    public ArrayList<String> getOrden() {
        return orden;
    }
    public void setOrden(ArrayList<String> orden) {
        this.orden = orden;
    }
    public int getID() {
        return ID;
    }
}