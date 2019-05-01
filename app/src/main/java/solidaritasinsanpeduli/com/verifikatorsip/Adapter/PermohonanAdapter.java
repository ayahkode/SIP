package solidaritasinsanpeduli.com.verifikatorsip.Adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.util.ValueIterator;
import android.net.Uri;
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
import solidaritasinsanpeduli.com.verifikatorsip.View.DetailPermohonanActivity;
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

        holder.txtKategoriPermohonan.setText("Kategori : "+permohonanModelList.get(position).getKategoriPermohonan());
        holder.txtNamaPemohon.setText(String.valueOf("Nama Pemohon : "+permohonanModelList.get(position).getNamaPemohon()));
        holder.txtAlamatPermohonan.setText(String.valueOf("Alamat Pemohon : "+permohonanModelList.get(position).getAlamatPemohon()));
        holder.txtNoTelpPermohonan.setText(String.valueOf("Nomer HP : "+permohonanModelList.get(position).getNtelpPemohon()));

        if (permohonanModelList.get(position).getStatus().equals("1")){
            holder.txtStatusPermohonan.setText("Menunggu verifikasi");
            holder.txtStatusPermohonan.setBackgroundResource(R.drawable.circle_button_blue);
        } else  if (permohonanModelList.get(position).getStatus().equals("0")){
            holder.txtStatusPermohonan.setText("Disetujui");
            holder.txtStatusPermohonan.setBackgroundResource(R.drawable.circle_button_green);
            holder.viewDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // viewNextInputVerifikator();
                    Intent intent = new Intent(context, DetailPermohonanActivity.class);
                    intent.putExtra("idPermohonan", permohonanModelList.get(position).getId());
                    intent.putExtra("idKategory", permohonanModelList.get(position).getKategoriPermohonan());
                    intent.putExtra("alamatPelapor", permohonanModelList.get(position).getAlamatPelapor());
                    intent.putExtra("alamatPemohon", permohonanModelList.get(position).getAlamatPemohon());
                    intent.putExtra("alasanPengajuan", permohonanModelList.get(position).getAlasanPengajuan());
                    intent.putExtra("NamaPelapor", permohonanModelList.get(position).getNamaPelapor());
                    intent.putExtra("namaPemohon", permohonanModelList.get(position).getNamaPemohon());
                    intent.putExtra("telpPemohon", permohonanModelList.get(position).getNtelpPemohon());
                    intent.putExtra("telpPelapor", permohonanModelList.get(position).getTelpPelapor());
                    intent.putExtra("status", permohonanModelList.get(position).getStatus());
                    intent.putExtra("usiaPemohon", permohonanModelList.get(position).getUsiaPemohon());
                    intent.putExtra("tanggal", permohonanModelList.get(position).getTanggal());
                    context.startActivity(intent);
                }
            });
            holder.viewCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // viewNextInputVerifikator();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" +permohonanModelList.get(position).getNtelpPemohon()));
                    context.startActivity(intent);
                }
            });
        } else  if (permohonanModelList.get(position).getStatus().equals("2")){
            holder.cvPermohonan.setVisibility(View.GONE);
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
        TextView txtAlamatPermohonan;
        TextView txtNoTelpPermohonan;
        TextView txtStatusPermohonan;
        View viewCall;
        View viewDetail;

        CardView cvPermohonan;
        public ViewHolder(View v) {
            super(v);
            txtKategoriPermohonan = (TextView) itemView.findViewById(R.id.txt_kategori_permohonan);
            txtNamaPemohon = (TextView) itemView.findViewById(R.id.txt_nama_pemohon);
            txtAlamatPermohonan = (TextView) itemView.findViewById(R.id.txt_alamat_pemohon);
            txtNoTelpPermohonan = (TextView) itemView.findViewById(R.id.txt_notelp_pemohon);
            txtStatusPermohonan = (TextView) itemView.findViewById(R.id.txt_status_permohonan);
            cvPermohonan = (CardView) itemView.findViewById(R.id.cv_permohonan);

            viewCall = (View) itemView.findViewById(R.id.view_call_pemohon);
            viewDetail = (View) itemView.findViewById(R.id.view_view_detail_pemohon);
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
