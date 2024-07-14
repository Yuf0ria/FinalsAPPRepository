package com.example.bobtheblob;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //UI
    TextView text1, text2, text3, text4, scoretext;
    LinearLayout background;
    int page;
    VideoView video;
    ImageView imagemenu;

    //Status
    ProgressBar HungerBar, HygeineBar, FunBar, EnergyBar;
    int Hunger = 30, Hygeine = 10, Fun = 50, Energy = 70, Score;

    //Did you sleep?
    boolean Enter = false;

    //Music
    MediaPlayer music, click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //I can probably change this actually
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        UIMenu();

        //Music Background
        music = MediaPlayer.create(MainActivity.this,R.raw.babysmileanegl4leon);
        music.setLooping(true);
        music.start();

        //Clicking Sound
        click = MediaPlayer.create(MainActivity.this,R.raw.clickpixabay);
    }

    /////////////
    //MAIN MENU//
    /////////////

    //MENU START
    public void UIMenu(){
        imagemenu = findViewById(R.id.ImageMenu);
        imagemenu.setImageResource(R.drawable.main);
    }

    //Exiting Game
    public void Exit(View view) {
        MainActivity.this.finish();
        System.exit(0);

        click.start();
    }

    //Playing the Game
    public void Play(View view) {
        setContentView(R.layout.activity_main);

        UIStart();

        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.idleone));
        video.start();

        click.start();
    }

    //Intro Page
    public void Intro(View view) {
        imagemenu.setImageResource(R.drawable.intro);

        click.start();
    }

    //Credits Page
    public void Credits(View view) {
        imagemenu.setImageResource(R.drawable.credit);

        click.start();
    }

    //////////////
    //GAME START//
    //////////////

    //UI START
    public void UIStart(){
        //Text UI
        text1 = findViewById(R.id.TextOne);
        text2 = findViewById(R.id.TextTwo);
        text3 = findViewById(R.id.TextThree);
        text4 = findViewById(R.id.TextFour);

        page = 1;
        text1.setText("Exit Game");
        text2.setText("Feed Slime");
        text3.setText("Feed Candy");
        text4.setText("To Playroom");

        //Video UI
        video = findViewById(R.id.videoView);

        //Background
        background = findViewById(R.id.roomchange);

        //Status UI
        HungerBar = findViewById(R.id.progressBarhunger);
        HygeineBar = findViewById(R.id.progressBarhygiene);
        FunBar = findViewById(R.id.progressBarfun);
        EnergyBar = findViewById(R.id.progressBarenergy);

        //Score UI
        scoretext = findViewById(R.id.Score);
        scoretext.setText("Score: " + Score);

        updatingstatus();
    }

    //Left Button
    public void ButtonOne(View view) {
        if (page <= 1){
            //Exit to Main Menu
            setContentView(R.layout.activity_menu);
            UIMenu();
        } else {
            page--;
        }

        //Going through different rooms
        pagechange();

        click.start();
    }

    //Interact One
    public void ButtonTwo(View view) {
        //Interacting With Slime
        switch (page) {
            case 1:
                //Feed Slime
                Hunger = Hunger + 15;
                Hygeine = Hygeine - 5;
                Score = Score + 10;

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.slime));
                video.start();
                break;
            case 2:
                //Tennis
                Hunger = Hunger - 5;
                Hygeine = Hygeine - 2;
                Fun = Fun + 20;
                Energy = Energy - 10;
                Score = Score + 15;

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.tennis));
                video.start();
                break;
            case 3:
                //Mold
                Hygeine = Hygeine + 10;
                Energy = Energy - 5;
                Hunger = Hunger - 1;
                Score = Score + 10;

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.mold));
                video.start();
                break;
            case 4:
                //Music
                Hunger = Hunger - 2;
                Hygeine = Hygeine - 1;
                Fun = Fun + 5;
                Energy = Energy + 5;
                Score = Score + 5;

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.jumping));
                video.start();
                break;
        }

        //Updating Status
        updatingstatus();
        //Staying Zero
        stayzero();
        //Playing clicking sound
        click.start();
    }

    //Interact Two
    public void ButtonThree(View view) {
        //Interacting With Slime
        switch (page) {
            case 1:
                //Feed Candy
                Hunger = Hunger + 10;
                Hygeine = Hygeine - 7;
                Score = Score + 5;

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.candy));
                video.start();
                break;
            case 2:
                //Feather
                Hunger = Hunger - 10;
                Hygeine = Hygeine - 4;
                Fun = Fun + 20;
                Energy = Energy - 10;
                Score = Score + 20;

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.feather));
                video.start();
                break;
            case 3:
                //Powder
                Hygeine = Hygeine + 20;
                Energy = Energy - 7;
                Hunger = Hunger - 2;
                Score = Score + 20;

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.powder));
                video.start();
                break;
            case 4:
                //Pet
                Hunger = Hunger - 2;
                Hygeine = Hygeine - 1;
                Fun = Fun + 7;
                Energy = Energy + 7;
                Score = Score + 5;

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.pet));
                video.start();
                break;
        }

        //Updating Status
        updatingstatus();
        //Staying Zero
        stayzero();
        //Playing clicking sound
        click.start();
    }

    //Right Button
    public void ButtonFour(View view) {

        //Sleeping
        if (page >= 4){
            //Sleeping Time
            Hunger = Hunger - 50;
            Hygeine = Hygeine - 50;
            Fun = Fun - 50;
            Energy = 100;
            Score = Score + 30;

            video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.sleeping));
            video.start();
        } else {
            page++;
        }

        //Updating Status
        updatingstatus();
        //Going through different rooms
        pagechange();
        //Playing clicking sound
        click.start();
    }

    //Going through different rooms
    public void pagechange (){
        switch (page){
            case 1: //To Kitchen
                text1.setText("Exit Game");
                text2.setText("Feed Slime");
                text3.setText("Feed Candy");
                text4.setText("To Playroom");

                background.setBackgroundResource(R.drawable.linear_layout_base);

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.idleone));
                video.start();
                break;
            case 2: //To The Playroom
                text1.setText("To Kitchen");
                text2.setText("Play Tennis");
                text3.setText("Play Feather");
                text4.setText("To Bathroom");

                background.setBackgroundResource(R.drawable.linear_layout_base1);

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.idletwo));
                video.start();
                break;
            case 3: //To The Bathroom
                Enter = false;

                text1.setText("To Playroom");
                text2.setText("Mold Bob");
                text3.setText("Powder Bob");
                text4.setText("To Bedroom");

                background.setBackgroundResource(R.drawable.linear_layout_base2);

                video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.idlethree));
                video.start();
                break;
            case 4: //To The Bedroom
                text1.setText("To Bathroom");
                text2.setText("Play");
                text3.setText("Pet Bob");
                text4.setText("Sleep Time");

                background.setBackgroundResource(R.drawable.linear_layout_base3);

                if (!Enter){
                    video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.idlefour));
                    video.start();

                    Enter = true;
                }
                break;
        }
    }

    //Updating Status
    public void updatingstatus(){
        HungerBar.setProgress(Hunger);
        HygeineBar.setProgress(Hygeine);
        FunBar.setProgress(Fun);
        EnergyBar.setProgress(Energy);

        scoretext.setText("Score: " + Score);
    }

    //Staying at 0
    public void stayzero (){
        //STAY ZERO
        if (Hunger <= 0){
            Hunger = 0;
            HungerBar.setProgress(Hunger);
        }
        if (Hygeine <= 0){
            Hygeine = 0;
            HygeineBar.setProgress(Hygeine);
        }
        if (Fun <= 0){
            Fun = 0;
            FunBar.setProgress(Fun);
        }
        if (Energy <= 0){
            Energy = 0;
            EnergyBar.setProgress(Energy);
        }

        //STAY A HUNDRED
        if (Hunger >= 100){
            Hunger = 100;
            HungerBar.setProgress(Hunger);
        }
        if (Hygeine >= 100){
            Hygeine = 100;
            HygeineBar.setProgress(Hygeine);
        }
        if (Fun >= 100){
            Fun = 100;
            FunBar.setProgress(Fun);
        }
        if (Energy >= 100){
            Energy = 100;
            EnergyBar.setProgress(Energy);
        }
    }

    //Stop Progress
    @Override
    protected void onPause(){
        super.onPause();
        music.pause();
    }

    //Continue Progress
    @Override
    protected void onResume(){
        super.onResume();
        music.start();
        pagechange();
    }
}

//Why are there clips of some guy?
//It's a placeholder.