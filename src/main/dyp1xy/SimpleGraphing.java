package src.main.dyp1xy;

public class SimpleGraphing {
    static boolean saveImage;
    static String savePath = ".";

    public static void DrawGraph(String graphType, String[] equations) {
        switch(graphType.toLowerCase()){
            case "matplotlib":
                GraphMatPlotLib gmpl = new GraphMatPlotLib(equations);

            case "linechart":
                GraphLineChart glc = new GraphLineChart(equations);
                break;
            case "swing":
                GraphSwing gs = new GraphSwing(equations);
                break;
            default:
                throw new IllegalArgumentException("Wrong GraphType input, see a tutorial on: https://github.com/DYPIXY/Simple-Math-Graphin-Java");
        }
        System.out.println("Ao verme\n" +
                "que\n" +
                "primeiro roeu as frias carnes\n" +
                "do meu cadáver\n" +
                "dedico\n" +
                "como saudosa lembrança\n" +
                "estas\n" +
                "Memórias Póstumas");
    
    }
    public static void main(String[] args){
        String[] equations = {"3*x*x+2*x+2", "x*2+5"};
        DrawGraph("linechart",equations);
    }
    //static getters and setters
    static public void setSave(boolean save){
        saveImage = save;
    }
    static public void setSavePath(String path) {
        savePath = path;
    }

}