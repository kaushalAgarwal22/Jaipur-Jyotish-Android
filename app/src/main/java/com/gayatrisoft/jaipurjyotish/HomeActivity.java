package com.gayatrisoft.jaipurjyotish;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class HomeActivity extends AppCompatActivity implements ViewPagerEx.OnPageChangeListener, BaseSliderView.OnSliderClickListener, AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    //  private NavigationView nav_view;
    //   private DrawerLayout drawer_layout;
    ImageView ivMenu;
    SliderLayout sliderLayout;
    HashMap<String, Integer> Hash_file_maps;
    TextView tvMarquee, tv_appname;
    //  private ActionBarDrawerToggle t;

    private List<JyotishItem> GridList = new ArrayList<>();
    JyotishAdapter gridAdapter;
    RecyclerView recyclerView;
    FloatingActionButton fab;
    private int mYear;
    private int mMonth;
    private int mDay;
    Date mdate;
    String sdate;
    DatePickerDialog datePickerDialog;
    ImageView ivPlay, ivPause;
    MediaPlayer mp;
    int pause;
    ImageButton imageButton1;
    private int length;
    Boolean flag=false;
    private String MEDIA_PATH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ivPlay = findViewById(R.id.ivPlay);
        ivPause = findViewById(R.id.ivPause);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mp = MediaPlayer.create(this, R.raw.om);
      //  mp.setLooping(true);
        //mp.start();

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                ivPlay.setVisibility(View.GONE);
                ivPause.setVisibility(View.VISIBLE);
                play();



            }
        });

        ivPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pause();

                ivPlay.setVisibility(View.VISIBLE);
                ivPause.setVisibility(View.GONE);

                if(mp.isPlaying())
                    mp.stop();
                 mp = MediaPlayer.create(HomeActivity.this, R.raw.om);

            }
        });


        tv_appname = findViewById(R.id.tv_appname);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/FallingSky.otf");

        tv_appname.setTypeface(custom_font);


        fab = findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        gridAdapter = new JyotishAdapter(GridList, HomeActivity.this);

        recyclerView.setAdapter(gridAdapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                appointmentdialog();
            }
        });


        Hash_file_maps = new HashMap<String, Integer>();
        sliderLayout = (SliderLayout) findViewById(R.id.sliderLayout);

        tvMarquee = findViewById(R.id.tvMarquee);
        tvMarquee.setSelected(true);

        Hash_file_maps = new HashMap<>();

        AddImageUrlFormLocalRes();

        for (String name : Hash_file_maps.keySet()) {

            DefaultSliderView textSliderView = new DefaultSliderView(this);
            textSliderView
                    // .description(name)
                    .image(Hash_file_maps.get(name))
                    // .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);



            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);

        }

        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);

        loadimages();
    }

    public void play() {
        mp.setLooping(true);
        mp.start();


    }

    public void pause() {

        try
        {
            if (mp != null) {
            mp.stop();
            mp.reset();
            }




        }

        catch(NullPointerException  e){

            e.printStackTrace();
        }


    }

    @Override
    protected void onPause() {
        super.onPause();

       mp.pause();
        //stop or pause your music here.
    }

    @Override
    protected void onResume() {
        super.onResume();

     //play();
        // play your music here.
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if(t.onOptionsItemSelected(item))
//            return true;
//
//        return super.onOptionsItemSelected(item);
//    }


    private void appointmentdialog( ) {

        final Dialog dialog = new Dialog(HomeActivity.this);

        dialog.setContentView(R.layout.appointment_layout);

        String[] Appointment = {"Select Appointment type","Skype","Personal","Video","Chat"};
        String[] Time = {"Select time", "10:00 AM- 10:30 AM", "10:30 AM- 11:00 AM", "11:00 AM- 11:30 AM", "11:30 AM-12:00 PM", "4:00 PM- 4:30 PM", "4:30 PM- 5:00 PM", "5:00 PM- 5:30 PM", "5:30 PM- 6:00 PM", "6:00 PM- 6:30 PM", "6:30 PM- 7:00 PM"};

        final Spinner Spinner_Appt_type = (Spinner) dialog.findViewById(R.id.Spinner_Appt_type);
        final Spinner Spinner_Time = (Spinner) dialog.findViewById(R.id.Spinner_Time);
        final TextView etDuration = (TextView) dialog.findViewById(R.id.etDuration);
        final Button btSubmit = (Button) dialog.findViewById(R.id.btBooknow);

        etDuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpendatePicker(etDuration);
            }
        });

        Spinner_Appt_type.setOnItemSelectedListener(this);

        ArrayAdapter ap = new ArrayAdapter(this, R.layout.spinner_item, Appointment);
        ap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        Spinner_Appt_type.setAdapter(ap);

        Spinner_Time.setOnItemSelectedListener(this);

        ArrayAdapter at = new ArrayAdapter(this, R.layout.spinner_item, Time);
        at.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Time.setAdapter(at);
        //Setting the ArrayAdapter data on the Spinner

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stDuration = etDuration.getText().toString();
                final String stSpinner_Appt_type = Spinner_Appt_type.getSelectedItem().toString();
                final String stSpinner_Time = Spinner_Time.getSelectedItem().toString();


                if (stSpinner_Appt_type.equals("Select Appointment type")) {
                    Toast.makeText(HomeActivity.this, "Select Appointment type", Toast.LENGTH_SHORT).show();
                    // Toast.makeText(HomeActivity.this, "Select Appointment type", Toast.LENGTH_SHORT).show();
                } else if (stDuration.isEmpty()) {

                    Toast.makeText(HomeActivity.this, "Select Appointment Date", Toast.LENGTH_SHORT).show();
                } else if (stSpinner_Time.equals("Select time")) {

                    Toast.makeText(HomeActivity.this, "Select Appointment time", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(HomeActivity.this, "Appointment Book ", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }

            }
        });
        dialog.show();


    }


    private void OpendatePicker(final TextView tv) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {

                sdate = selectedDay + "-" + (selectedMonth + 1) + "-" + selectedYear;
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    mdate = df.parse(sdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                SimpleDateFormat simpledateformat = new SimpleDateFormat("dd MMMM yyyy");
//              Date date = new Date(selectedYear, selectedMonth, selectedDay );
                String cDate = simpledateformat.format(mdate);
                tv.setText(cDate);


            }
        }, mYear, mMonth, mDay);

        datePickerDialog.show();

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);


    }

    private void loadimages( ) {

        JyotishItem grid = new JyotishItem("Horoscope", "Read More", R.drawable.horoscpe);
        GridList.add(grid);

        grid = new JyotishItem("Match Making", "Read More", R.drawable.matchmk);
        GridList.add(grid);

        grid = new JyotishItem("Lal kitab", "Read More", R.drawable.lalkitab);
        GridList.add(grid);

        grid = new JyotishItem("Vastu", "Read More", R.drawable.vastu_icon);
        GridList.add(grid);

        grid = new JyotishItem("Plam Reading", "Read More", R.drawable.palmreading);
        GridList.add(grid);

        grid = new JyotishItem("Numerology", "Read More", R.drawable.numero);
        GridList.add(grid);

        grid = new JyotishItem("Pooja", "Read More", R.drawable.pooja);
        GridList.add(grid);

        grid = new JyotishItem("Muhurat", "Read More", R.drawable.muhuratt);
        GridList.add(grid);

        grid = new JyotishItem("Mantra", "Read More", R.drawable.mantraa);
        GridList.add(grid);

        grid = new JyotishItem("Gems that Suits you", "Read More", R.drawable.url);
        GridList.add(grid);

        grid = new JyotishItem("Tarot Card Reading", "Read More", R.drawable.tarotcard);
        GridList.add(grid);

    }

