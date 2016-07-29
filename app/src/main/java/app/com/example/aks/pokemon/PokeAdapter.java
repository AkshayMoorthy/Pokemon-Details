package app.com.example.aks.pokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Akshay on 25-07-2016.
 */
public class PokeAdapter extends BaseAdapter {
    private ArrayList<Object> listPokemon;
    private static Context context;
    private static LayoutInflater inflater;
    private static final int TYPE_PERSON = 0;
    private static final int TYPE_DIVIDER = 1;
    public PokeAdapter(Context context, ArrayList<Object> listPokemon) {
        this.listPokemon = listPokemon;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       this.context=context;
    }


    @Override
    public int getCount() {
        return listPokemon.size();
    }

    @Override
    public Object getItem(int position) {
        return listPokemon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        // TYPE_PERSON and TYPE_DIVIDER
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof Pokemons) {
            return TYPE_PERSON;
        }

        return TYPE_DIVIDER;
    }
    @Override
    public boolean isEnabled(int position) {
        return (getItemViewType(position) == TYPE_PERSON);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_PERSON:
                    convertView = inflater.inflate(R.layout.list_item_pokemon, parent, false);
                    break;
                case TYPE_DIVIDER:
                    convertView = inflater.inflate(R.layout.list_item_type, parent, false);
                    convertView.setBackgroundColor(0xffEDE7F6);
                    break;
            }
        }

        switch (type) {
            case TYPE_PERSON:
                Pokemons pokemon = (Pokemons)getItem(position);
                TextView pname = (TextView)convertView.findViewById(R.id.pname);
                TextView pid = (TextView)convertView.findViewById(R.id.pid);
                TextView turl=(TextView)convertView.findViewById(R.id.url);
                TextView weak=(TextView)convertView.findViewById(R.id.weak);
                ImageView iv=(ImageView)convertView.findViewById(R.id.list_item_icon);
                pname.setText(pokemon.getName());
                pid.setText("#"+pokemon.getAddress());
                String url=pokemon.getImage();
                turl.setText(url);
                weak.setText(pokemon.getWeak().toString());
               // Picasso.with(context).load(String.valueOf(params)).into(imv);
                //new ImageLoaderTask(iv).execute(url);
                Glide.with(context)
                        .load(url)
                        .fitCenter()
                        .crossFade()
                        .into(iv);
                break;
            case TYPE_DIVIDER:
                TextView title = (TextView)convertView.findViewById(R.id.type);
                String titleString = (String)getItem(position);
                title.setText(titleString);
                break;
        }

        return convertView;
    }


}
