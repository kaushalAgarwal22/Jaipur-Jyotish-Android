package com.gayatrisoft.jaipurjyotish;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class ScrollingActivity extends AppCompatActivity {

    CollapsingToolbarLayout toolbar_layout;
    Toolbar toolbar;
    ImageView imageView;
    int pos;
    private Menu menu;
    boolean FLAG_COLLAPSED = true;
    // int[] image = {R.drawable.icon1,R.drawable.matchmakingicon,R.drawable.lal_kitab_icon};
     TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(ScrollingActivity.this, "Back", Toast.LENGTH_SHORT).show();


                finish();

             //   intent.putExtra("name",grid.getTvHoroscope());

            }
        });

        toolbar_layout=findViewById(R.id.toolbar_layout);

        Intent intent = getIntent();
        toolbar_layout.setTitle(intent.getStringExtra("name"));


//        HoroscopeItem grid = null;
//
//        intent.putExtra("name",grid.getTvHoroscope());

        tvContent=findViewById(R.id.tvContent);
        imageView = findViewById(R.id.ivHoroscope);

        tvContent.setText(intent.getStringExtra("content"));


        if(intent.getStringExtra("name").equals("Horoscope Making")){

            imageView.setImageResource(R.drawable.horoscpe);

        }

        if(intent.getStringExtra("name").equals("Match Making")){

            imageView.setImageResource(R.drawable.matchmk);

        }

        if(intent.getStringExtra("name").equals("Lal kitab")){

            imageView.setImageResource(R.drawable.lalkitab);

        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    // Collapsed
                    FLAG_COLLAPSED = true;
                } else if (verticalOffset == 0) {
                    FLAG_COLLAPSED = false;
                } else {
                    // Somewhere in between
                }


//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    isShow = true;
//                    //   showOption(R.id.action_info);
//                } else if (isShow) {
//                    isShow = false;
//                    //   hideOption(R.id.action_info);
//                }
            }
        });


    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        this.menu = menu;
//        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
////        hideOption(R.id.action_info);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        /*else if (id == R.id.action_info) {
//            return true;
//        }
//        */
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void hideOption(int id) {
//        MenuItem item = menu.findItem(id);
//       // item.setVisible(false);
//    }
//
//    private void showOption(int id) {
//        MenuItem item = menu.findItem(id);
//        item.setVisible(true);
//    }
}
