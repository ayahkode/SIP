package solidaritasinsanpeduli.com.verifikatorsip.Adapter;

import android.content.Context;
import android.content.Intent;
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

public class VerifikasiListAdapter extends RecyclerView.Adapter<VerifikasiListAdapter.ViewHolder> {
    private List<PermohonanModel> permohonanModelList;
    private int rowLayout;
    private Context context;
    private View view;
    public BottomSheetDialog dialog;


    public VerifikasiListAdapter(List<PermohonanModel> permohonanModel, int rowLayout, Context context) {
        this.permohonanModelList = permohonanModel;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    @Override
    public VerifikasiListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_pemohon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.txtKategoriPermohonan.setText("Kategori : "+permohonanModelList.get(position).getKategoriPermohonan());
        holder.txtNamaPemohon.setText(String.valueOf(permohonanModelList.get(position).getNamaPemohon()));
        holder.txtTanggalPermohonan.setText(String.valueOf(permohonanModelList.get(position).getTanggal()));

        if (permohonanModelList.get(position).getStatus().equals("1")){
            holder.txtStatusPermohonan.setText("Menunggu verifikasi");
            holder.txtStatusPermohonan.setBackgroundResource(R.drawable.circle_button_blue);
        } else  if (permohonanModelList.get(position).getStatus().equals("0")){
            holder.txtStatusPermohonan.setText("Disetujui");
            holder.txtStatusPermohonan.setBackgroundResource(R.drawable.circle_button_green);
            holder.cvPermohonan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // viewNextInputVerifikator();
                    Intent intent = new Intent(context, LembarVerifikasiActivity.class);
                    intent.putExtra("idPermohonan", permohonanModelList.get(position).getId());
                    intent.putExtra("idKategory", permohonanModelList.get(position).getKategoriPermohonan());
                    context.startActivity(intent);
                }
            });
        } else  if (permohonanModelList.get(position).getStatus().equals("2")){
            holder.txtStatusPermohonan.setText("Selesai");
            holder.txtStatusPermohonan.setBackgroundResource(R.drawable.circle_button_grey);
        } else {

        }

    }


    @Override
    public int getItemCount() {
        return permohonanModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtKategoriPermohonan;
        TextView txtNamaPemohon;
        TextView txtTanggalPermohonan;
        TextView txtStatusPermohonan;

        CardView cvPermohonan;
        public ViewHolder(View v) {
            super(v);
            txtKategoriPermohonan = (TextView) itemView.findViewById(R.id.txt_kategori_permohonan);
            txtNamaPemohon = (TextView) itemView.findViewById(R.id.txt_nama_pemohon);
            txtTanggalPermohonan = (TextView) itemView.findViewById(R.id.txt_tanggal);
            txtStatusPermohonan = (TextView) itemView.findViewById(R.id.txt_status_permohonan);
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
