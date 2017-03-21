package fr.esilv.s8.finalgradedlab.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.esilv.s8.finalgradedlab.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button submitButton = (Button) findViewById(R.id.submitButton) ;

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = ((EditText) findViewById(R.id.searchText)).getText().toString();
                Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
                intent.putExtra("Search", searchText);
                startActivityForResult(intent,456);
            }
        });
    }
}
