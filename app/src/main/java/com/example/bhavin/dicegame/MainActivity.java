package com.example.bhavin.dicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView cpu , player;
    ImageView cpu_image , player_image;
    int cpu_points , player_points ;
    Random r;
    boolean end = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpu = (TextView)findViewById(R.id.cpu);
        player = (TextView)findViewById(R.id.player);

        cpu_image =(ImageView)findViewById(R.id.cpu_image);
        player_image =(ImageView)findViewById(R.id.player_image);

        r = new Random();

      player_image.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              int cpu_throw = r.nextInt(6) + 1;
              int player_throw = r.nextInt(6) + 1;

              setCpu_image(cpu_throw);
              setPlayer_image(player_throw);

              if (cpu_throw < player_throw) {
                  player_points++;
              }
              if (cpu_throw > player_throw) {
                  cpu_points++;
              }
              if (cpu_throw == player_throw) {
                  Toast.makeText(MainActivity.this, "DRAW!", Toast.LENGTH_SHORT).show();
              }

              cpu.setText("CPU:" + cpu_points);
              player.setText("PLAYER:" + player_points);

              if(cpu_points == 25)
              {
                  Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                  Toast.makeText(MainActivity.this, "CPU WINS", Toast.LENGTH_SHORT).show();
                  end = true;
                  cpu_points = 0;
                  player_points =0;
                  Toast.makeText(MainActivity.this, "CLICK ON PLAYER DICE TO RESTART!", Toast.LENGTH_SHORT).show();

              }

              if(player_points == 25)
              {
                  Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                  Toast.makeText(MainActivity.this, "PLAYER WINS", Toast.LENGTH_SHORT).show();
                  end = true;
                  cpu_points = 0;
                  player_points =0;
                  Toast.makeText(MainActivity.this, "CLICK ON PLAYER DICE TO RESTART!", Toast.LENGTH_SHORT).show();
              }

              Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
              cpu_image.startAnimation(rotate);
              player_image.startAnimation(rotate);
          }
      });
    }

    public void setCpu_image(int num)
    {
        switch(num)
        {
            case 1 :
                cpu_image.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                cpu_image.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                cpu_image.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                cpu_image.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                cpu_image.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                cpu_image.setImageResource(R.drawable.dice_6);
                break;

        }
    }

    public void setPlayer_image(int num)
    {
        switch(num)
        {
            case 1 :
                player_image.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                player_image.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                player_image.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                player_image.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                player_image.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                player_image.setImageResource(R.drawable.dice_6);
                break;

        }
    }
}
