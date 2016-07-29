package app.com.example.aks.pokemon;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle extras = getActivity().getIntent().getExtras();
        JSONArray jweak=null;
        //Bitmap bmp = (Bitmap) extras.getParcelable("pdimage");//
        // Bundle extras = getActivity().getIntent().getExtras();
        String pdname = extras.getString("pdname");
        String pdid = extras.getString("pdid");
        String url = extras.getString("pdurl");
        String weak=extras.getString("weak");
        try {
            jweak=new JSONArray(weak);
            Log.d("The array:",jweak.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("name:", pdname);
        Log.d("id:", pdid);
        Log.d("url:", url);
        ImageView pdimage = (ImageView) rootView.findViewById(R.id.list_item_detailicon);
        TextView pdidview = (TextView) rootView.findViewById(R.id.pdid);
        TextView pdnameview = (TextView) rootView.findViewById(R.id.pdname);
        TextView pdtext = (TextView) rootView.findViewById(R.id.pddtext);
        Glide.with(getActivity())
                .load(url)
                .fitCenter()
                .crossFade()
                .into(pdimage);
        // pdimage.setImageBitmap(bmp);
        pdnameview.setText(pdname);
        pdidview.setText(pdid);
        pdtext.setText("Pokemons which can defeat " + pdname);

        ArrayList<Object> listDefeat = new ArrayList<>();
        DefeatData data = new DefeatData();
        JSONObject all = null;
        try {
            all = new JSONObject(loadJSONFromAsset((DetailActivity) getActivity()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i=0;i<jweak.length();i++) {
            try {
                if(jweak.getString(i).equals("fire")) {
                    DefeatData.data(listDefeat, all, "fire");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("water")) {
                    DefeatData.data(listDefeat, all, "water");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("grass"))
                DefeatData.data(listDefeat, all, "grass");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("bug"))
                DefeatData.data(listDefeat, all, "bug");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("normal"))
                DefeatData.data(listDefeat, all, "normal");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("electric"))
                DefeatData.data(listDefeat, all, "electric");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("ground"))
                DefeatData.data(listDefeat, all, "ground");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("poison"))
                DefeatData.data(listDefeat, all, "poison");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("fairy"))
                DefeatData.data(listDefeat, all, "fairy");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("fighting"))
                DefeatData.data(listDefeat, all, "fighting");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("rock"))
                DefeatData.data(listDefeat, all, "rock");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("psychic"))
                DefeatData.data(listDefeat, all, "psychic");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("ghost"))
                DefeatData.data(listDefeat, all, "ghost");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("ice"))
                DefeatData.data(listDefeat, all, "ice");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if(jweak.getString(i).equals("dragon"))
                DefeatData.data(listDefeat, all, "dragon");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        //ArrayAdapter<Object> pokeAdapter=new ArrayAdapter<Object>(getActivity(),R.layout.list_item_defeat,R.id.dname,listDefeat);
        ListView listView = (ListView) rootView.findViewById(R.id.listview_defeat);

        //listView.setAdapter(pokeAdapter);

       listView.setAdapter(new defeatAdapter(getActivity(), listDefeat));


        return rootView;
    }
    public String loadJSONFromAsset(DetailActivity activity){
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





