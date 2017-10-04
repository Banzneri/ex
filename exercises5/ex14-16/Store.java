import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private List<SellableItem> sellableItems;

    public Store(String name) {
        setName(name);
        sellableItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSellableItem(SellableItem si) {
        sellableItems.add(si);
    }

    public void removeSellableItem(SellableItem si) {
        sellableItems.remove(si);
    }

    public SellableItem getSellableItem(int i) {    
        return sellableItems.get(i);
    }

    public void sellAllItems() {
        for(SellableItem item : sellableItems) {
            item.sell();
        }

        sellableItems.clear();
    }
}