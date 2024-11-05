package cl.ipvg.recuperativon2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button btMostrar;
    EditText etLatitudN1,etLatitudN2,etLatitudN3,etLongitudN1,etLongitudN2,etLongitudN3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btMostrar=(Button) findViewById(R.id.btMostrar);
        Intent intent= new Intent(MainActivity2.this, MapsActivity.class);
        etLatitudN1=(EditText) findViewById(R.id.etLatitudN1);
        etLatitudN2=(EditText) findViewById(R.id.etLatitudN2);
        etLatitudN3=(EditText) findViewById(R.id.etLatitudN3);
        etLongitudN1=(EditText) findViewById(R.id.etLongitudN1);
        etLongitudN2=(EditText) findViewById(R.id.etLongitudN2);
        etLongitudN3=(EditText) findViewById(R.id.etLongitudN3);

        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("LatitudN1",etLatitudN1.getText().toString());
                intent.putExtra("LatitudN2",etLatitudN2.getText().toString());
                intent.putExtra("LatitudN3",etLatitudN3.getText().toString());
                intent.putExtra("LongitudN1",etLongitudN1.getText().toString());
                intent.putExtra("LongitudN2",etLongitudN2.getText().toString());
                intent.putExtra("LongitudN3",etLongitudN3.getText().toString());
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}