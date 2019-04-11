package solidaritasinsanpeduli.com.verifikatorsip.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;

import butterknife.ButterKnife;
import solidaritasinsanpeduli.com.verifikatorsip.R;

public class FragmentProfileVerifikator  extends Fragment {
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


        return view;
    }

}
