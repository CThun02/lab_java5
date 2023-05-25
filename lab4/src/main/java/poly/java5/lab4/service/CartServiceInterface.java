package poly.java5.lab4.service;

import poly.java5.lab4.model.Item;

import java.util.List;

public interface CartServiceInterface {
    public Item add(Item item);
    public void remove(Integer id);
    public Item update(Item item, int quantity);
    public void clear();
    public List<Item> getCartItems();
    public Item getOneByID(int id, List<Item> shopItems);
    public int getCount();
}
