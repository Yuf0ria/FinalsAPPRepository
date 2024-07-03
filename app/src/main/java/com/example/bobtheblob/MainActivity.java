package com.example.bobtheblob;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //UI
    TextView text1, text2, text3, text4;
    LinearLayout background;
    int page = 1;

    //Status
    ProgressBar HungerBar, HygeineBar, FunBar, EnergyBar;
    int Hunger, Hygeine, Fun, Energy, FunScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //UI Start
        text1 = findViewById(R.id.TextOne);
        text2 = findViewById(R.id.TextTwo);
        text3 = findViewById(R.id.TextThree);
        text4 = findViewById(R.id.TextFour);

        //Background
        background = findViewById(R.id.roomchange);

        text1.setText("Exit");
        text2.setText("Feed Slime");
        text3.setText("Feed Candy");
        text4.setText(">>>");

        //Status Start
        HungerBar = findViewById(R.id.progressBarhunger);
        HygeineBar = findViewById(R.id.progressBarhygiene);
        FunBar = findViewById(R.id.progressBarfun);
        EnergyBar = findViewById(R.id.progressBarenergy);

        Hunger = 30;
        Hygeine = 10;
        Fun = 50;
        Energy = 70;

        HungerBar.setProgress(Hunger);
        HygeineBar.setProgress(Hygeine);
        FunBar.setProgress(Fun);
        EnergyBar.setProgress(Energy);
    }

    //Left Button
    public void ButtonOne(View view) {
        if (page <= 1){
            //Exit to Main Menu
        } else {
            page--;
        }

        //Going through different rooms
        switch (page){
            case 1:
                text1.setText("Exit");
                text2.setText("Feed Slime"); //20
                text3.setText("Feed Candy"); //5
                text4.setText(">>>");

                background.setBackgroundResource(R.drawable.linear_layout_base);
                break;
            case 2:
                text1.setText("<<<");
                text2.setText("Pet"); // 10
                text3.setText("Feather"); // 20
                text4.setText(">>>");

                background.setBackgroundResource(R.drawable.linear_layout_base1);
                break;
            case 3:
                text1.setText("<<<");
                text2.setText("Mold"); // 10
                text3.setText("Powder"); // 20
                text4.setText(">>>");

                background.setBackgroundResource(R.drawable.linear_layout_base2);
                break;
            case 4:
                text1.setText("<<<");
                text2.setText("Music"); //
                text3.setText("Cradle"); //
                text4.setText("Light"); //Changes the brightness of the room

                background.setBackgroundResource(R.drawable.linear_layout_base3);
                break;
        }
    }

    public void ButtonTwo(View view) {
        //Interacting With Slime
        switch (page) {
            case 1:
                //Feed Slime
                Hunger = Hunger + 10;
                Hygeine = Hygeine - 5;

                HungerBar.setProgress(Hunger);
                HygeineBar.setProgress(Hygeine);
                break;
            case 2:
                //Pet
                Hunger = Hunger - 5;
                Hygeine = Hygeine - 2;
                Fun = Fun + 15;
                Energy = Energy - 2;

                HungerBar.setProgress(Hunger);
                HygeineBar.setProgress(Hygeine);
                FunBar.setProgress(Fun);
                EnergyBar.setProgress(Energy);
                break;
            case 3:
                //Mold
                Hygeine = Hygeine + 10;
                Energy = Energy - 5;
                Hunger = Hunger - 1;

                HungerBar.setProgress(Hunger);
                HygeineBar.setProgress(Hygeine);
                EnergyBar.setProgress(Energy);
                break;
            case 4:
                //Music
                Hunger = Hunger - 2;
                Hygeine = Hygeine - 1;
                Fun = Fun + 5;
                Energy = Energy + 5;

                HungerBar.setProgress(Hunger);
                HygeineBar.setProgress(Hygeine);
                FunBar.setProgress(Fun);
                EnergyBar.setProgress(Energy);
                break;
        }

        //Staying at 0
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
    }

    public void ButtonThree(View view) {
        //Interacting With Slime
        switch (page) {
            case 1:
                //Feed Candy
                Hunger = Hunger + 5;
                Hygeine = Hygeine - 7;

                HungerBar.setProgress(Hunger);
                HygeineBar.setProgress(Hygeine);
                break;
            case 2:
                //Feather
                Hunger = Hunger - 10;
                Hygeine = Hygeine - 4;
                Fun = Fun + 20;
                Energy = Energy - 10;

                HungerBar.setProgress(Hunger);
                HygeineBar.setProgress(Hygeine);
                FunBar.setProgress(Fun);
                EnergyBar.setProgress(Energy);
                break;
            case 3:
                //Powder
                Hygeine = Hygeine + 20;
                Energy = Energy - 7;
                Hunger = Hunger - 2;

                HungerBar.setProgress(Hunger);
                HygeineBar.setProgress(Hygeine);
                EnergyBar.setProgress(Energy);

                break;
            case 4:
                //Cradle
                Hunger = Hunger - 2;
                Hygeine = Hygeine - 1;
                Fun = Fun + 7;
                Energy = Energy + 7;

                HungerBar.setProgress(Hunger);
                HygeineBar.setProgress(Hygeine);
                FunBar.setProgress(Fun);
                EnergyBar.setProgress(Energy);
                break;
        }

        //Staying at 0
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
    }

    //Right Button
    public void ButtonFour(View view) {
        if (page >= 4){
            Hunger = 10;
            Hygeine = 10;
            Fun = 10;
            Energy = 100;

            //Dimming the lights. Sleeping Time.
            HungerBar.setProgress(Hunger);
            HygeineBar.setProgress(Hygeine);
            FunBar.setProgress(Fun);
            EnergyBar.setProgress(Energy);
        } else {
            page++;
        }

        //Going through different rooms
        switch (page){
            case 1:
                text1.setText("Exit");
                text2.setText("Feed Slime");
                text3.setText("Feed Candy");
                text4.setText(">>>");

                background.setBackgroundResource(R.drawable.linear_layout_base);
                break;
            case 2:
                text1.setText("<<<");
                text2.setText("Pet");
                text3.setText("Feather");
                text4.setText(">>>");

                background.setBackgroundResource(R.drawable.linear_layout_base1);
                break;
            case 3:
                text1.setText("<<<");
                text2.setText("Mold");
                text3.setText("Powder");
                text4.setText(">>>");

                background.setBackgroundResource(R.drawable.linear_layout_base2);
                break;
            case 4:
                text1.setText("<<<");
                text2.setText("Music");
                text3.setText("Cradle");
                text4.setText("Light");

                background.setBackgroundResource(R.drawable.linear_layout_base3);
                break;
        }
    }
}