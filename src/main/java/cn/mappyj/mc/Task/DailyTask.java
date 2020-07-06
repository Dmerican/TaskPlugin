package cn.mappyj.mc.Task;

import cn.mappyj.mc.Obj.Prize;
import cn.mappyj.mc.Obj.RequireMent;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.entity.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class DailyTask extends AbstractTask{

    public DailyTask(UUID id, String name, String[] introduce, RequireMent requireMent, Prize prize) {
        super(id, name, introduce, requireMent, prize);
        super.TaskDir = new File(plugin.getDataFolder(),"DalyTask");
        checkDir(TaskDir);
    }

    public PlayerInfo getPlayerInfo(Player p){
        return new PlayerInfo(p);
    }

    public class PlayerInfo{
        private long lastDidTime;
        private boolean isDid;
        private final File infoFile;
        protected PlayerInfo(Player p){
            infoFile = new File(TaskDir,p.getUniqueId().toString()+".json");
            checkFile(infoFile);
            getInfo();
        }

        private void getInfo(){
            JsonParser parser = new JsonParser();
            try(FileInputStream inputStream = new FileInputStream(infoFile)) {
                byte[] bytes = new byte[(int)infoFile.length()];
                inputStream.read(bytes);
                JsonObject allText = parser.parse(new String(bytes, StandardCharsets.UTF_8)).getAsJsonObject();
                if(allText.get(getId().toString()) == null){
                    this.isDid = true;
                    this.lastDidTime = 0;
                }else{
                    this.isDid = allText.get(getId().toString()).getAsJsonObject().get("isDid").getAsBoolean();
                    this.lastDidTime = allText.get(getId().toString()).getAsJsonObject().get("lastTime").getAsLong();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public boolean isDid() {
            return isDid;
        }

        public long getLastDidTime() {
            return lastDidTime;
        }
    }
}
