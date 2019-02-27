package solidaritasinsanpeduli.com.verifikatorsip.Adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.util.ValueIterator;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;

import java.util.List;

import solidaritasinsanpeduli.com.verifikatorsip.Model.PermohonanModel;
import solidaritasinsanpeduli.com.verifikatorsip.R;
import solidaritasinsanpeduli.com.verifikatorsip.View.LembarVerifikasiActivity;

public class PermohonanAdapter extends RecyclerView.Adapter<PermohonanAdapter.ViewHolder> {
    private List<PermohonanModel> permohonanModelList;
    private int rowLayout;
    private Context context;
    private View view;
    public BottomSheetDialog dialog;


    public PermohonanAdapter(List<PermohonanModel> permohonanModel, int rowLayout, Context context) {
        this.permohonanModelList = permohonanModel;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    @Override
    public PermohonanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_pemohon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.txtKategoriPermohonan.setText(permohonanModelList.get(position).getKategoriPermohonan());
        holder.txtNamaPemohon.setText(String.valueOf(permohonanModelList.get(position).getNamaPemohon()));
        holder.txtTanggalPermohonan.setText(String.valueOf(permohonanModelList.get(position).getTanggal()));

        holder.cvPermohonan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // viewNextInputVerifikator();
                Intent intent = new Intent(context, LembarVerifikasiActivity.class);

                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return permohonanModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtKategoriPermohonan;
        TextView txtNamaPemohon;
        TextView txtTanggalPermohonan;

        CardView cvPermohonan;
        public ViewHolder(View v) {
            super(v);
            txtKategoriPermohonan = (TextView) itemView.findViewById(R.id.txt_kategori_permohonan);
            txtNamaPemohon = (TextView) itemView.findViewById(R.id.txt_nama_pemohon);
            txtTanggalPermohonan = (TextView) itemView.findViewById(R.id.txt_tanggal);
            cvPermohonan = (CardView) itemView.findViewById(R.id.cv_permohonan);
        }
    }

    public void viewNextInputVerifikator() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewCreateProductFragment = layoutInflater.inflate(R.layout.create_next_verifikasi_layout, null);

        AndroidNetworking.initialize(viewCreateProductFragment.getContext().getApplicationContext());

        dialog = new BottomSheetDialog(context);
        dialog.setContentView(viewCreateProductFragment);
        dialog.show();
    }
}
