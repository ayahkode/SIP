package solidaritasinsanpeduli.com.verifikatorsip.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import solidaritasinsanpeduli.com.verifikatorsip.Adapter.VerifikasiListAdapter;
import solidaritasinsanpeduli.com.verifikatorsip.Model.VerifikasiModel;
import solidaritasinsanpeduli.com.verifikatorsip.R;
import solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataProfile.ResponseUserProfile;
import solidaritasinsanpeduli.com.verifikatorsip.Response.ResDataVerifikasi.ResponseVerifikasi;

import static android.content.ContentValues.TAG;

public class FragmentProfileVerifikator  extends Fragment {
    @BindView(R.id.progress_user)
    ProgressBar progressBarVerifikasi;
    @BindView(R.id.view_user)
    View viewVerifikasi;


    @BindView(R.id.txt_name_user)
    TextView txtNameUser;
    @BindView(R.id.txt_phone_user)
    TextView txtPhoneUser;
    @BindView(R.id.txt_kota_user)
    TextView txtKotaUser;
    @BindView(R.id.txt_status_user)
    TextView txtStatusUser;
    @BindView(R.id.txt_username_user)
    TextView txtUsername;
    @BindView(R.id.txt_password_user)
    TextView txtPasswordUser;
    @BindView(R.id.view_setting)
    ImageView viewSetting;
    public FragmentProfileVerifikator() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static FragmentProfileVerifikator newInstance() {
        FragmentProfileVerifikator fragment = new FragmentProfileVerifikator();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_verifikator, container, false);
        ButterKnife.bind(this, view);
        AndroidNetworking.initialize(this.getActivity().getApplicationContext());
        getDataVerifikator(1);

        return view;
    }
    public void getDataVerifikator(int id) {
        AndroidNetworking.initialize(getContext());
        AndroidNetworking.get("https://algoritmakopi.com/sip_api/public/getVerifikator/"+id)
                .setTag(this)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(ResponseUserProfile.class, new ParsedRequestListener<ResponseUserProfile>() {
                    @Override
                    public void onResponse(ResponseUserProfile responseUserProfile) {
                        if (responseUserProfile.getResult().size() > 0) {
                            progressBarVerifikasi.setVisibility(View.GONE);
                            viewVerifikasi.setVisibility(View.VISIBLE);
                            txtKotaUser.setText("Kota : " +responseUserProfile.getResult().get(0).getKota());
                            txtNameUser.setText("Nama : " +responseUserProfile.getResult().get(0).getNama());
                            txtStatusUser.setText("Saya Sebagai : "+responseUserProfile.getResult().get(0).getHakAkses());
                            txtPhoneUser.setText("Phone : " +responseUserProfile.getResult().get(0).getNoTelp());

                            txtUsername.setText("Username : " +responseUserProfile.getResult().get(0).getUsername());
                            txtPasswordUser.setText("Password : " +responseUserProfile.getResult().get(0).getPassword());

                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        // handle error
                        Log.d(TAG, "onError: " + anError.toString());
                    }
                });
    }
}
