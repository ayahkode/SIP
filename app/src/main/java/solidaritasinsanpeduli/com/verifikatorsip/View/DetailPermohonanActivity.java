package solidaritasinsanpeduli.com.verifikatorsip.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import solidaritasinsanpeduli.com.verifikatorsip.R;

public class DetailPermohonanActivity extends AppCompatActivity {

    private TextView txtContohLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_permohonan);

        txtContohLayout = (TextView) findViewById(R.id.txt_contoh_layout);

        txtContohLayout.setText("Hallo Kopibian.");
    }
}
