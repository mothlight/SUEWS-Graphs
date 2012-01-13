package au.edu.monash.ges.suews.test;

import org.rosuda.JRI.Rengine;

public class JRItest
{
    public static void main (String[] args)
    {
        // new R-engine
        Rengine re=new Rengine (new String [] {"--vanilla"}, false, null);
        if (!re.waitForR())
        {
            System.out.println ("Cannot load R");
            return;
        }
       
        // print a random number from uniform distribution
        //System.out.println (re.eval ("runif(1)").asDouble ());
        
        String plotStr = "x <- c(1,3,6,9,12)" + '\n' +
        			"y <- c(1.5,2,7,8,15)" + '\n' +
        			"plot(x,y)";
        
        System.out.println (re.eval (plotStr));
        
        re.eval("plot(c(1,5,3,8,5), type='l', col=2)");
        
        
       
        // done...
        re.end();
    }
   
}