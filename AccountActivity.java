package id.ac.perjalananceritaini.ptsiiachmadsahril;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountActivity extends Activity {
    private Button btnmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        btnmenu = findViewById(R.id.btn_home);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginMain();
            }
        });
    }
    public void openLoginMain(){
        Intent intent = new Intent(this, id.ac.perjalananceritaini.ptsiiachmadsahril.MainActivity2.class);
        startActivity(intent);
    }
}

