package cn.mappyj.mc.Utils;

import java.io.File;
import java.io.IOException;

public class FileCreateUtil {
    private final File file;

    public FileCreateUtil(File file){
        this.file = file;
    }

    public boolean createDir(){
        if(!file.exists()){
            return file.mkdir();
        }
        return true;
    }

    public boolean createFile() throws IOException {
        if(!file.exists()){
            return file.createNewFile();
        }
        return true;
    }
}
