/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barjieras;

public class Barjieras
{
    private int kvietejuSkaicius=0;
   // private int tmpKvietejuSkaicius;
    private int barjieroRiba;
    
    public Barjieras(int n) {
    	this.barjieroRiba = n;
    }
    public  synchronized void waitbarrier() throws InterruptedException
    {
    kvietejuSkaicius++;
    	if (kvietejuSkaicius!=barjieroRiba)
    		wait();
    	else {
            notifyAll();
    		//tmpKvietejuSkaicius = barjieroRiba;
    		kvietejuSkaicius = 0;
    	}
    	//tmpKvietejuSkaicius--;
    	/*if (tmpKvietejuSkaicius!=0) 
    		wait(); 
    	else {
    		notifyAll();
    		//sum = 0;
    	}		    	*/
    
    }

}