//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//        int id = menuItem.getItemId();
//
//        switch (id) {
//
//            case R.id.Home:
//                Intent i = new Intent(this, HomeActivity.class);
//                startActivity(i);
//                break;
//
//
//            case R.id.Services:
//                Intent in = new Intent(this, ServicesActivity.class);
//                startActivity(in);
//                break;
//
//
//            case R.id.Store:
//                Intent intnt = new Intent(this, Store.class);
//                startActivity(intnt);
//                break;
//
//            case R.id.Success:
//                Intent intent = new Intent(this, SuccessActivity.class);
//                startActivity(intent);
//                break;
//
//            case R.id.Gallery:
//                Intent ic = new Intent(this, GalleryActivity.class);
//                startActivity(ic);
//                break;
//
//            case R.id.Aboutus:
//                Intent d = new Intent(this, AboutusActivity.class);
//                startActivity(d);
//                break;
//
//            case R.id.ContactUs:
//                Intent f = new Intent(this, ContactusActivity.class);
//                startActivity(f);
//                break;
//
//            case R.id.Track:
//                Intent fl = new Intent(this, TrackActivity.class);
//                startActivity(fl);
//                break;
//
//
//        }
//        return false;
//    }

    public void AddImageUrlFormLocalRes( ) {

        Hash_file_maps = new HashMap<>();
        Hash_file_maps.put("Lines to future and Past", R.drawable.sliderimg1);
        Hash_file_maps.put("Business Solutins through Astrologist", R.drawable.sliderimg2);
        Hash_file_maps.put("Get MatchMaking  done with your partner", R.drawable.sliderimg3);
        Hash_file_maps.put("Get your Muhurat predicted by our experts", R.drawable.sliderimage4);
        Hash_file_maps.put("Mantra", R.drawable.sliderimage5);


    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
