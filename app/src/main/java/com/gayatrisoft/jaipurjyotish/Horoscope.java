package com.gayatrisoft.jaipurjyotish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Horoscope extends AppCompatActivity {

    private List<HoroscopeItem> ImageList = new ArrayList<>();
    HoroscopeAdapter gridAdapter;
    RecyclerView recyclerView;
    //ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

       // ivBack=findViewById(R.id.ivBack);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ActivityUtils.setActionBarColor(this, R.color.colorPrimary);
        recyclerView=findViewById(R.id.recycler_view);

        Intent intent = getIntent();

        getSupportActionBar().setTitle(intent.getStringExtra("name"));
//       if(intent.getStringExtra("name").equals("Horoscope")){
//
//
//
//       }

//        if(intent.getStringExtra("name").equals("Match Making")){
//
//            getSupportActionBar().setTitle("Match Making");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Match Making")){
//
//            getSupportActionBar().setTitle("Match Making");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Lal kitab")){
//
//            getSupportActionBar().setTitle("Lal Kitab");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Vastu")){
//
//            getSupportActionBar().setTitle("Vastu");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Plam Reading")){
//
//            getSupportActionBar().setTitle("Plam Reading");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Numerology")){
//
//            getSupportActionBar().setTitle("Numerology");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Pooja")){
//
//            getSupportActionBar().setTitle("Pooja");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Muhurat")){
//
//            getSupportActionBar().setTitle("Muhurat");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Mantra")){
//
//            getSupportActionBar().setTitle("Mantra");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Gems that Suits you")){
//
//            getSupportActionBar().setTitle("Gems that Suits you");
//
//        }
//
//        if(intent.getStringExtra("name").equals("Tarot Card Reading")){
//
//            getSupportActionBar().setTitle("Tarot Card Reading");
//
//        }
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        gridAdapter = new HoroscopeAdapter(ImageList, Horoscope.this);

        recyclerView.setAdapter(gridAdapter);
        loadimages();
//
//        ivBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(Horoscope.this,HomeActivity.class);
//                startActivity(i);
//                finish();
//
//            }
//        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

     private void loadimages(){

         HoroscopeItem grid = new HoroscopeItem("Horoscope Making ",  R.drawable.horoscpe,"Kundli is a term for Horoscope or Birth chart in English. A horoscope/janampatri is abasic tool for making astrological forecasts. Kundli represents position of planet atspecific time as seen from a specific place. In other words, Kundli is pictorialrepresentation of planets in heaven at the time of birth. An astrologer uses Janam Kundli (Horoscope casted for the time of birth) or Prashna Kundli (Horoscope casted for the time of query) as the basic of his/ her prediction.Get detailed JANAM KUNDALI by just giving your birth details With Acharya Ji, you will get your Ascendant, Moon sign and Nakshatra predictions. Get to know all about your Horoscope Be happier, healthier, and stay motivated with your wellness horoscopes. Get a report of what you can expect in your personal health realm, plus advice on how to feel and look your best!IIf you are feeling restricted and suffocated in your career? Or, is your business bringing you plenty of stress? Ask us! Do you dream of ultimate Career Suc");
         ImageList.add(grid);

         grid = new HoroscopeItem("Match Making",  R.drawable.matchmk,"Marriage is the very important step of life which play decisive factor in making our life blissful or dreadful. So, it is necessary to choose life partner after consideration. Ordinary person judge the person's character on the basis of his look, way of talking, intelligence level and other behavioral characteristics. These factors contribute highly in taking the right decision for marriage but right decision for marriage cannot be taken without knowing the exact position of planets in birth chart of both boy and girl. Chances for the success of marriage are estimated on the basis of gained points after the birth chart matching of boy and girl. Horoscope Matching is the match-making module based on the traditional system of finding the possible compatibility between a couple for marriage. Using this module/system, one can predict whether the couple will lead a healthy life and have no problems.");
         ImageList.add(grid);

         grid = new HoroscopeItem("Lal kitab",  R.drawable.lalkitab,"Lal Kitab is magical remedies are here to put a full stop to all your troubles. Have you ever wondered what your life would be sans all the trouble, anxiety and tension? Sounds like a wild thought.Lal kitab predictions are popular since the time immemorial. As, Astrologer Arun Sharma are providing Lal Kitab predictions . This precise method works on the basis of position of planet in twelve houses. You will get the complete chart about your birth, remedies and other effective prescriptions by the Acharya Ji.");
         ImageList.add(grid);

     }

}
