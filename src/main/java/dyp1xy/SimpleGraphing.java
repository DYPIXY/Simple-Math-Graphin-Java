package main.java.dyp1xy;

public class SimpleGraphing {
    //this is the way people will implement this lib to their program
    //@TODO make it a package for linux distributions as a simple way to graph things, and make a method for each way of graph
    public static void DrawGraph(String GraphType, String[] equation, String[] args) {

    
    }
    public static void main(String[] args){
        String[] equations = {"3*x*x+2*x+2", "x*2+5"};
        DrawGraph("matplotlib", equations, args);
        //DrawGraphMatLib(equations);
        //DrawGraphLineChart(equations);
    }
}