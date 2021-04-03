package main;

import main.worker.Worker;

import java.io.FileReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * Class to parse workers from json file
 */
public class JSONFileWorkerReader implements WorkerReader{
    private String dataFileName;

    public JSONFileWorkerReader(String dataFileName){
        this.dataFileName = dataFileName;
    }

    @Override
    public Collection<Worker> getWorkers() {
        String jsonString = getJSONString();
        Pattern pattern = Pattern.compile("");
        String[] jsonStrings = jsonString.split();
        for(String s:jsonStrings){

        }

        Collection<Worker> result = new LinkedList<Worker>();

        return result;
    }

    private String getJSONString(){
        String jsonString = null;
        try{
            FileReader fileReader = new FileReader(dataFileName);
            StringBuilder sb = new StringBuilder();
            int code = -1;
            while ((code = fileReader.read()) != -1) {
                sb.append(Character.toChars(code));
            }
            fileReader.close();
            jsonString = new String(sb);
        }catch (Exception e){
            System.err.println("We have some problems with file.");
            if(e.getMessage() != null){
                System.out.println(e.getMessage());
            }
        }
        return jsonString;
    }
}
