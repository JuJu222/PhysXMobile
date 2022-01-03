package com.example.physxmobile.views;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GetaranHarmonis#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetaranHarmonis extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GetaranHarmonis() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GetaranHarmonis.
     */
    // TODO: Rename and change types and number of parameters
    public static GetaranHarmonis newInstance(String param1, String param2) {
        GetaranHarmonis fragment = new GetaranHarmonis();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_getaran_harmonis, container, false);

        TextView penjelasangh1 = view.findViewById(R.id.penjelasangh1);
        TextView penjelasangh2 = view.findViewById(R.id.penjelasangh2);
        TextView penjelasangh3 = view.findViewById(R.id.penjelasangh3);
        TextView penjelasangh4 = view.findViewById(R.id.penjelasangh4);
        TextView penjelasangh5 = view.findViewById(R.id.penjelasangh5);
        TextView penjelasangh6 = view.findViewById(R.id.penjelasangh6);
        TextView penjelasangh7 = view.findViewById(R.id.penjelasangh7);

        ImageView gambargh1 = view.findViewById(R.id.gambargh1);
        ImageView gambargh2 = view.findViewById(R.id.gambargh2);
        ImageView gambargh3 = view.findViewById(R.id.gambargh3);
        ImageView gambargh4 = view.findViewById(R.id.gambargh4);
        ImageView gambargh5 = view.findViewById(R.id.gambargh5);
        ImageView gambargh6 = view.findViewById(R.id.gambargh6);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangh1.setText(Html.fromHtml("<p>Getaran Harmonis adalah sebuah benda yang bergerak secara bolak balik (periodik) melalui titik kesetimbangan. Grafik letak partikel ini diartikan sebagai fungsi waktu yang berupa sinus dinyatakan dalam bentuk sinus dan kosinus. Gerak ini juga sering dinamakan sebagai gerak osilasi.</p>\n" +
                    "<p>Gambaran atau contoh dari sistem yang menggunakan prinsip getaran harmonis sendiri misalnya seperti, dawai pada alat musik, gelombang radio, arus listrik AC dan denyut jantung.</p>\n" +
                    "<br/>\n" +
                    "<h3>Syarat-syarat Getaran Harmonis</h3>\n" +
                    "<p>1. Sistem Gerakannya secara periodik atau bolak-balik.</p>\n" +
                    "<p>2. Proses Gerakannya akan selalu melewati kedudukan keseimbangan.</p>\n" +
                    "<p>3. Kemudian pada Percepatan atau gaya yang bekerja yang terdapat pada sebuah benda akan dapat sebanding dengan kedudukan atau simpangan benda.</p>\n" +
                    "<p>4. Kemudian Arah dalam percepatan atau gaya yang bekerja yang ada didalam suatu benda selalu mengarah kedudukan keseimbangan.</p>\n" +
                    "<br/>\n" +
                    "<p>Gerak harmonik sederhana memiliki simpangan, kecepatan, percepatan, dan energi.</p>\n" +
                    "<br/>\n" +
                    "<h3>Simpangan</h3>\n" +
                    "<br/>\n" +
                    "<p>Simpangan getaran harmonik sederhana dapat dianggap sebagai proyeksi partikel yang bergerak melingkar beraturan pada diameter lingkaran.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangh1.setText(Html.fromHtml("<p>Getaran Harmonis adalah sebuah benda yang bergerak secara bolak balik (periodik) melalui titik kesetimbangan. Grafik letak partikel ini diartikan sebagai fungsi waktu yang berupa sinus dinyatakan dalam bentuk sinus dan kosinus. Gerak ini juga sering dinamakan sebagai gerak osilasi.</p>\n" +
                    "<p>Gambaran atau contoh dari sistem yang menggunakan prinsip getaran harmonis sendiri misalnya seperti, dawai pada alat musik, gelombang radio, arus listrik AC dan denyut jantung.</p>\n" +
                    "<br/>\n" +
                    "<h3>Syarat-syarat Getaran Harmonis</h3>\n" +
                    "<p>1. Sistem Gerakannya secara periodik atau bolak-balik.</p>\n" +
                    "<p>2. Proses Gerakannya akan selalu melewati kedudukan keseimbangan.</p>\n" +
                    "<p>3. Kemudian pada Percepatan atau gaya yang bekerja yang terdapat pada sebuah benda akan dapat sebanding dengan kedudukan atau simpangan benda.</p>\n" +
                    "<p>4. Kemudian Arah dalam percepatan atau gaya yang bekerja yang ada didalam suatu benda selalu mengarah kedudukan keseimbangan.</p>\n" +
                    "<br/>\n" +
                    "<p>Gerak harmonik sederhana memiliki simpangan, kecepatan, percepatan, dan energi.</p>\n" +
                    "<br/>\n" +
                    "<h3>Simpangan</h3>\n" +
                    "<br/>\n" +
                    "<p>Simpangan getaran harmonik sederhana dapat dianggap sebagai proyeksi partikel yang bergerak melingkar beraturan pada diameter lingkaran.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangh2.setText(Html.fromHtml("<p>y = simpangan getaran (m)</p>\n" +
                    "<p>ω = kecepatan sudut (rad/s)</p>\n" +
                    "<p>T = periode (s)</p>\n" +
                    "<p>f = frekuensi (Hz)</p>\n" +
                    "<p>t = waktu tempuh (s)</p>\n" +
                    "<p>A = amplitudo/simpangan maksimum (m)</p>\n" +
                    "<br/>\n" +
                    "<h3>Kecepatan</h3>\n" +
                    "<br/>\n" +
                    "<p>Kecepatan merupakan turunan pertama dari posisi. Pada gerak harmonik sederhana, kecepatan diperoleh dari turunan pertama persamaan simpangan. Persamaan kecepatan dapat dijabarkan sebagai berikut.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangh2.setText(Html.fromHtml("<p>y = simpangan getaran (m)</p>\n" +
                    "<p>ω = kecepatan sudut (rad/s)</p>\n" +
                    "<p>T = periode (s)</p>\n" +
                    "<p>f = frekuensi (Hz)</p>\n" +
                    "<p>t = waktu tempuh (s)</p>\n" +
                    "<p>A = amplitudo/simpangan maksimum (m)</p>\n" +
                    "<br/>\n" +
                    "<h3>Kecepatan</h3>\n" +
                    "<br/>\n" +
                    "<p>Kecepatan merupakan turunan pertama dari posisi. Pada gerak harmonik sederhana, kecepatan diperoleh dari turunan pertama persamaan simpangan. Persamaan kecepatan dapat dijabarkan sebagai berikut.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangh3.setText(Html.fromHtml("<h3>Percepatan</h3>\n" +
                    "<p>Percepatan benda yang bergerak harmonik sederhana dapat diperoleh dari turunan pertama persamaan kecepatan atau turunan kedua persamaan simpangan. Persamaan percepatan dapat diperoleh sebagai berikut.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangh3.setText(Html.fromHtml("<h3>Percepatan</h3>\n" +
                    "<p>Percepatan benda yang bergerak harmonik sederhana dapat diperoleh dari turunan pertama persamaan kecepatan atau turunan kedua persamaan simpangan. Persamaan percepatan dapat diperoleh sebagai berikut.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangh4.setText(Html.fromHtml("<p>Simpangan maksimum memiliki nilai yang sama dengan amplitudo (y = A), sehingga percepatan maksimumnya adalah am= – Aw</p>\n" +
                    "<h3>Energi</h3>\n" +
                    "<p>Persamaan energi pada gerak harmonik sederhana meliputi energi kinetik, energi potensial, dan energi mekanik.</p>\n" +
                    "<p>Energi kinetik benda dapat dirumuskan sebagai berikut.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangh4.setText(Html.fromHtml("<p>Simpangan maksimum memiliki nilai yang sama dengan amplitudo (y = A), sehingga percepatan maksimumnya adalah am= – Aw</p>\n" +
                    "<h3>Energi</h3>\n" +
                    "<p>Persamaan energi pada gerak harmonik sederhana meliputi energi kinetik, energi potensial, dan energi mekanik.</p>\n" +
                    "<p>Energi kinetik benda dapat dirumuskan sebagai berikut.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangh5.setText(Html.fromHtml("<p>Energi potensial benda dapat dirumuskan sebagai berikut.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangh5.setText(Html.fromHtml("<p>Energi potensial benda dapat dirumuskan sebagai berikut.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangh6.setText(Html.fromHtml("<p>Sementara itu, energi mekanik adalah penjumlahan dari energi kinetik dan energi potensial.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangh6.setText(Html.fromHtml("<p>Sementara itu, energi mekanik adalah penjumlahan dari energi kinetik dan energi potensial.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangh7.setText(Html.fromHtml("<p>k = nilai ketetapan (N/m)</p>\n" +
                    "<p>ω = kecepatan sudut (rad/s)</p>\n" +
                    "<p>A = amplitudo (m)</p>\n" +
                    "<p>t = waktu tempuh (s)</p>\n" +
                    "<p>Jumlah energi potensial dan energi kinetik benda yang bergerak harmonik sederhana selalu bernilai tetap.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangh7.setText(Html.fromHtml("<p>k = nilai ketetapan (N/m)</p>\n" +
                    "<p>ω = kecepatan sudut (rad/s)</p>\n" +
                    "<p>A = amplitudo (m)</p>\n" +
                    "<p>t = waktu tempuh (s)</p>\n" +
                    "<p>Jumlah energi potensial dan energi kinetik benda yang bergerak harmonik sederhana selalu bernilai tetap.</p>"));
        }

        Glide.with(getContext()).load("https://live.staticflickr.com/65535/49750780716_b7352559b3_z.jpg").into(gambargh1);
        Glide.with(getContext()).load("https://live.staticflickr.com/65535/49750780851_70b9bc60e0_z.jpg").into(gambargh2);
        Glide.with(getContext()).load("https://live.staticflickr.com/65535/49750241518_9cace830d7_z.jpg").into(gambargh3);
        Glide.with(getContext()).load("https://www.flickr.com/photos/185371494@N06/49751109447/in/dateposted-public/").into(gambargh4);
        Glide.with(getContext()).load("https://live.staticflickr.com/65535/49751109517_d8d047c826.jpg").into(gambargh5);
        Glide.with(getContext()).load("https://live.staticflickr.com/65535/49750241633_bc35ff3266_z.jpg").into(gambargh6);

        return view;
    }
}