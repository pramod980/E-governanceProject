package com.example.e_governance;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Death_reg extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference Reference;
    private Button button;
    private EditText Dname,Dfullname,Ddob,Ddod,Dbirthregistrationnumber,Ddistrict,Dvdc,Dward,Ddistrictd,Dvdcd,Dwardd,Dcitizen,Dissuedistrict,Dissuedate,Dmother,Dfather,Dgrandfather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_reg);

        auth=FirebaseAuth.getInstance();
        Reference= FirebaseDatabase.getInstance().getReference("Death_Record");



        button=findViewById(R.id.button);
        Dname=findViewById(R.id.Dname);
        Dfullname=findViewById(R.id.Dfullname);
        Ddob=findViewById(R.id.Ddob);
        Ddod=findViewById(R.id.Ddod);
        Dbirthregistrationnumber=findViewById(R.id.Dbirthregistartionnumber);
        Ddistrict=findViewById(R.id.Ddistrict);
        Dvdc=findViewById(R.id.Dvdc);
        Dward=findViewById(R.id.Dvdc);
        Ddistrictd=findViewById(R.id.Ddistrictd);
        Dvdcd=findViewById(R.id.Dvdcd);
        Dwardd=findViewById(R.id.Dvdcd);
        Dcitizen=findViewById(R.id.Dcitizen);
        Dissuedistrict=findViewById(R.id.Dissuedistrict);
        Dissuedate=findViewById(R.id.Dissuedate);
        Dmother=findViewById(R.id.Dmother);
        Dfather=findViewById(R.id.Dmother);
        Dgrandfather=findViewById(R.id.Dgrandfather);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(auth.getCurrentUser()!=null)
                {
                    String dname=Dname.getText().toString();
                    String dfullname=Dfullname.getText().toString();
                    String ddob=Ddob.getText().toString();
                    String ddod=Ddod.getText().toString();
                    String dbirthregistrationnumber=Dbirthregistrationnumber.getText().toString();
                    String ddistrict=Ddistrict.getText().toString();
                    String dvdc=Dvdc.getText().toString();
                    String dward=Dward.getText().toString();
                    String ddistrictd=Ddistrictd.getText().toString();
                    String dvdcd=Dvdcd.getText().toString();
                    String dwardd=Dward.getText().toString();
                    String dcitizen=Dcitizen.getText().toString();
                    String dissuedistrict=Dissuedistrict.getText().toString();
                    String dissuedate=Dissuedate.getText().toString();
                    String dmother=Dmother.getText().toString();
                    String dfather=Dfather.getText().toString();
                    String dgrandfather=Dgrandfather.getText().toString();
                    DeathRecord Dr=new DeathRecord(dname,dfullname,ddob,ddod,dbirthregistrationnumber,ddistrict,dvdc,dward,ddistrictd,dvdcd,dwardd,dcitizen,dissuedistrict,dissuedate,dmother,dfather,dgrandfather);
                    Reference.child(auth.getCurrentUser().getUid()).setValue(Dr).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Death_reg.this, "Data register Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(Death_reg.this, "Data does not register", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    Toast.makeText(Death_reg.this, "Button is clicked successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}