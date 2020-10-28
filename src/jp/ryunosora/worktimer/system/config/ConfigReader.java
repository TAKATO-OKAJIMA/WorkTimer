package jp.ryunosora.worktimer.system.config;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class ConfigReader {

    //private ArrayList<String> textList = new ArrayList<String>();
    private String path = null;

    public ConfigReader(){

    }

    public ConfigReader(String path){
        this.path = path;
    }

    public ArrayList<String> readConfig(){
        //Path file = this.getResourcePaths();
        //ArrayList<String> configList = this.readConfigUseNio(file);
        ArrayList<String> configList = this.readConfigUseBufferedReader();
        return configList;
    }

    public ArrayList<String> readConfig(String path){
        this.path = path;
        ArrayList<String> configList = this.readConfigUseBufferedReader();
        //Path file = this.getResourcePaths();
        //ArrayList<String> configList = this.readConfigUseNio(file);
        return configList;
    }

    /*
    private ArrayList<String> readConfigUseNio(Path file){
        //ClassLoader classLoader = this.getClass().getClassLoader();
        List<String> configLines = new ArrayList<String>();

        try{
            configLines = Files.lines(file).collect(Collectors.toList());
        }catch(IOException e){
            e.printStackTrace();
        }

        ArrayList<String> configList = new ArrayList<String>(configLines);

        return configList;
    }*/

    private ArrayList<String> readConfigUseBufferedReader(){
        ClassLoader classLoader = this.getClass().getClassLoader();

        ArrayList<String> configList = new ArrayList<String>();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        /*
        String path = classLoader.getResource(this.path.replaceAll("jar:","")).toString();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(new URI(path))))){
            String config;
            while((config = bufferedReader.readLine()) != null){
                configList.add(config);
            }
        }catch (IOException | URISyntaxException e){
            e.printStackTrace();
        }*/
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String config;
            while((config = bufferedReader.readLine()) != null){
                configList.add(config);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        return configList;
    }

    private Path getResourcePaths(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        Path file = null;

        /*
        try{
            final URI uri = classLoader.getResource(this.path).toURI();
            //final String[] array = uri.toString().split("!");
            Map<String, String> environment = new HashMap<>();
            environment.put("create", "true");
            System.out.println(uri.toString());
            //System.out.println(array[0]);
            FileSystem fileSystem = FileSystems.newFileSystem(uri, environment);
            //FileSystem fileSystem = FileSystems.newFileSystem(URI.create(array[0]), Collections.EMPTY_MAP);
            //file = fileSystem.getPath(this.path);
            file = Paths.get(uri);
        }catch (URISyntaxException | IOException e){
            e.printStackTrace();
        }
        */
        try{
            file = Paths.get(classLoader.getResource(this.path).toURI());
        }catch (URISyntaxException e){
            e.printStackTrace();
        }

        return  file;
    }
}
