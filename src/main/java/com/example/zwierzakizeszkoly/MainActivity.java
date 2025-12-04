package com.example.zwierzakizeszkoly;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

interface Animal {
    void MakeaSound();
    String getName();
}

class Kot implements Animal {
    Context kont;
    TextView text;

    public Kot(Context kont, TextView text) {
        this.kont = kont;
        this.text = text;
    }

    @Override
    public void MakeaSound() {
        text.setText("Miauuuuuu");
        MediaPlayer mp = MediaPlayer.create(kont, R.raw.catsound);
        if (mp != null) {
            mp.start();


        }
    }

    @Override
    public String getName() {
        return "kot";
    }
}

class Pies implements Animal {
    Context kont;
    TextView text;

    public Pies(Context kont, TextView text) {
        this.kont = kont;
        this.text = text;
    }

    @Override
    public void MakeaSound() {
        text.setText("Wooooof!");
        MediaPlayer mp = MediaPlayer.create(kont, R.raw.dogbarking);
        if (mp != null) {
            mp.start();
        }
    }

    @Override
    public String getName() {
        return "pies";
    }
}

class Krowa implements Animal {
    Context kont;
    TextView text;

    public Krowa(Context kont, TextView text) {
        this.kont = kont;
        this.text = text;
    }

    @Override
    public void MakeaSound() {
        text.setText("Muuuuuuuuu");
        MediaPlayer mp = MediaPlayer.create(kont, R.raw.cowmooing);
        if (mp != null) {
            mp.start();
        }
    }

    @Override
    public String getName() {
        return "krowa";
    }
}

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       TextView info = findViewById(R.id.info);
        ImageView kotBtn = findViewById(R.id.kot);
        ImageView piesBtn = findViewById(R.id.pies);
        ImageView krowaBtn = findViewById(R.id.krowa);

        kotBtn.setOnClickListener(v -> {
            Kot k = new Kot(this, info);
            k.MakeaSound();
        });

        piesBtn.setOnClickListener(v -> {
            Pies p = new Pies(this, info);
            p.MakeaSound();
        });

        krowaBtn.setOnClickListener(v -> {
            Krowa k = new Krowa(this, info);
            k.MakeaSound();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
