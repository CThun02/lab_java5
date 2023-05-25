package poly.java5.lab4.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import poly.java5.lab4.model.Item;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Service
public class CartServiceImpl implements CartServiceInterface{
    private final List<Item> cartItems;
    public CartServiceImpl() {
        this.cartItems = new ArrayList<>();

    }

    @Override
    public Item add(Item item) {
        for (int i = 0; i < cartItems.size(); i++) {
            if(cartItems.get(i).getId()==item.getId()){
                item.setQuantity(item.getQuantity()+1);
                cartItems.set(i, item);
                return item;
            }
        }
        cartItems.add(item);
        return item;
    }

    @Override
    public void remove(Integer id) {
        for (int i = 0; i < cartItems.size(); i++) {
            if(cartItems.get(i).getId()==id){
                cartItems.remove(i);
            }
        }
    }

    @Override
    public Item update(Item item, int quantity) {
        for (int i = 0; i < cartItems.size(); i++) {
            if(cartItems.get(i).getId()==item.getId()){
                item.setQuantity(quantity);
                cartItems.set(i, item);
                return item;
            }
        }
        return null;
    }

    @Override
    public void clear() {
       cartItems.removeAll(cartItems);
    }

    @Override
    public List<Item> getCartItems() {
        return cartItems;
    }

    @Override
    public Item getOneByID(int id, List<Item> shopItems) {
        for (int i = 0; i < shopItems.size(); i++) {
            if(shopItems.get(i).getId()==id){
                return shopItems.get(i);
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }
}
