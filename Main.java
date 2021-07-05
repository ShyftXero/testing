class Main {
  public static void sop(Object o){
      System.out.println(o);
  }
  public static void main(String[] args) {
    String name  = "tom cruise";
    // System.out.println(name);
    sop(name);

    String fname = name.substring(0, name.indexOf(" ") ); 
    String lname = name.substring(name.indexOf(" ") + 1); 
    sop(fname);
    sop(lname);

    Object[] array_with_different_types = {"what????", 1, 4.0,'c'};

    for (Object o: array_with_different_types){
        sop(o);
    }

    Object daterz = "eli";
    daterz = 23;
    sop(daterz);


    sop("end");
  }
}



public class InstrumentationAgent {
    private static volatile Instrumentation globalInstrumentation;

    public static void premain(final String agentArgs, final Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static long getObjectSize(final Object object) {
        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return globalInstrumentation.getObjectSize(object);
    }
}