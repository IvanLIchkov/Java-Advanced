package ExamFeb2020.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> players;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.players=new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        if (this.players.size()<this.capacity){
            players.add(player);
        }
    }
    public boolean removePlayer(String name){
        if (players.removeIf(p->p.getName().equals(name))){
            return true;
        }
        return false;
    }
    public void promotePlayer(String name){
        Player player=players.stream()
                .filter(p->p.getName().equals(name))
                .findFirst()
                .orElse(null);
        player.setRank("Member");
    }
    public void demotePlayer(String name){
        Player player=players.stream()
                .filter(p->p.getName().equals(name))
                .findFirst()
                .orElse(null);
        player.setRank("Trial");
    }
    public Player[] kickPlayersByClass(String clazz){
        List<Player> kickedPlayers=new ArrayList<>();
                players.stream()
                .filter(p->p.getClazz().equals(clazz))
                .forEach(kickedPlayers::add);

        players.removeAll(kickedPlayers);
        Player[] output=kickedPlayers.toArray(new Player[0]);
        return output;
    }
    public int count(){
        return this.players.size();
    }
    public String report(){
        StringBuilder output=new StringBuilder();
        output.append(String.format("Players in the guild: %s:%n",this.name));
        players.forEach(p->{
                    output.append(String.format("%s%n",p.toString()));
                });
        return String.valueOf(output);
    }
}
