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
public class defeatAdapter extends BaseAdapter {
    private ArrayList<Object> listDefeat;
    private static Context context;
    private static LayoutInflater inflater;
    private static final int TYPE_PERSON = 0;
    private static final int TYPE_DIVIDER = 1;

    public defeatAdapter(Context context, ArrayList<Object> listDefeat) {
        this.listDefeat = listDefeat;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }


    @Override
    public int getCount() {
        return listDefeat.size();
    }

    @Override
    public Object getItem(int position) {
        return listDefeat.get(position);
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
        if (getItem(position) instanceof Defeaters) {
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

        convertView = inflater.inflate(R.layout.list_item_defeat, parent, false);
        Defeaters defeaters = (Defeaters) getItem(position);
        TextView dname = (TextView) convertView.findViewById(R.id.dname);
        TextView did = (TextView) convertView.findViewById(R.id.did);
        TextView dtype = (TextView) convertView.findViewById(R.id.dtype);
        ImageView iv = (ImageView) convertView.findViewById(R.id.list_item_defeaticon);
        dname.setText(defeaters.getName());
        did.setText("#" + defeaters.getAddress());
        dtype.setText(defeaters.getType());
        String url = defeaters.getImage();
        // Picasso.with(context).load(String.valueOf(params)).into(imv);
        //new ImageLoaderTask(iv).execute(url);
        Glide.with(context)
                .load(url)
                .fitCenter()
                .crossFade()
                .into(iv);
        return convertView;
    }


}
