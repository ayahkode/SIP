package solidaritasinsanpeduli.com.verifikatorsip.Adapter;

import android.content.Context;
import android.content.Intent;
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
import solidaritasinsanpeduli.com.verifikatorsip.Model.VerifikasiModel;
import solidaritasinsanpeduli.com.verifikatorsip.R;
import solidaritasinsanpeduli.com.verifikatorsip.View.DetailPermohonanActivity;
import solidaritasinsanpeduli.com.verifikatorsip.View.LembarVerifikasiActivity;

public class VerifikasiListAdapter extends RecyclerView.Adapter<VerifikasiListAdapter.ViewHolder> {
    private List<VerifikasiModel> verifikasiModelList;
    private int rowLayout;
    private Context context;
    private View view;
    public BottomSheetDialog dialog;


    public VerifikasiListAdapter(List<VerifikasiModel> verifikasiModels, int rowLayout, Context context) {
        this.verifikasiModelList = verifikasiModels;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    @Override
    public VerifikasiListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_verifikasi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        if (verifikasiModelList.get(position).getKategoriId().equals("1")){
            holder.txtKategoriVerifikasi.setText("Kategori : KESEHATAN");
        }else  if (verifikasiModelList.get(position).getKategoriId().equals("2")){
            holder.txtKategoriVerifikasi.setText("Kategori : PENDIDIKAN");

        }else  if (verifikasiModelList.get(position).getKategoriId().equals("3")){
            holder.txtKategoriVerifikasi.setText("Kategori : KEBUTUHAN SEHARI-HARI");

        }
        holder.txtNamaVerifikasi.setText(String.valueOf("Nama Pemohon : "+verifikasiModelList.get(position).getNama()));
        holder.txtAlamatVerifikasi.setText(String.valueOf("Alamat Pemohon : "+verifikasiModelList.get(position).getAlamatTempatTinggal()));
        holder.txtNoTelpVerifikasi.setText(String.valueOf("Nomer HP : "+verifikasiModelList.get(position).getNoHp()));

        if (verifikasiModelList.get(position).getStatusVerifikasi().equals("1")){
            holder.txtStatusVerifikasi.setText("Menunggu verifikasi");
            holder.txtStatusVerifikasi.setBackgroundResource(R.drawable.circle_button_blue);
        } else  if (verifikasiModelList.get(position).getStatusVerifikasi().equals("0")){
            holder.txtStatusVerifikasi.setText("Disetujui");
            holder.txtStatusVerifikasi.setBackgroundResource(R.drawable.circle_button_green);
            holder.viewDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // viewNextInputVerifikator();
                   /* Intent intent = new Intent(context, DetailPermohonanActivity.class);
                    intent.putExtra("idPermohonan", verifikasiModelList.get(position).getId());
                    intent.putExtra("idKategory", verifikasiModelList.get(position).getKategoriPermohonan());
                    intent.putExtra("alamatPelapor", verifikasiModelList.get(position).getAlamatPelapor());
                    intent.putExtra("alamatPemohon", verifikasiModelList.get(position).getAlamatPemohon());
                    intent.putExtra("alasanPengajuan", verifikasiModelList.get(position).getAlasanPengajuan());
                    intent.putExtra("NamaPelapor", verifikasiModelList.get(position).getNamaPelapor());
                    intent.putExtra("namaPemohon", verifikasiModelList.get(position).getNamaPemohon());
                    intent.putExtra("telpPemohon", verifikasiModelList.get(position).getNtelpPemohon());
                    intent.putExtra("telpPelapor", verifikasiModelList.get(position).getTelpPelapor());
                    intent.putExtra("status", verifikasiModelList.get(position).getStatus());
                    intent.putExtra("usiaPemohon", verifikasiModelList.get(position).getUsiaPemohon());
                    intent.putExtra("tanggal", verifikasiModelList.get(position).getTanggal());
                    context.startActivity(intent);*/
                }
            });
            holder.viewCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // viewNextInputVerifikator();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" +verifikasiModelList.get(position).getNoHp()));
                    context.startActivity(intent);
                }
            });
        } else  if (verifikasiModelList.get(position).getStatusVerifikasi().equals("2")){
            holder.cvVerifikasi.setVisibility(View.GONE);
            holder.txtStatusVerifikasi.setText("Selesai");
            holder.txtStatusVerifikasi.setBackgroundResource(R.drawable.circle_button_grey);
        } else {

        }

    }


    @Override
    public int getItemCount() {
        return verifikasiModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtKategoriVerifikasi;
        TextView txtNamaVerifikasi;
        TextView txtAlamatVerifikasi;
        TextView txtNoTelpVerifikasi;
        TextView txtStatusVerifikasi;
        View viewCall;
        View viewDetail;

        CardView cvVerifikasi;
        public ViewHolder(View v) {
            super(v);
            txtKategoriVerifikasi = (TextView) itemView.findViewById(R.id.txt_kategori_verifikasi);
            txtNamaVerifikasi= (TextView) itemView.findViewById(R.id.txt_nama_verifikasi);
            txtAlamatVerifikasi = (TextView) itemView.findViewById(R.id.txt_alamat_verifikasi);
            txtNoTelpVerifikasi = (TextView) itemView.findViewById(R.id.txt_notelp_verifikasi);
            txtStatusVerifikasi = (TextView) itemView.findViewById(R.id.txt_status_verifikasi);
            cvVerifikasi = (CardView) itemView.findViewById(R.id.cv_verifikasi);

            viewCall = (View) itemView.findViewById(R.id.view_call_verifikasi);
            viewDetail = (View) itemView.findViewById(R.id.view_view_detail_verifikasi);
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
