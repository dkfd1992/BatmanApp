package py.edu.drakefor.op2final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by LUIS on 02/11/2016.
 */
public class BatmanAdapter extends BaseAdapter{

    private List<Movie> batmen;
    private Context context;

    public BatmanAdapter(List<Movie> batmen, Context context){
        this.batmen = batmen;
        this.context = context;
    }


    @Override
    public int getCount() {return batmen.size();}



    @Override
    public Object getItem(int position) {return batmen.get(position);}


    @Override
    public long getItemId(int position) {return  batmen.get(position).getId();}

    @Override
    public View getView(int position, View convetView, ViewGroup parent) {
        View view = convetView;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.tem_movie_layout,null);
        }
        Movie b = this.batmen.get(position);

        TextView TextViewbatman = (TextView) view.findViewById(R.id.textViewTitulo);
        TextView TextViewaño = (TextView) view.findViewById(R.id.textViewAño);
        TextView TextViewtipo = (TextView) view.findViewById(R.id.textViewTipo);
        ImageView  ImageViewPoster = (ImageView) view.findViewById(R.id.imageViewBatman);


        TextViewbatman.setText(b.getTitle());
        TextViewaño.setText(b.getYear());
        TextViewtipo.setText(b.getType());

        Picasso.with(this.context).load(b.getPoster()).into(ImageViewPoster);


        return  view;
    }



}
