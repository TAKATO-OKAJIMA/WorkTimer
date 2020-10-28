package jp.ryunosora.worktimer.system.config;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardOpenOption.*;

public class ConfigWriter {

    private String path = null;

    public ConfigWriter(){

    }

    public ConfigWriter(String path){
        this.path = path;
    }

    public void writeConfig(ArrayList<String> configList){
        Path file = this.getResourcePath();
        this.writeConfig(file, configList);
    }

    public void writeConfig(String path, ArrayList<String> configList){
        this.path = path;
        Path file = this.getResourcePath();
        this.writeConfig(file, configList);
    }

    private void writeConfig(Path file, ArrayList<String> configList){
        try {
            Files.write(file, configList, CREATE, WRITE, APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Path getResourcePath(){
        //ClassLoader classLoader = this.getClass().getClassLoader();
        Path file = null;

        try{
            //final String[] array = this.path.split("!");
            final URI uri = this.getClass().getResource(this.path).toURI();
            Map<String, String> env = new HashMap<>();
            env.put("create","true");
            FileSystem fileSystem = null;
            try {
                fileSystem = FileSystems.newFileSystem(uri, env);
                //file = fileSystem.getPath(array[1]);
                file = Paths.get(uri);
                fileSystem.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }catch (URISyntaxException e){
            e.printStackTrace();
        }

        return file;
    }

}
