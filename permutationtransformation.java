import java.util.Scanner;

public class permutationtransformation {

	public static void main(String[] args) {
		 // Use the Scanner class
	      Scanner sc = new Scanner(System.in);  
	      /*
	      int n      = sc.nextInt();        // read input as integer
	      long k     = sc.nextLong();       // read input as long
	      double d   = sc.nextDouble();     // read input as double
	      String str = sc.next();           // read input as String
	      String s   = sc.nextLine();       // read whole line as String
	      */
	      String s= sc.nextLine();
	      int t = Integer.parseInt(s);
	      
	      for (int i=0;i<t;i++) {
	    	  //System.out.println("\n neue Runde");
	    	  int n=Integer.parseInt(sc.nextLine());
	    	  s= sc.nextLine();
	    	  String numbers[]=s.split(" ");
	    	  
	    	  int [] nums= new int[numbers.length];
	    	  int [] ranking= new int[numbers.length];
	    	  for (int b=0; b< numbers.length;b++) {
	    		  nums[b]= Integer.parseInt(numbers[b]) ;
	    		  ranking[b]=0;
	    		  //System.out.print(nums[b]+" ");
	    	  }
	    	  
	    	  boolean checker= true;
	    	  int biggest=0;
	    	  int index=0;
	    	  int level=0;
	    	  int start=0;
	    	  while(checker) {
	    		  biggest=0;
	    		  index=0;
	    		  start=0;
	    		  checker=false;
	    		  for(int j=0;j<nums.length;j++) {
	    			  if (ranking[j]<level) {
	    	    		  for(int k=start;k<j;k++) {
	    	    			  if(k!=index) {
	    	    				  ranking[k]++;
	    	    			  }
	    	    		  }
	    	    		  index=j+1;
	    	    		  start=j+1;
	    	    		  biggest=0;
	    			  }else {
		    			  if(nums[j]>biggest) {
		    				  checker=true;
		    				  biggest=nums[j];
		    				  index=j;
		    			  }
	    			  }

	    		  }
	    		  for(int j=start;j<ranking.length;j++) {
	    			  if(j!=index) {
	    				  ranking[j]++;
	    			  }
	    		  }
	    		  level++;
	    	  }
	    	  //System.out.println("biggest "+biggest+" ,index "+index);
	    	  String res="";
	    	  for (int j =0;j<ranking.length;j++) {
	    		  res+=ranking[j]+" ";
	    	  }
	    	  System.out.println(res);
	    	  
	    	  
	      }
	      
	}

}
