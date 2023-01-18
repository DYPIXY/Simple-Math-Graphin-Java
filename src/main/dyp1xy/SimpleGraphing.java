package src.main.dyp1xy;

public class SimpleGraphing {
    //this is the way people will implement this lib to their program
    //@TODO make it a package for linux distributions as a simple way to graph things, and make a method for each way of graph
    public static void DrawGraph() {
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
        DrawGraph();
        //DrawGraphMatLib(equations);
        //DrawGraphLineChart(equations);
    }
}