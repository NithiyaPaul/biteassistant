package com.example.biteassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Suggestion extends AppCompatActivity {
    TextView rec1,rec2,rec3;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        rec1=(TextView)findViewById(R.id.r_one);
        rec2=(TextView)findViewById(R.id.r_two);
        rec3=(TextView)findViewById(R.id.r_three);

        Intent intent=getIntent();
        String item1=intent.getStringExtra("ingredient1");
        String item2=intent.getStringExtra("ingredient2");
        String item3=intent.getStringExtra("ingredient3");

        reff= FirebaseDatabase.getInstance().getReference("recipes");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String re_id=snapshot.child("r_id").getValue().toString();
//                String re_name=snapshot.child("r_name").getValue().toString();
//                rec1.setText(re_id);
//                rec2.setText(re_name);
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    rec1.setText(snapshot1.getKey());


                Toast.makeText(Suggestion.this, snapshot1.getKey(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
