package com.gayatrisoft.jaipurjyotish;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class HoroscopeAdapter extends RecyclerView.Adapter<HoroscopeAdapter.MyViewHolder> {

    private List<HoroscopeItem> ImageList;
    Context context;



    public HoroscopeAdapter(List<HoroscopeItem> ImageList, Context context)
    {
        this.ImageList = ImageList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horoscope_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvHoroscope ;
        public ImageView ivHoroscope;
      //  public CardView cvHoroscope;
        public LinearLayout ll_recyclerview;



        public MyViewHolder(View view) {
            super(view);
           // tvRead = (TextView) view.findViewById(R.id.tvRead);
            ivHoroscope = (ImageView) view.findViewById(R.id.ivHoroscope);
            tvHoroscope = (TextView) view.findViewById(R.id.tvHoroscope);
        //    cvHoroscope =(CardView) view.findViewById(R.id.cvHoroscope);
            ll_recyclerview=(LinearLayout)view.findViewById(R.id.ll_recyclerview);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
        final HoroscopeItem grid = ImageList.get(position);
        holder.tvHoroscope.setText(grid.getTvHoroscope());
        holder.ivHoroscope.setImageResource(grid.getIvHoroscope());

        holder.ll_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final HoroscopeItem grid = ImageList.get(position);
                Intent intent = new Intent(context, ScrollingActivity.class);
                intent.putExtra("img",grid.getIvHoroscope());
              //  Log.e(TAG, "onClick: ", );
                intent.putExtra("name",grid.getTvHoroscope());
                intent.putExtra("content", grid.getContent());
                context.startActivity(intent);
                //  ((Activity)context).startActivityForResult(intent,position);
            }
        });
//        holder.cvHoroscope.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(context,grid.getTvHoroscope(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, ScrollingActivity.class);
//                // intent.putExtra("image_position", grid.getTvHoroscope());
//                context.startActivity(intent);
//            }
//        });
    }




    @Override
    public int getItemCount()

    {
        return ImageList.size();
    }

}
