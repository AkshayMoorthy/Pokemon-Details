package app.com.example.aks.pokemon;

/**
 * Created by Akshay on 25-07-2016.
 */
public class Defeaters {
    private String dname;
    private String did;
    private String dimage;
    private String dtype;
    Defeaters(String dname, String did, String dimage,String dtype)
    {
        this.dname=dname;
        this.did=did;
        this.dimage=dimage;
        this.dtype=dtype;
    }

    public String getName() {
        return dname;
    }

    public String getAddress() {
        return did;
    }
    public  String getImage()
    {
        return dimage;
    }
    public  String getType()
    {
        return dtype;
    }

}
