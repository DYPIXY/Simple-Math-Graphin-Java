package src.main.dyp1xy;

//this is in case of running the application standalone, nothing fancy, keep things simple\
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import src.main.dyp1xy.GraphMatPlotLib;
import src.main.dyp1xy.GraphLineChart;
import src.main.dyp1xy.GraphSwing;

@Command(name = "simple-graphing", version = "1.0", description = "Java lib to simple graph math functions, can run as a CLI with fewer configuration options")
public class Main implements Runnable{
    static final String demoFunction = "(x+2) * 2";
    static final String demoFunction2 = "sex in the city";

    //options and parameters
    @Option(names = "--demo", description = "Show a demo from selected Graph Type using a quadratic and a linear equation (all other parameters WILL be ignored)")
    boolean demo;
    @Option(names = "-g", description = "The type of the graph, see --help", interactive = true)
        private String graphType;

    @Option(names = {"-s", "--save"}, description = "Save the output graph as an image, default path is .")
        private boolean save;

    @Option(names = { "-o", "--out" }, paramLabel = "", description = "Where to save the output file" )
        private String savePath;
    // At least one input
    @Option(names = "-e --equations", arity = "1..*", description = "one or more equations to graph", interactive = true)
        private String[] equations;

    @Option(names = { "-h", "--help" }, help = true, description = "display a help")
        private boolean help;
    @Option(names = {"-v", "--version"}, versionHelp = true, description = "display version")
        private boolean version;

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
        CommandLine commandLine = new CommandLine(new Main());
        commandLine.parseArgs(args);
        if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            return;
        }
        if(commandLine.isUsageHelpRequested()) {
            
        }

    }
    @Override
    public void run(){


        // if -o especified, them save
        if(savePath != null){
            save = true;
        }
        //debug reasons
        if(graphType == null){
            graphType = "LineChart";
        }


        //actual code
        switch(graphType.toLowerCase()){
            case "matplotlib":
                GraphMatPlotLib gmpl = new GraphMatPlotLib(equations);
                break;
            case "linechart":
                GraphLineChart glc = new GraphLineChart(equations);
                break;
            case "swing":
                GraphSwing gs = new GraphSwing(equations);
                break;
            default:
                throw new IllegalArgumentException("Wrong GraphType input, see a tutorial on: https://github.com/DYPIXY/Simple-Math-Graphin-Java");
        }
    }
}
