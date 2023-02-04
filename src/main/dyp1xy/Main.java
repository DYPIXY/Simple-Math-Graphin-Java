package src.main.dyp1xy;

//this is in case of running the application standalone, nothing fancy, keep things simple\
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.Arrays;

@Command(
        name = "simple-graphing",
        version = "1.0",
        description = "Java lib to simple graph math functions, can run as a CLI with fewer configuration options")

public class Main implements Runnable{
    static final String demoFunction = "(x+2) * 2";
    static final String demoFunction2 = "x*x + x − 30";

    //options and parameters
    @Option(
            names = "--demo",
            description = "Show a demo from selected Graph Type using a quadratic and a linear equation (ALL other parameters EXCEPT '-g' WILL be ignored)")
        boolean demo;
    @Option(
            names = {"-g", "--graphType" },
            description = "The type of the graph [MatPlotLib, LineChart, Swing]")
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
    }
    @Override
    public void run(){
        if (graphType == null && System.console() != null) {
            // alternatively, use Console::readPassword
            graphType = System.console().readLine("Enter value for --graphType [MatPotLib, LineChart, Swing]: ");
        }
        System.out.println("You provided value '" + graphType + "' for graph type");
        //some checks
        if(demo){
            Arrays.fill(equations, null);
            equations[0] = demoFunction;
            equations[1] = demoFunction2;
        }
        // if -o especified, them save
        if(savePath != null){
            save = true;
        }
        //pass arguments to static variables on SimpleGraphing and then run it
        SimpleGraphing.savePath = savePath;
        SimpleGraphing.saveImage = save;
        SimpleGraphing.DrawGraph(graphType, equations);

    }
}
