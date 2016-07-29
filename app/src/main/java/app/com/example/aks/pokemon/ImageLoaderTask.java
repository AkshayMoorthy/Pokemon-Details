package app.com.example.aks.pokemon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Akshay on 26-07-2016.
 */
public class ImageLoaderTask extends AsyncTask<String,String,Bitmap> {
    private ImageView imv;
    Bitmap bitmap;
    public ImageLoaderTask(ImageView imv) {
        this.imv = imv;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
            }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bitmap;
        }
    protected void onPostExecute(Bitmap image)
    {

        imv.setImageBitmap(image);
    }

    }
