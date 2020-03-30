/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barjieras;

public class Barjieras
{
    private int kvietejuSkaicius=0;
    private int tmpKvietejuSkaicius;
    private int sum;
    private int tmpSum;
    //private int tmpSum;
    private int barjieroRiba;
    
    public Barjieras(int n) {
    	this.barjieroRiba = n;
    	this.sum = 0;
    }
    public synchronized Integer wait(int reiksme) throws InterruptedException
    {
    	kvietejuSkaicius++;
    	sum+=reiksme;
    	if (kvietejuSkaicius!=barjieroRiba)
    		wait();
    	else {
    		notifyAll();
    		tmpSum = sum;
    		sum = 0;
    		tmpKvietejuSkaicius = barjieroRiba;
    		kvietejuSkaicius = 0;
    	}
    	int tmpSuma = tmpSum;
    	tmpKvietejuSkaicius--;
    	if (tmpKvietejuSkaicius!=0) 
    		wait(); 
    	else {
    		notifyAll();
    		//sum = 0;
    	}		    	
    	return tmpSuma;
    }

}

