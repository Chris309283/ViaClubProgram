package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerList implements Serializable
{
  private ArrayList<Player> players;

  public PlayerList()
  {
    this.players = new ArrayList<Player>();
  }

  public void add(Player player)
  {
    players.add(player);
  }

  public void remove(Player player)
  {
    players.remove(player);
  }

  public int size()
  {
    return players.size();
  }

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

  public void set(int index, Player player)
  {
    players.set(index, player);
  }

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
