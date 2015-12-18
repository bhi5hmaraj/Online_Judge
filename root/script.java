import java.util.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
public class script {
public static void main(String[] args) throws Exception {
ScriptEngineManager mgr = new ScriptEngineManager();
ScriptEngine engine = mgr.getEngineByName("JavaScript"); // "cheat"
Scanner sc = new Scanner(System.in);
 System.out.println(engine.eval(sc.nextLine()));
 sc.close();
} 
}