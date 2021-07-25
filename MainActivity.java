package id.ac.perjalananceritaini.ptsiiachmadsahril;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonsave;
    private Button buttoncancel;
    private TextView textViewid, textViewnama, textViewNIK, textViewemail;

    private IntentIntegrator qrScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonsave = (Button) findViewById(R.id.buttonSave);
        textViewid = (TextView) findViewById(R.id.textViewid);
        textViewnama = (TextView) findViewById(R.id.textViewnama);
        textViewNIK = (TextView) findViewById(R.id.textViewNIK);
        textViewemail = (TextView) findViewById(R.id.textViewemail);

        qrScan = new IntentIntegrator(this);

        buttonsave.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {

            if (result.getContents() == null) {
                Toast.makeText(this, "Hasil SCAN tidak ada", Toast.LENGTH_LONG).show();
            } else {
                try {

                    JSONObject obj = new JSONObject(result.getContents());

                    textViewid.setText(obj.getString("id"));
                    textViewnama.setText(obj.getString("nama"));
                    textViewNIK.setText(obj.getString("NIK"));
                    textViewemail.setText(obj.getString("email"));
                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onClick(View view) {

        qrScan.initiateScan();
    }

}
