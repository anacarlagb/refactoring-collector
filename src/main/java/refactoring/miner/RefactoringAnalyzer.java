package refactoring.miner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import refactoring.miner.output.CommitOutput;
import refactoring.miner.output.RefInfo;
import refactoring.miner.output.RefactoringOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RefactoringAnalyzer {

    public static void main(String[] args) throws IOException {

        RefactoringAnalyzer analyzer = new RefactoringAnalyzer();

        //analyzer.getRefactoringsFromRefMiner("C:\\Users\\anaca\\Executaveis\\RefactoringMiner-2.0.0\\"
        //		+ "RefactoringMiner-2.0.0\\build\\distributions\\RefactoringMiner-1.0\\"
        //		+ "RefactoringMiner-1.0\\bin\\refactoring-toy-example",
        //		"36287f7c3b09eff78395267a3ac0d7da067863fd");
    }

    public List<String> getRefactoringsFromRefMiner(String pathProject, String commit){

        String resultRefMiner = executeRefMiner(pathProject, commit);
        List<String> refactoringsList = new ArrayList<>();
        //convert string to json
        //get refactorings from json

        ObjectMapper mapper = new ObjectMapper();

        try {

            RefInfo refInfo = mapper.readValue(resultRefMiner, new TypeReference<RefInfo>(){});
            List<CommitOutput> commitOutputs = refInfo.getCommits();

            for(CommitOutput commitOutput : commitOutputs){

                if(commitOutput.getRefactorings() != null && commitOutput.getRefactorings().size() > 1) {
                    for (RefactoringOutput refactoringOutput : commitOutput.getRefactorings()) {
                           System.out.println(refactoringOutput.getType());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return refactoringsList;

    }

    public String executeRefMiner(String pathProject, String commit) {

        String REF_MINER_PATH = "C:\\Users\\anaca\\Executaveis\\RefactoringMiner-2.0.1\\RefactoringMiner-2.0.1\\"
                + "build\\distributions\\RefactoringMiner-2.0.1\\RefactoringMiner-2.0.1\\bin";
        //"" && ./RefactoringMiner -c " + pathProject + " " + commit"

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + REF_MINER_PATH +
                " && RefactoringMiner -c " + pathProject + " " + commit);
        builder.redirectErrorStream(true);
        String line = null;
        String refactorings = "";
        try {
            Process process = builder.start();
            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));


            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                refactorings+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int jsonIndex = refactorings.indexOf("{");
        refactorings = refactorings.substring(jsonIndex);
        return refactorings;


    }
}
