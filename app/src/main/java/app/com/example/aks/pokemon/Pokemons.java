package app.com.example.aks.pokemon;

import org.json.JSONArray;

/**
 * Created by Akshay on 25-07-2016.
 */
public class Pokemons {
    private String pname;
    private String pid;
    private String image;
    private JSONArray weak;
    Pokemons(String pname,String pid,String image,JSONArray weak)
    {
        this.pname=pname;
        this.pid=pid;
        this.image=image;
        this.weak=weak;
    }

    public String getName() {
        return pname;
    }

    public String getAddress() {
        return pid;
    }
    public  String getImage()
    {
        return image;
    }
 public JSONArray getWeak()
 {
     return  weak;
 }
}
