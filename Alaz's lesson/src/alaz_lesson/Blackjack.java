package alaz_lesson;
import java.util.Scanner;
import java.util.Random;

public class Blackjack {
	// TODO Auto-generated method stub
	static int player_1 = 0;
	static int AI_ = 0;
	static Scanner scan = new Scanner(System.in);
	static Random Big = new Random();
	static Scanner myObj = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		player();
		if(player_1<21)
		{
			System.out.println("Activate AI");
			AI();
			if(AI_<21)
			{
				if(compare(player_1,AI_) == player_1)
				{
					System.out.println("You win_");
				}
				if(compare(player_1,AI_) == AI_)
				{
					System.out.println("AI win_");
				}
				if(compare(player_1,AI_) == -1)
				{
					System.out.println("Same score!");
				}
			}
			
		}
		if(player_1 > 21)
		{
			System.out.println("AI won");
		}
		
	}
	
	
	//general tool
	public static int hit (int original)
	{
		int number = 1 + Big.nextInt(10);
		original = original + number;
		System.out.println("Receive card:" + number + ". Total: "+original);
		return original;
	}
	public static int compare (int num1, int num2)
	{
		if(num1 < num2)
		{
			return num2;
		}
		if(num1>num2)
		{
			return num1;
		}
		if(num1 == num2)
		{
			return -1;
		}
			return 0;
	}
	
	//player 
	public static void player ()
	{
		
		player_1 = hit(player_1);
		player_1 = hit(player_1);
		
		System.out.println("Player's total is: "+ player_1);
		player_1 = manual(player_1);
	}	
	
	public static int manual(int original)
	{
		while(original <21)
		{
			System.out.println("Would you like to hit?");
			boolean answer = myObj.nextBoolean();
			if(answer == true)
			{
				original = hit(original);
				System.out.println("Player's total is: " + original);
			}
			if(answer == false)
			{
				System.out.println("Player's end result is: "+ original);
				return original;
			}
		}
		if(original == 21)
		{
			System.out.println("You win!");
			return original;
		}
		if(original > 21)
		{
			System.out.println("You lost.");
			return original;
		}
		return original;
	}
	
	
	
	//AI
	public static void AI ()
	{
		
		AI_ = hit(AI_);
		AI_ = hit(AI_);
		
		System.out.println("Player's total is: "+ player_1);
		AI_ = machine(AI_);
	}	
	public static int machine(int original)
	{
		while(original <21)
		{
			System.out.println("AI is deciding...");
			if(original < 17)
			{
				original = hit(original);
				System.out.println("AI total is: " + original);
			}
			if(original>=17 && original<21)
			{
				return original;
			}
		}
		if(original == 21)
		{
			System.out.println("AI win!");
			return original;
		}
		if(original > 21)
		{
			System.out.println("AI lost.");
			return original;
		}
		return original;
	}

		

}
