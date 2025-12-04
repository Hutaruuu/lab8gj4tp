package com.example.zwierzakizeszkoly;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

class kot implements Animal{

    Context kont;
    public kot(Context kont){
        this.kont = kont;

    }
    @Override
    public void MakeaSound() {



        Toast toast = Toast.makeText(kont,"miauuuuuuuuu",Toast.LENGTH_SHORT);
    toast.show();
    }

    @Override
    public String getName() {
        return "kot";
    }
}


class pies implements Animal{

    Context kont;
    public pies(Context kont){
        this.kont = kont;

    }
    @Override
    public void MakeaSound() {
        Toast toast = Toast.makeText(kont,"wof",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public String getName() {
        return "pies";
    }
}

class krowa implements Animal{

    Context kont;
    public krowa(Context kont){
        this.kont = kont;

    }
    @Override
    public void MakeaSound() {
        Toast toast = Toast.makeText(kont,"muuuuuuuuu",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public String getName() {
        return "krowa";
    }
}




public class MainActivity extends AppCompatActivity {
Context kont ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        kont = this;
        Button kot=findViewById(R.id.kot);
        Button pies=findViewById(R.id.pies);
        Button krowa=findViewById(R.id.krowa);

        kot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("XDD");
                kot k = new kot(kont);
                k.MakeaSound();
            }
        });
        pies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("XDD");
                pies k = new pies(kont);
                k.MakeaSound();
            }
        });

        krowa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("XDD");
                krowa k = new krowa(kont);
                k.MakeaSound();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}