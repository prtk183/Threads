package threads;

public class ThreadDeadlock {  
	  public static void main(String[] args) {  
	    final String resource1 = "one";  
	    final String resource2 = "two";  
	    
	    // t1 tries to lock resource1 then resource2  
	    Thread t1 = new Thread() {  
	      public void run() {  
	    	  
	    	 
	    	  
	    		  	synchronized (resource1) {  
	    		  	System.out.println("Thread 1: locked resource 1");  
	  
	    		  	try { Thread.sleep(100);} catch (Exception e) {}  
	  
	    		  	synchronized (resource2) {  
	    		  		System.out.println("Thread 1: locked resource 2");  
	    		  	}  
	    
	    	  }
	      }  
	    };  
	  
	    // t2 tries to lock resource2 then resource1  
	    Thread t2 = new Thread() {  
	      public void run() { 
	    	  
	        synchronized (resource2) {  
	          System.out.println("Thread 2: locked resource 2");  
	  
	         try { Thread.sleep(100);} catch (Exception e) {}  
	  
	          synchronized (resource1) {  
	            System.out.println("Thread 2: locked resource 1");  
	          }  
	        }  
	      }  
	    };  
	  
	      
	    t1.start(); 
	    t2.start();
	   
	 /*   try {
			t2.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
	  /*  
	   try {
			t1.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	   
	     
	  }  
	
}
