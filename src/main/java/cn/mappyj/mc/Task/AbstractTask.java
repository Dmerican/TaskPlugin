package cn.mappyj.mc.Task;

import cn.mappyj.mc.Obj.Prize;
import cn.mappyj.mc.Obj.RequireMent;
import cn.mappyj.mc.TaskPlugin;
import cn.mappyj.mc.Utils.FileCreateUtil;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public abstract class AbstractTask {
    protected final UUID id;
    protected final String name;
    protected final String[] introduce;
    protected final RequireMent requireMent;
    protected final Prize prize;
    protected File TaskDir;

    protected final static JavaPlugin plugin = JavaPlugin.getPlugin(TaskPlugin.class);

    protected AbstractTask(UUID id, String name, String[] introduce, RequireMent requireMent, Prize prize){
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.requireMent = requireMent;
        this.prize = prize;
    }

    public UUID getId(){
        return id;
    }

    public RequireMent getRequireMent() {
        return requireMent;
    }

    public Prize getPrize() {
        return prize;
    }

    public void submitRequirement(Player p){

    }

    public void claimPrize(Player p){

    }

    protected void checkDir(File file){
        if(!new FileCreateUtil(file).createDir()){
            plugin.getServer().getLogger().warning("无法识别的目录!");
        }
    }

    protected void checkFile(File file){
        try{
            if(!new FileCreateUtil(file).createFile()){
                plugin.getServer().getLogger().warning("无法识别的文件!");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
