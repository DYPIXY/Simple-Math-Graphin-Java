package dyp1xy;

public class SimpleGraphing {
    public static void DrawGraph(String GraphType, String[] equation, String[] args) {


        switch(GraphType.toLowerCase()){
            case "matplotlib": 
                GraphMatPlotLib gmpl = new GraphMatPlotLib(equation, args);

                break;
            case "linechart":
                GraphLineChart glc = new GraphLineChart(equation);
                break;
            default:
            throw new IllegalArgumentException("Wrong GraphType input, see the tutorial on: https://github.com/DYPIXY/Simple-Math-Graphin-Java");
        }
        
    
    }
    public static void main(String[] args){
        String[] equations = {"3*x*x+2*x+2", "x*2+5"};
        DrawGraph("camfamdasf", equations, args);
        //DrawGraphMatLib(equations);
        //DrawGraphLineChart(equations);
    }
}