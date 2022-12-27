public class SimpleGraphing {
    public static void DrawGraph(String GraphType, String[] equation, String[] args) {
        switch(GraphType.toLowerCase()){
            case "matplotlib": 
                GraphMatPlotLib gmpl = new GraphMatPlotLib(equation, args);
                break;
            case "linechart":

                break;
            default:
                System.out.println("Wrong input, see the tutorial on:\n  ");
        }
        
    
    }
    public static void main(String[] args){
        String[] equations = {"3*x*x+2*x+2", "x*2+5"};
        DrawGraph("matplotlib", equations, args);
        //DrawGraphMatLib(equations);
        //DrawGraphLineChart(equations);
    }
}