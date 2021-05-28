package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * a class, which is a list of players
 * @author Java Gods
 * @version 1.0
 */
public class PlayerList implements Serializable
{
  private ArrayList<Player> players;

  /**
   * a constructor with none argument which initialize the players
   */
  public PlayerList()
  {
    this.players = new ArrayList<Player>();
  }

  /**
   * the method add player to the players
   * @param player which is object input that can be added to our playerList
   */
  public void add(Player player)
  {
    players.add(player);
  }
  /**
   * the method remove player to the players
   * @param player which is object input that can be removed from our playerList
   */
  public void remove(Player player)
  {
    players.remove(player);
  }

  /**
   * the method which gets the size of players
   * @return it returns the int of the size of matches
   */

  public int size()
  {
    return players.size();
  }

  /**
   * the method gets the player from a specific index, if it exist.
   * @param index which is a specific location of list
   * @return if player does not exist it returns null, otherwise it return the player.
   */
  public Player get(int index)
  {
    if (index < players.size())
    {
      return players.get(index);
    }
    else
    {
      return null;
    }
  }

  /**
   * the method has a loop which go through it and search for a player by the name, if it the statement is true it will get the player.
   * @param name which is input that we are search for
   * @return it return the player if the loop find it, otherwise it will return null
   */
  public Player get(String name)
  {
    for (int i = 0; i < players.size(); i++)
    {
      Player temp = players.get(i);

      if (temp.getName().equals(name))
      {
        return temp;
      }
    }
    return null;
  }
  /**
   * the method sets/changes a player to a specific index
   * @param index is a location in the list
   * @param player is match to that index
   */
  public void set(int index, Player player)
  {
    players.set(index, player);
  }

  /**
   * the method has a loop which go through the size of players and to parameters which are input,
   * and it checks i objects of each index is equal to input, it return the number of objects which are equal to each other.
   * @param name which is the name of player
   * @param number which is the number of player
   * @return it return int of player if the name and number are equal to our parameter, otherwise it will return nothing.
   */
  public int getIndex(String name, int number)
  {
    for (int i = 0; i < players.size(); i++)
    {
      Player temp = players.get(i);

      if (temp.getName().equals(name) && temp.getNumber() == number)
      {
        return i;
      }
    }
    return -1;
  }

  /**
   * the method will run through the loop and print out all matches
   * @return it will return the string of all players
   */
  public String toString()
  {
    String returnStr = "";
    for (int i = 0; i < players.size(); i++)
    {
      Player temp = players.get(i);

      returnStr += temp + "\n";
    }
    return returnStr;
  }

  //method that checks the number
}
