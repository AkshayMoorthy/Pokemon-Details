package app.com.example.aks.pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Akshay on 26-07-2016.
 */
public class Data {
    JSONObject all;
    public void data(ArrayList<Object> listPokemon,JSONObject all,String jstring)
    {
        try {
            String cap = jstring.substring(0, 1).toUpperCase() + jstring.substring(1);
            listPokemon.add(cap);
            JSONObject pokemons=all.getJSONObject(jstring);
            JSONArray m_jArry = pokemons.getJSONArray("pokemon");
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject data = m_jArry.getJSONObject(i);
                String pname=data.getString("name");
                String pid=data.getString("id");
                String image=data.getString("image_url");
                JSONArray weak=data.getJSONArray("weakness");
                Pokemons poke=new Pokemons(pname,pid,image,weak);
                listPokemon.add(poke);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
