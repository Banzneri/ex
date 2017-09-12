package model;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Team
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int maxNumOfPlayers;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int currentPlayerCount;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Player[] players;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Team(){
		players = new Player[20];
		currentPlayerCount = 0;
		maxNumOfPlayers = 20;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void setPlayers(Player[] newArr) {
		this.players = newArr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void addPlayer(Player player) {
		if(currentPlayerCount > getPlayers().length - 1) {
			Player[] newArray = new Player[getPlayers().length + 20];
			for(int i = 0; i < getPlayers().length; i++) {
				newArray[i] = getPlayers()[i];
			}
			setPlayers(newArray);
		}
		players[currentPlayerCount] = player;
		currentPlayerCount++;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void removePlayer(int playerNum) {
		if(currentPlayerCount == 0) {
			System.out.println("No players to remove.");
		} else {
			int length = getPlayers().length;
			Player[] newArray = new Player[length];
			int idx = -1;
	
			// Get the index of the element to be removed
			for(int i = 0; i < length; i++) {
				if(players[i].getNumber() == playerNum) {
					idx = i;
					break;
				}
			}
	
			// Copy the players array without the player into a new array, 
			// without changing the size of the array
			if(idx != -1) {
				for(int i = 0; i < length; i++) {
					if(i < idx) {
						newArray[i] = getPlayers()[i];
					} else if(i == idx) { // skips the removed player index
						continue;
					} else {
						newArray[i - 1] = getPlayers()[i];
					}
				}
				setPlayers(newArray);
				currentPlayerCount--;
			} else {
				System.out.println("No such player.");
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Player getPlayer(int playerNum) {
		for(int i = 0; i < getPlayers().length; i++) {
			if(getPlayers()[i].getNumber() == playerNum) {
				return getPlayers()[i];
			}
		}
		System.out.println("No such player.");
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public String toString() {
		String toReturn = "Team: \n";
		for(int i = 0; i < currentPlayerCount; i++) {
			toReturn += "\n" + players[i].toString();
		}
		toReturn += "\nPlayer count: " + currentPlayerCount;
		return toReturn + "\nArray size: " + getPlayers().length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public boolean equals(Team team) {
		return toString().equals(team.toString());
	}

}

