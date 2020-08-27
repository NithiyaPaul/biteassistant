package com.example.biteassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button gen;
    EditText item1,item2,item3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gen=(Button)findViewById(R.id.gen);
        item1=(EditText)findViewById(R.id.ing1);
        item2=(EditText)findViewById(R.id.ing2);
        item3=(EditText)findViewById(R.id.ing3);
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=item1.getText().toString();
                String str2=item2.getText().toString();
                String str3=item3.getText().toString();
                Intent intent=new Intent(MainActivity.this,Suggestion.class);
                intent.putExtra("ingredient1",str1);
                intent.putExtra("ingredient2",str2);
                intent.putExtra("ingredient3",str3);
                startActivity(intent);
            }
        });
    }
}
