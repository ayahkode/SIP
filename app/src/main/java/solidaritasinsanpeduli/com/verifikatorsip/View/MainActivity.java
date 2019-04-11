package solidaritasinsanpeduli.com.verifikatorsip.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import solidaritasinsanpeduli.com.verifikatorsip.Fragment.FragmentInputVerifikasi;
import solidaritasinsanpeduli.com.verifikatorsip.Fragment.FragmentProfileVerifikator;
import solidaritasinsanpeduli.com.verifikatorsip.Fragment.FragmentReportVerifikasi;
import solidaritasinsanpeduli.com.verifikatorsip.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_navigation_product)
    CardView navInputVerifikasi;
    @BindView(R.id.img_navigation_product)
    ImageButton imgInputVerifikasi;
    @BindView(R.id.btn_navigation_order)
    CardView navReportVerifikasi;
    @BindView(R.id.img_navigation_order)
    ImageButton imgReportVerifikasi;
    @BindView(R.id.btn_navigation_cashier)
    CardView navProfileVerifikator;
    @BindView(R.id.img_navigation_cashier)
    ImageButton imgProfileVerifikator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        NavigationModule();

    }

    public void NavigationModule(){

        navInputVerifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, FragmentInputVerifikasi.newInstance());
                transaction.commit();
                imgInputVerifikasi.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                imgReportVerifikasi.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
                imgProfileVerifikator.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

            }
        });

        navReportVerifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, FragmentReportVerifikasi.newInstance());
                transaction.commit();
                imgInputVerifikasi.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
                imgReportVerifikasi.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                imgProfileVerifikator.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
            }
        });

        navProfileVerifikator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, FragmentProfileVerifikator.newInstance());
                transaction.commit();
                imgProfileVerifikator.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                imgInputVerifikasi.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
                imgReportVerifikasi.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, FragmentInputVerifikasi.newInstance());
        transaction.commit();
        imgInputVerifikasi.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        imgReportVerifikasi.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
        imgProfileVerifikator.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
    }
}
