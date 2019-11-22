package com.gayatrisoft.jaipurjyotish;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class JyotishAdapter extends RecyclerView.Adapter<JyotishAdapter.MyViewHolder> {

    private List<JyotishItem> GridList;
    Context context;



    public JyotishAdapter(List<JyotishItem> GridList, Context context)
    {
        this.GridList = GridList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvRead,tvHoroscope ;
        public ImageView ivHoroscope;
        public CardView  cvHoroscope;


        public MyViewHolder(View view) {
            super(view);
            tvRead = (TextView) view.findViewById(R.id.tvRead);
            ivHoroscope = (ImageView) view.findViewById(R.id.ivHoroscope);
            tvHoroscope = (TextView) view.findViewById(R.id.tvHoroscope);
            cvHoroscope =(CardView) view.findViewById(R.id.cvHoroscope);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        final JyotishItem grid = GridList.get(position);
        holder.tvHoroscope.setText(grid.getTvHoroscope());
        holder.ivHoroscope.setImageResource(grid.getIvHoroscope());


        holder.cvHoroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   Toast.makeText(context,grid.getTvHoroscope(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Horoscope.class);
                intent.putExtra("name",grid.getTvHoroscope());
               // intent.putExtra("image_position", grid.getTvHoroscope());
                context.startActivity(intent);
            }
        });
    }




    @Override
    public int getItemCount()

    {
        return GridList.size();
    }
}