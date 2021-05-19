import java.util.ArrayList;

public class Player
{
  private String name;
  private int number, benchedInARow;
  private ArrayList<String> positions;
  private ArrayList<Unavailability> unavailabilities;

  public Player(String name, int number, String position)
  {
    this.name = name;
    this.number = number;
    positions = new ArrayList<String>();
    positions.add(position);
    unavailabilities=new ArrayList<Unavailability>();
  }

  public String getName()
  {
    return name;
  }

  public int getNumber()
  {
    return number;
  }

  public void setNumber(int number)
  {
    this.number = number;
  }

  public void addPosition(String position)
  {
    positions.add(position);
  }

  public void removePosition(String position)
  {
    if (positions.contains(position))
    {
      positions.remove(position);
    }
  }
  public boolean isSuspended(){
    if(unavailabilities.get((unavailabilities.size()-1)).getType().equals("Suspended")){
      return true;
    }
    else{
      return false;
    }
  }

  public void addUnavailability(Unavailability unavailability){
    unavailabilities.add(unavailability);
  }
  public void removeUnavailability(Unavailability unavailability){
    unavailabilities.remove(unavailability);
  }
  public ArrayList<Unavailability> getAllUnavailabilities(){
    return unavailabilities;
  }

  public ArrayList<String > getPositions(){
    return positions;
  }

  public String getPosition(int index){
    return positions.get(index);
  }
  public Player copy(){
    return new Player(name,number,positions.get(0));
  }
  public boolean equals(Object obj){
    if(!(obj instanceof Player)){
      return false;
    }
    else{
      Player other=(Player)obj;
      return name.equals(other.name)&&number==other.number&& positions.equals(other.positions);
    }
  }
  public String toString(){
    return "name: "+name+" number: "+number+" positions: "+positions;
  }


}
