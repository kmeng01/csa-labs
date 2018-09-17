/** 
 * The FirstLab class prints the author's name & home address, accompanied by a silly face.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 08/22/2018
 */

import java.util.Scanner;

public class FirstLab 
{
	public static void main(String[] args) 
	{
		// Write the code HERE to print your name and address in boxes
		System.out.println("+====================+");
		System.out.println("|    \"Kevin Meng\"    |");
		System.out.println("+====================+");
		System.out.println("|  1274 Grey De St.  |");
		System.out.println("+====================+");
		System.out.println("| Plano, Texas 75063 |");
		System.out.println("+====================+");
		
		// This calls the bonus method to draw your silly face/picture
		bonus();
	}
	
	/** Draws a silly face or picture
	*/	
	public static void bonus()
	{
		// Write the code HERE to display a silly face or picture
		System.out.println("+--------------------------------------------+");
		System.out.println("|                HAPPY MOON                  |");
		System.out.println("|                ____....                    |");
		System.out.println("|               a#####~:::::::,              |");
		System.out.println("|           a######P\";:::::::::::,           |");
		System.out.println("|        a########:::::::::::::::::,         |");
		System.out.println("|       ########P::::::::::::*:::::::        |");
		System.out.println("|      ########P::::::::::::::::::.:::.      |");
		System.out.println("|     ##### ##P:::::::::::::::::::::::;.     |");
		System.out.println("|    .#### O ##:::::*:::::::::::::::.::;.    |");
		System.out.println("|    ###### #### ::::::::::::::::::.:::::    |");
		System.out.println("|    ########@###,::::::::::::::::::::::;    |");
		System.out.println("|    #########~~~:::::::::::::::*:::.:::;    |");
		System.out.println("|     ##### ##:::::::::::::::::::::::::;     |");
		System.out.println("|      ####a__ay::::::::::::::::::::::;      |");
		System.out.println("|       ########;::::::::::::::::::::;       |");
		System.out.println("|        ########a::::::::::::::::::'        |");
		System.out.println("|          ########.:::::::::*;:::'          |");
		System.out.println("|           `d######a.::::::::::'            |");
		System.out.println("|              `~9#####.::::''               |");
		System.out.println("+--------------------------------------------+");
		
	}
}
