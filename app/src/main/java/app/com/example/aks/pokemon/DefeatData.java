package app.com.example.aks.pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Akshay on 26-07-2016.
 */
public class DefeatData {
    JSONObject all;
    public static void data(ArrayList<Object> listPokemon, JSONObject all, String jstring)
    {
        try {
            JSONObject pokemons=all.getJSONObject(jstring);
            JSONArray m_jArry = pokemons.getJSONArray("pokemon");
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject data = m_jArry.getJSONObject(i);
                String dname=data.getString("name");
                String did=data.getString("id");
                String dimage=data.getString("image_url");
                String dtype = jstring.substring(0, 1).toUpperCase() + jstring.substring(1);
                Defeaters poke=new Defeaters(dname,did,dimage,dtype);
                listPokemon.add(poke);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
