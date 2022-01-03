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
 * Use the {@link GerakLurus#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GerakLurus extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GerakLurus() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GerakLurus.
     */
    // TODO: Rename and change types and number of parameters
    public static GerakLurus newInstance(String param1, String param2) {
        GerakLurus fragment = new GerakLurus();
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
        View view = inflater.inflate(R.layout.fragment_gerak_lurus, container, false);

        TextView penjelasangl1 = view.findViewById(R.id.penjelasanmdi1);
        TextView penjelasangl2 = view.findViewById(R.id.penjelasangl2);
        TextView penjelasangl3 = view.findViewById(R.id.penjelasangl3);
        TextView penjelasangl4 = view.findViewById(R.id.penjelasangl4);
        TextView penjelasangl5 = view.findViewById(R.id.penjelasangl5);
        TextView penjelasangl6 = view.findViewById(R.id.penjelasangl6);

        ImageView gambargl1 = view.findViewById(R.id.gambargl1);
        ImageView gambargl2 = view.findViewById(R.id.gambargl2);
        ImageView gambargl3 = view.findViewById(R.id.gambargl3);
        ImageView gambargl4 = view.findViewById(R.id.gambargl4);
        ImageView gambargl5 = view.findViewById(R.id.gambargl5);
        ImageView gambargl6 = view.findViewById(R.id.gambargl6);
        ImageView gambargl7 = view.findViewById(R.id.gambargl7);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangl1.setText(Html.fromHtml("<p>Gerak adalah <span class=\"fw-bolder\">perubahan kedudukan suatu benda dari posisi awal</span>.</p>\n" +
                    "<p>Benda dikatakan bergerak ketika benda mengalami perpindahan atau menempuh suatu jarak tertentu.</p>\n" +
                    "<p>Berdasarkan lintasannya, gerak terbagi menjadi <span class=\"fw-bolder\">3 jenis</span>, yaitu <span class=\"fw-bolder\">gerak lurus, gerak melingkar, dan gerak melengkung (parabola).</span></p>\n" +
                    "<p class=\"fw-bolder\">Benda yang bergerak pada lintasan lurus disebut gerak lurus.</p>\n" +
                    "<p>Gerak mengenal istilah jarak dan perpindahan.</p>\n" +
                    "<p>Jarak adalah panjang lintasan yang ditempuh benda tanpa memperhatikan arahnya.</p>\n" +
                    "<p>Sementara itu, perpindahan didefinisikan sebagai panjang lintasan, namun memperhatikan arah atau kedudukan awal dan akhir benda tersebut.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangl1.setText(Html.fromHtml("<p>Gerak adalah <span class=\"fw-bolder\">perubahan kedudukan suatu benda dari posisi awal</span>.</p>\n" +
                    "<p>Benda dikatakan bergerak ketika benda mengalami perpindahan atau menempuh suatu jarak tertentu.</p>\n" +
                    "<p>Berdasarkan lintasannya, gerak terbagi menjadi <span class=\"fw-bolder\">3 jenis</span>, yaitu <span class=\"fw-bolder\">gerak lurus, gerak melingkar, dan gerak melengkung (parabola).</span></p>\n" +
                    "<p class=\"fw-bolder\">Benda yang bergerak pada lintasan lurus disebut gerak lurus.</p>\n" +
                    "<p>Gerak mengenal istilah jarak dan perpindahan.</p>\n" +
                    "<p>Jarak adalah panjang lintasan yang ditempuh benda tanpa memperhatikan arahnya.</p>\n" +
                    "<p>Sementara itu, perpindahan didefinisikan sebagai panjang lintasan, namun memperhatikan arah atau kedudukan awal dan akhir benda tersebut.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangl2.setText(Html.fromHtml("<p class=\"fw-bolder\">Kecepatan rata-rata merupakan perbandingan perpindahan benda dengan waktu tempuh. Kecepatan merupakan besaran vektor, karena memiliki besar dan arah. Kecepatan rata-rata merupakan perubahan perpindahan (posisi) yang ditempuh oleh benda tiap satuan waktu.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangl2.setText(Html.fromHtml("<p class=\"fw-bolder\">Kecepatan rata-rata merupakan perbandingan perpindahan benda dengan waktu tempuh. Kecepatan merupakan besaran vektor, karena memiliki besar dan arah. Kecepatan rata-rata merupakan perubahan perpindahan (posisi) yang ditempuh oleh benda tiap satuan waktu.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangl3.setText(Html.fromHtml("<p class=\"fw-bolder\">Kelajuan rata-rata merupakan panjang lintasan (jarak) yang ditempuh oleh benda tiap satuan waktu.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangl3.setText(Html.fromHtml("<p class=\"fw-bolder\">Kelajuan rata-rata merupakan panjang lintasan (jarak) yang ditempuh oleh benda tiap satuan waktu.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangl4.setText(Html.fromHtml("<h3>Jenis-jenis Gerak Lurus</h3>\n" +
                    "<p class=\"fw-bolder\">Gerak lurus dibedakan menjadi 2, yaitu gerak lurus beraturan (GLB) dan gerak lurus berubah beraturan (GLBB).</p>\n" +
                    "<p>GLB merupakan gerak benda pada lintasan lurus dengan kecepatan yang tetap atau tanpa percepatan.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangl4.setText(Html.fromHtml("<h3>Jenis-jenis Gerak Lurus</h3>\n" +
                    "<p class=\"fw-bolder\">Gerak lurus dibedakan menjadi 2, yaitu gerak lurus beraturan (GLB) dan gerak lurus berubah beraturan (GLBB).</p>\n" +
                    "<p>GLB merupakan gerak benda pada lintasan lurus dengan kecepatan yang tetap atau tanpa percepatan.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangl5.setText(Html.fromHtml("<p>GLBB merupakan gerak lurus suatu benda yang kecepatannya berubah karena adanya percepatan tetap. Maksud percepatan tetap ialah percepatan selalu sama terhadap waktu. Karena adanya percepatan, rumus jarak yang ditempuh tidak lagi linier, melainkan kuadratik.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangl5.setText(Html.fromHtml("<p>GLBB merupakan gerak lurus suatu benda yang kecepatannya berubah karena adanya percepatan tetap. Maksud percepatan tetap ialah percepatan selalu sama terhadap waktu. Karena adanya percepatan, rumus jarak yang ditempuh tidak lagi linier, melainkan kuadratik.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangl6.setText(Html.fromHtml("<p>Ketentuan :</p>\n" +
                    "<p>(+) saat benda dipercepat , jadi vt > v0</p>\n" +
                    "<p>(-) saat benda diperlambat, jadi vt < v0</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangl6.setText(Html.fromHtml("<p>Ketentuan :</p>\n" +
                    "<p>(+) saat benda dipercepat , jadi vt > v0</p>\n" +
                    "<p>(-) saat benda diperlambat, jadi vt < v0</p>"));
        }

        Glide.with(getContext()).load("https://www.zenius.net/blog/wp-content/uploads/2021/04/perpindahan.png").into(gambargl1);
        Glide.with(getContext()).load("https://lh5.googleusercontent.com/9p80xpzeOYoLgyuKjShyFEym2qUiEtO6vw6GYXWympGd9-5RauU2yGwmiOHjQHeYdJLSS-1xHB4YSjd-oYglpnh_rxCJXCu_dJNr3-oOqTSnybv-RKje-ww85tKU3UGHuXgZGzsH1RpTmuLSUg").into(gambargl2);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/Capture-43.png?width=526&name=Capture-43.png").into(gambargl3);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/Capture-44.png?width=521&name=Capture-44.png").into(gambargl4);
        Glide.with(getContext()).load("https://lh5.googleusercontent.com/JpjBhV2qCPq-I32ubOyVHcKOE_ymeVHCnNu1r5MSNp4c9PcTFEVqTpgqscM7sWiyDuafj18TwwP2C3ChRIrZdvykLy3uh60en1S9RpbnPSeQ5ugvl4pcqKmvl0g_lC4YyAHPb4egjEqGO69Rjg").into(gambargl5);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/Capture-46.png?width=508&name=Capture-46.png").into(gambargl6);
        Glide.with(getContext()).load("http://fisikazone.com/wp-content/uploads/2015/03/Grafik-GLBB.jpg").into(gambargl7);
        return view;
    }
}