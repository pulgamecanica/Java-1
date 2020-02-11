import java.util.Scanner;

public class FirstJavaProgram {

  public static void main(String[] args){
  	Scanner input = new Scanner(System.in);
  	System.out.println("choose an option");
  	System.out.println("-----1");
  	System.out.println("-----2");
  	int number = input.nextInt();
  	if(number==1){
  		for(int i=0; i<=100; i++){
  			 try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
   			System.out.println("******"+i+"******");
  		}
  	}
  	else if (number==2){
  		theinput(args[0]);
  	}
  	else{
  		System.out.print("thats not an option");
  		main(args);
  	}
  }//End of main





  public static void theinput(String word){
  	System.out.println("Your word is: " + word);
  }
}//End of FirstJavaProgram Class