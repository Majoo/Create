import javax.swing.*;

public class Hello{
	public static void main(String[] args){


		int start = JOptionPane.showConfirmDialog(null, 				//START
		"This is a textbased game by the awesome Danny Lam.\n" 
		+ "I know it's a great game, but don't be sad if you \n" 
		+ "get killed by some random zombies made of bits. \n" 
		+ "Are you ready?", 
		"Zombie Game BETA 1.0.0", 
		JOptionPane.YES_NO_OPTION);

		if (start == 0){
			JOptionPane.showMessageDialog(null, "Great, let's go.");
		}else{
			JOptionPane.showMessageDialog(null, "Okay, noob");
			System.exit(0);
		}

		String name = JOptionPane.showInputDialog					//NAME
		("First of all, what's your lovely name?");
		JOptionPane.showMessageDialog
		(null, "Hi " + name +". This is your story. \n" 
		+ "Let's see how far you'll survive this zombie apocalypse.");
		JOptionPane.showMessageDialog
		(null, "You live alone in an student apartement on the 6th floor in central Gothenburg.");
		JOptionPane.showMessageDialog
		(null, "You wake up in the middle of the night \n" 
		+ "because you heard someone scream in the room next to you." );

		String question1 = JOptionPane.showInputDialog(null, "What do you do? \n" 			//LEVEL 1
		+ "1. Go back to sleep. \n" 
		+ "2. Go to the room next to you.\n" 
		+ "Please answer 1 or 2.");
		int answer1 = Integer.parseInt(question1);
		if(answer1 == 2){
			JOptionPane.showMessageDialog(null, "You chose to go to the room next to you.");
			JOptionPane.showMessageDialog(null, "You get up from your bed and open the door.");
			JOptionPane.showMessageDialog(null, "The room next to you is open. You decide to go in.");
			JOptionPane.showMessageDialog(null, "You find a bloody body on the floor.");
			JOptionPane.showMessageDialog(null, "You decide to check the pulse to see if the person is alive.");
			JOptionPane.showMessageDialog(null, "But there's no beating.");
			JOptionPane.showMessageDialog(null, "You call the police and tell them there's a dead body here."); 
			JOptionPane.showMessageDialog(null, "Right after the phone call, the body starts to move.");

			String question4 = JOptionPane.showInputDialog(null, "What do you do? \n" 
			+ "1. Run back to your room and lock the door. \n" 
			+ "2. See if the person is okay.");
			int answer4 = Integer.parseInt(question4);

			if(answer4 == 1){
				JOptionPane.showMessageDialog(null, "You chose to run back to your room.");
				JOptionPane.showMessageDialog(null, "You run as fast as you can back to your room and lock the door.");
			}else if(answer4 == 2){
				JOptionPane.showMessageDialog(null, "You chose to check if the person is okay.");
				JOptionPane.showMessageDialog(null, "HEY! Wake up. What happened?!");
				JOptionPane.showMessageDialog(null, '"' + "RWEUEGAAAHHRGHHHHH" + '"');

				String question5 = JOptionPane.showInputDialog(null, "What do you do? \n" 
				+ "1. Run back to your room and lock the door. \n" 
				+ "2. Stay with the person.");
				int answer5 = Integer.parseInt(question5);

				if(answer5 == 1){
					JOptionPane.showMessageDialog(null, "You chose to run back to your room.");
					JOptionPane.showMessageDialog(null, "You run as fast as you and lock the door.");

				}else if(answer4 == 2){
					JOptionPane.showMessageDialog(null, "You chose to stay with the person.");
					JOptionPane.showMessageDialog(null, "The person suddenly bites your neck.");
					JOptionPane.showMessageDialog(null, "You got infected. \n" + "GAME OVER.");
					System.out.println("Play again by typing " + '"' + "java ZombieGame" + '"');			//GAMEOVER
					System.exit(0);
				}
			}
				

			
		}else if(answer1 == 1){
			JOptionPane.showMessageDialog(null, "You chose to go back to sleep.");
			JOptionPane.showMessageDialog(null, "2 hours later, you wake up from a nightmare.");
			JOptionPane.showMessageDialog(null, "You can't go back to sleep so you \n" + "put on the TV to see the local news");
			JOptionPane.showMessageDialog(null, "You see some burning buildings on the TV. \n" + "The news reporter talks about an apocalypse of walking deads.");
			JOptionPane.showMessageDialog(null, "Suddenly, there was a scratch on the door.");

			String question2 = JOptionPane.showInputDialog(null, "What do you do? \n" 
			+ "1. Open the door. \n" 
			+ "2. Call the cops.\n" 
			+ "3. Ask who it is.");
			int answer2 = Integer.parseInt(question2);
			if(answer2 == 1){
				JOptionPane.showMessageDialog(null, "You chose to open the door.");
				JOptionPane.showMessageDialog(null, "You get up from the bed and open the door.");
				JOptionPane.showMessageDialog(null, "Everything went so fast and you are now lying on the floor..");
				JOptionPane.showMessageDialog(null, ".. bleeding.");
				JOptionPane.showMessageDialog(null, "You got killed by a zombie. \nGAME OVER.");				//GAMEOVER
				System.out.println("Play again by typing " + '"' + "java ZombieGame" + '"');
				System.exit(0);
			}else if(answer2 == 2){
				JOptionPane.showMessageDialog(null, "You chose to call the cops.");
				JOptionPane.showMessageDialog(null, "*dial 112*");
				JOptionPane.showMessageDialog(null, '"' 
				+ "Hi, who am I talking to?" + '"' 
				+ " asked the police officer.");
				JOptionPane.showMessageDialog(null, name + ". " + "My name is " + name + ".");
				JOptionPane.showMessageDialog(null, '"' + "Okay, " + name + ". What's going on?" + '"');
				JOptionPane.showMessageDialog(null, "Uhm.. I think there's a zombie outside my door.");
				JOptionPane.showMessageDialog(null, '"' + "We're on our way. Stay where you are!" + '"' + " says the officer and put on the phone.");

			}else if(answer2 == 3){
				JOptionPane.showMessageDialog(null, "You chose to ask who it is.");
				JOptionPane.showMessageDialog(null, "HEEY!! WHO'S SCRATCHING ON MY DOOR?!");
				JOptionPane.showMessageDialog(null, "Now there's some even more scratching.");
				JOptionPane.showMessageDialog(null, "It gets more and more violent, and suddenly the door breaks.");
				JOptionPane.showMessageDialog(null, '"' + "RGUHEAHEAAAAAAAAA" + '"');
				JOptionPane.showMessageDialog(null, "Holy mother of Jesus, it's a zombie!");

				String question3 = JOptionPane.showInputDialog(null, "What do you do? \n" 
				+ "1. Get your pillow and fight it. \n" 
				+ "2. Jump through the window.\n"); 
				int answer3 = Integer.parseInt(question3);
				if(answer3 == 1){
					JOptionPane.showMessageDialog(null, "You chose to get your pillow and fight the zombie.");
					JOptionPane.showMessageDialog(null, "Too bad the pillow wasn't a good weapon, so the zombie bites your neck.");
					JOptionPane.showMessageDialog(null, "You got infected. \n" + "GAME OVER.");
					System.out.println("Play again by typing " + '"' + "java ZombieGame" + '"');			//GAMEOVER
					System.exit(0);
				}else if(answer3 == 2){
					JOptionPane.showMessageDialog(null, "You chose to jump through the window.");
					JOptionPane.showMessageDialog(null, "Well.. that was a bad choice.");
					JOptionPane.showMessageDialog(null, "Don't you remember you lived on the 6th floor?");
					JOptionPane.showMessageDialog(null, "You broke your  both legs and then got eaten by several zombies.");
					JOptionPane.showMessageDialog(null, "GAME OVER.");
					System.out.println("Play again by typing " + '"' + "java ZombieGame" + '"');			//GAMEOVER
					System.exit(0);
				}
			}
		
		JOptionPane.showMessageDialog(null, "OH LORD, WHAT SHOULD I DO?!");				//LEVEL 2
		JOptionPane.showMessageDialog(null, "Instead of waiting for the cops, you decide to leave the apartement.");
		
		String question6 = JOptionPane.showInputDialog(null, "What item do you take with you? \n" 
				+ "1. Some CASH so you can spend it on weapons later.\n" 
				+ "2. FOOD, because you obviosly love food.\n"
				+ "3. A damn BASEBALL BAT, because those zombies are going down!\n"
				+ "4. Your new IPAD 4.\n"
				+ "5. A GUN with only two BULLETS left."); 
				int answer6 = Integer.parseInt(question6);


				if(answer6 == 1){
					JOptionPane.showMessageDialog(null, "You took some cash with you.");
					JOptionPane.showMessageDialog(null, "You open the door and run as fast as you can to the exit without facing the zombie.");
					JOptionPane.showMessageDialog(null, "While outside, the Gothenburg city looks like shit.");
					JOptionPane.showMessageDialog(null, "Garbage, exploaded cars, dog feces and dead bodies everywhere on the streets.");
					JOptionPane.showMessageDialog(null, "But no human.");
					JOptionPane.showMessageDialog(null, "Where's everyone?");
					JOptionPane.showMessageDialog(null, "With the cash on you, you decided to buy some stuff on LIDL.");
					JOptionPane.showMessageDialog(null, "But that would be pointless, you could just steal the items instead.");
					String question7 = JOptionPane.showInputDialog(null, "What kind of items do you steal? \n" 
					+ "1. Some badass KNIVES.\n" 
					+ "2. SCISSORS.\n"
					+ "3. Justin Bieber's latest album featuring One Direction."); 

					int answer7 = Integer.parseInt(question7);
					if(answer7 == 1 || answer7 == 2){
						JOptionPane.showMessageDialog(null, "You chose a sharp item as a weapon with you.");




					}else if(answer7 == 3){
						JOptionPane.showMessageDialog(null, "...");
						JOptionPane.showMessageDialog(null, "Seriously?");
						JOptionPane.showMessageDialog(null, "Are you out of your frickin' mind?!");
						JOptionPane.showMessageDialog(null, "I DON'T WANT TO LIVE ON THIS PLANET ANYMORE.");
						JOptionPane.showMessageDialog(null, "GAME OVER.");
						JOptionPane.showMessageDialog(null, "YOU WON. \n" + "The zombies died because of your CD.");
						JOptionPane.showMessageDialog(null, "Now GET OUT.");
						System.out.println("Play again by typing " + '"' + "java ZombieGame" + '"');			//GAMEOVER
						System.exit(0);
					}
						

				}else if(answer6 == 2){
					JOptionPane.showMessageDialog(null, "You took some food with you.");
					JOptionPane.showMessageDialog(null, "You open the door and run as fast as you can to the exit without facing the zombie.");
					JOptionPane.showMessageDialog(null, "While outside, the Gothenburg city looks like shit.");
					JOptionPane.showMessageDialog(null, "Garbage, exploaded cars, dog feces and dead bodies everywhere on the streets.");
					JOptionPane.showMessageDialog(null, "But no human.");
					JOptionPane.showMessageDialog(null, "Where's everyone?");

				}else if(answer6 == 3){
					JOptionPane.showMessageDialog(null, "You took a baseball bat with you.");
					JOptionPane.showMessageDialog(null, "You open the door and run as fast as you can to the exit without facing the zombie.");
					JOptionPane.showMessageDialog(null, "While outside, the Gothenburg city looks like shit.");
					JOptionPane.showMessageDialog(null, "Garbage, exploaded cars, dog feces and dead bodies everywhere on the streets.");
					JOptionPane.showMessageDialog(null, "But no human.");
					JOptionPane.showMessageDialog(null, "Where's everyone?");

				}else if(answer6 == 4){
					JOptionPane.showMessageDialog(null, "...");
					JOptionPane.showMessageDialog(null, "Seriously?");
					JOptionPane.showMessageDialog(null, "An iPad?!");
					JOptionPane.showMessageDialog(null, "It's the apocalypse and instead of surviving - you bring your iPad with you?");
					JOptionPane.showMessageDialog(null, "No wonder the world is going to end..");
					JOptionPane.showMessageDialog(null, "I DON'T WANT TO LIVE ON THIS PLANET ANYMORE.");
					JOptionPane.showMessageDialog(null, "GAME OVER.");
					JOptionPane.showMessageDialog(null, "YOU WON.");
					JOptionPane.showMessageDialog(null, "The zombies died because of your Apple product.");
					JOptionPane.showMessageDialog(null, "Now SHAME ON YOU. Get out.");
					System.out.println("Play again by typing " + '"' + "java ZombieGame" + '"');			//GAMEOVER
					System.exit(0);
						

				}else if(answer6 == 5){
					JOptionPane.showMessageDialog(null, "You brought a gun with you.");
					JOptionPane.showMessageDialog(null, "You open the door and run as fast as you can to the exit without facing the zombie.");
					JOptionPane.showMessageDialog(null, "While outside, the Gothenburg city looks like shit.");
					JOptionPane.showMessageDialog(null, "Garbage, exploaded cars, dog feces and dead bodies everywhere on the streets.");
					JOptionPane.showMessageDialog(null, "But no human.");
					JOptionPane.showMessageDialog(null, "Where's everyone?");


				}
			}
		

		//JOptionPane.showMessageDialog(null, "TO BE CONTINUED ON THE NEXT TENTAPLUGG.");
	}
}
