package src.main.dyp1xy;
import src.main.dyp1xy.*;
public class SimpleGraphing {
    static boolean saveImage;
    static String savePath = ".";

    public static void DrawGraph(String graphType, String[] equations) {
        switch (graphType.toLowerCase()){
            case "matplotlib":
                GraphMatPlotLib graphMatPlotLib = new GraphMatPlotLib(equations);
                graphMatPlotLib.main();
                break;
            case "linechart":
                GraphLineChart graphLineChart = new GraphLineChart(equations);
                graphLineChart.main();
                break;
            case "swing":
                GraphSwing graphSwing = new GraphSwing(equations);
                break;
            //hidden
            case "assis":
                System.out.println("Ao verme que primeiro roeu as frias carnes do meu cadáver dedico como saudosa lembrança estas Memórias Póstumas");
                System.exit(0);
            default:
                System.out.println("Wrong GraphType input, see a tutorial on: https://github.com/DYPIXY/Simple-Math-Graphin-Java. If you ran on CLI mode, use --help instead");
                System.exit(1);
        }
    
    }

    //static getters and setters
    static public void setSave(boolean save){
        saveImage = save;
    }
    static public boolean getSave() { return saveImage; }
    static public void setSavePath(String path) {
        savePath = path;
    }
    static public String getSavePath(){ return savePath; }

}