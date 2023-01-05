package main.java.dyp1xy;

//this is in case of running the application standalone, nothing fancy, keep things simple\
import picocli.CommandLine;
import java.io.File;

public class Main implements Runnable{
    @CommandLine.Option(name = "--demo", description = "Show a demo from selected Graph Type using a quadratic and a linear equation")
        boolean demo;
    @CommandLine.Option(names = "-g", description = "The type of the graph, see --help", interactive = true)
        int graphType;

    @CommandLine.Option(names = {"-s", "--save"}, description = "Save the output graph as an image, default path is .")
        boolean save;

    @CommandLine.Option(names = { "-o", "--out" }, paramLabel = "", description = "Where to save the output file")
        File archive;
// At least one input
    @CommandLine.Parameters(paramLabel = "Function to graph", arity = "1..*", description = "one or more functions", interactive = true)
        String[] equations;

    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help")


    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
        System.out.println("Worked");



        /*switch(GraphType.toLowerCase()){
            case "matplotlib":
                GraphMatPlotLib gmpl = new GraphMatPlotLib(equation, args);

                break;
            case "linechart":
                GraphLineChart glc = new GraphLineChart(equation);
                break;
            default:
                throw new IllegalArgumentException("Wrong GraphType input, see the tutorial on: https://github.com/DYPIXY/Simple-Math-Graphin-Java");
        }
        */
    }
    @Override
    public void run(){
        System.out.println("hello world");
    }
}
