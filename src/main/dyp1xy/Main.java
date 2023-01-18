package src.main.dyp1xy;

//this is in case of running the application standalone, nothing fancy, keep things simple\
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import src.main.dyp1xy.GraphMatPlotLib;
import src.main.dyp1xy.GraphLineChart;
import src.main.dyp1xy.GraphSwing;

@Command(
        name = "simple-graphing",
        version = "1.0",
        description = "Java lib to simple graph math functions, can run as a CLI with fewer configuration options")

public class Main implements Runnable{
    static final String demoFunction = "(x+2) * 2";
    static final String demoFunction2 = "x 2 + x − 30";

    //options and parameters
    @Option(
            names = "--demo",
            description = "Show a demo from selected Graph Type using a quadratic and a linear equation (ALL other parameters EXCEPT '-g' WILL be ignored)")
        boolean demo;
    @Option(
            names = {"-g", "--graphType" },
            description = "The type of the graph [MatPlotLib, LineChart, Swing] write one of those after '-g'",
            interactive = true)
        private String graphType;

    @Option(
            names = {"-s", "--save"},
            description = "Save the output graph as an image, default path is .")
        private boolean save;

    @Option(
            names = { "-o", "--out" },
            description = "Where to save the output file, if only '-s' is declared, save to te current directory, if '-o and -s' not declared, do not save the output"  )
        private String savePath;
    // At least one input
    @Parameters(
            index = "0..*",
            description = "Math functions to graph")
        private String[] equations;

    @Option(
            names = { "-h", "--help" },
            usageHelp = true,
            description = "Display help")
        private boolean help;
    @Option(
            names = {"-V", "--version"},
            versionHelp = true,
            description = "display version")
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
        if(demo){
            equations[0] = demoFunction;
            equations[1] = demoFunction2;
        }
        // if -o especified, them save
        if(savePath != null){
            save = true;
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
