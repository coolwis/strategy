import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Director {
    
    private Map<String, Paper> project = new HashMap<>();

    public void addProject(String name, Paper paper) {
        project.put(name, paper);        
    }
    public void runProject(String name) {
        if(!project.containsKey(name)) {
            throw new RuntimeException("Project " + name + " not found");
        }
        deploy(name, project.get(name).run());
    }

    private void deploy(String name, Program... programs) {

        System.out.println(name);
        Arrays.stream(programs).forEach(program -> System.out.println(program.toString()));
    }
}
