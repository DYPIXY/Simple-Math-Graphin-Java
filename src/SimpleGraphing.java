public class SimpleGraphing {
    public static void DrawGraph(int GraphType, String[] equation, String[] args) {
        switch(GraphType){
            case 0: 
                GraphMatPlotLib gmpl = new GraphMatPlotLib(equation, args);
                break;
            case 1:

                break;
            default:
                System.out.println("Out of range, see the tutorial on:\n  ");
        }
        
    
    }
    public static void main(String[] args){
        String[] equation = {"3*x*x+2*x+2", "x*2+5"};
        DrawGraph(1, equation, args);

    }
}