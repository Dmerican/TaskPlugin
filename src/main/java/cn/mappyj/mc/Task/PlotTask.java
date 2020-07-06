package cn.mappyj.mc.Task;

import cn.mappyj.mc.Obj.Prize;
import cn.mappyj.mc.Obj.RequireMent;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlotTask extends AbstractTask{
    public static List<UUID> TaskIDList = new ArrayList<>();

    public PlotTask(UUID id, String name, String[] introduce, RequireMent requireMent, Prize prize) {
        super(id, name, introduce, requireMent, prize);
        super.TaskDir = new File(plugin.getDataFolder(),"PlotTask");
        checkDir(TaskDir);
    }

    public class PlayerInfo{
        private int nowTaskIndex;
        protected PlayerInfo(Player p){

        }
    }
}
