package cn.mappyj.mc.Obj;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Prize {
    private List<ItemStack> prizeItems = new ArrayList<>();
    private int prizeLevel = 0;

    public Prize(List<ItemStack> prizeItems, int prizeLevel){
        this.prizeItems = prizeItems;
        this.prizeLevel = prizeLevel;
    }

    public Prize(List<ItemStack> prizeItems){
        this.prizeItems = prizeItems;
    }

    public List<ItemStack> getPrizeItems(){
        return prizeItems;
    }

    public int getPrizeLevel(){
        return prizeLevel;
    }
}
