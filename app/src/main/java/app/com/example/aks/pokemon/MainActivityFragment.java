package app.com.example.aks.pokemon;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_main, container, false);
        ArrayList<Object> listPokemon=new ArrayList<>();
        Data data=new Data();
        JSONObject all=null;
        try {
            all=new JSONObject(loadJSONFromAsset((MainActivity) getActivity()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        data.data(listPokemon, all, "fire");
        data.data(listPokemon,all,"water");
        data.data(listPokemon,all,"grass");
        data.data(listPokemon,all,"bug");
        data.data(listPokemon,all,"normal");
        data.data(listPokemon,all,"electric");
        data.data(listPokemon,all,"ground");
        data.data(listPokemon,all,"poison");
        data.data(listPokemon,all,"fairy");
        data.data(listPokemon,all,"fighting");
        data.data(listPokemon,all,"rock");
        data.data(listPokemon,all,"psychic");
        data.data(listPokemon,all,"ghost");
        data.data(listPokemon,all,"ice");
        data.data(listPokemon,all,"dragon");
        //ArrayAdapter<Object> pokeAdapter=new ArrayAdapter<Object>(getActivity(),R.layout.list_item_pokemon,R.id.pname,listPokemon);
        final ListView listView=(ListView)rootView.findViewById(R.id.listview_pokemon);
        //listView.setAdapter(pokeAdapter);

        listView.setAdapter(new PokeAdapter(getActivity(), listPokemon));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pdname = ((TextView) view.findViewById(R.id.pname)).getText().toString();
                String pdid = ((TextView) view.findViewById(R.id.pid)).getText().toString();
                ImageView pdimage = ((ImageView) view.findViewById(R.id.list_item_icon));
                String weak=((TextView) view.findViewById(R.id.weak)).getText().toString();
                // GlideBitmapDrawable drawable = (GlideBitmapDrawable)pdimage.getDrawable();
                // Bitmap bmp = drawable.getBitmap();
                /*pdimage.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
                pdimage.buildDrawingCache();
                Bitmap bmp=pdimage.getDrawingCache();*/
                String url = ((TextView) view.findViewById(R.id.url)).getText().toString();
                Intent intent = new Intent((MainActivity) getActivity(), DetailActivity.class);
                Bundle extras = new Bundle();
                //extras.putParcelable("pdimage",bmp);
                extras.putString("pdname", pdname);
                extras.putString("pdid", pdid);
                extras.putString("pdurl", url);
                extras.putString("weak",weak);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        return rootView;
    }

    public String loadJSONFromAsset(MainActivity activity){
        String json = null;
        try {
            InputStream is = activity.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


}
