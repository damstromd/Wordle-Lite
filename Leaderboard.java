import java.util.HashMap;
public class Leaderboard{
  private HashMap<String, Integer> players;
//ask for name which is the key for the hashmap at the end
  public Leaderboard () {
  LeaderBoardState state = LeaderBoardState.restore();
  if (state == null) {
    players = new HashMap<String,Integer>();
  }
  else {
    players = state.scores;
  }
  int round = 1;
    while(round == 1){
      GoodGame g = new GoodGame();
      String name = Utils.inputStr ("What's your name? ");
      players.put(name, g.play());
      state = new LeaderBoardState();
      state.scores = players;
      state.save();
      round = Utils.inputNum("Type \"1\" to play again \nType anything else to quit: ");
      
    }
  
 
  }
  //prints the leaderboard at the end of the game
  public void view(){
    System.out.println("*LEADERBOARD*");
    for(String n: players.keySet()) {
      String key = n.toString();
      String value = players.get(n).toString();
      System.out.println(key + " " + value);
    
      }
  }
  


  

}