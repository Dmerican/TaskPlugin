package cn.mappyj.mc.Obj;


import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RequireMent {
    private List<ItemStack> requireItems = new ArrayList<>();
    private int requireLevel = 0;

    public RequireMent(List<ItemStack> requireItems,int requireLevel){
        this.requireItems = requireItems;
        this.requireLevel = requireLevel;
    }

    public RequireMent(List<ItemStack> requireItems){
        this.requireItems = requireItems;
    }

    public List<ItemStack> getRequireItems(){
        return requireItems;
    }

    public int getRequireLevel(){
        return requireLevel;
    }
}
