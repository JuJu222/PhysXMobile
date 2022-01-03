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
 * Use the {@link HukumNewtonGravitasi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HukumNewtonGravitasi extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HukumNewtonGravitasi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HukumNewtonGravitasi.
     */
    // TODO: Rename and change types and number of parameters
    public static HukumNewtonGravitasi newInstance(String param1, String param2) {
        HukumNewtonGravitasi fragment = new HukumNewtonGravitasi();
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
        View view = inflater.inflate(R.layout.fragment_hukum_newton_gravitasi, container, false);

        TextView penjelasangravitasi1 = view.findViewById(R.id.penjelasangravitasi1);
        TextView penjelasangravitasi2 = view.findViewById(R.id.penjelasangravitasi2);
        TextView penjelasangravitasi3 = view.findViewById(R.id.penjelasangravitasi3);
        TextView penjelasangravitasi4 = view.findViewById(R.id.penjelasangravitasi4);
        TextView penjelasangravitasi5 = view.findViewById(R.id.penjelasangravitasi5);
        ImageView gambargravitasi1 = view.findViewById(R.id.gambargravitasi1);
        ImageView gambargravitasi2 = view.findViewById(R.id.gambargravitasi2);
        ImageView gambargravitasi3 = view.findViewById(R.id.gambargravitasi3);
        ImageView gambargravitasi4 = view.findViewById(R.id.gambargravitasi4);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangravitasi1.setText(Html.fromHtml("<p>Pada buku Newton yang berjudul Philosophiæ Naturalis Principia Mathematica atau dalam bahasa latin berarti prinsip matematika dalam filsafat alam, Newton mempublikasi dan menjelaskan bahwa setiap partikel di alam saling tarik menarik dengan partikel lain yang besarnya sebanding dengan perkalian massa kedua partikel dan berbanding terbalik terhadap kuadrat jarak kedua partikel dan pernyataan ini saat ini terkenal sebagai Hukum Gravitasi Newton. </p>\n" +
                    "<p>Di mana menurut Newton, dalam bidang mekanika klasik atau sering juga disebut Mekanika Newton, benda apa pun yang berada di atas atmosfer akan ditarik oleh bumi, itulah mengapa kita gak bisa terbang kayak astronot yang lagi di luar angkasa, dan kenapa naik tangga lebih capek daripada turun tangga, gaya gravitasi salah satu faktornya. Karena pada umumnya, setiap benda yang memiliki massa selalu ada gaya gravitasi.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangravitasi1.setText(Html.fromHtml("<p>Pada buku Newton yang berjudul Philosophiæ Naturalis Principia Mathematica atau dalam bahasa latin berarti prinsip matematika dalam filsafat alam, Newton mempublikasi dan menjelaskan bahwa setiap partikel di alam saling tarik menarik dengan partikel lain yang besarnya sebanding dengan perkalian massa kedua partikel dan berbanding terbalik terhadap kuadrat jarak kedua partikel dan pernyataan ini saat ini terkenal sebagai Hukum Gravitasi Newton. </p>\n" +
                    "<p>Di mana menurut Newton, dalam bidang mekanika klasik atau sering juga disebut Mekanika Newton, benda apa pun yang berada di atas atmosfer akan ditarik oleh bumi, itulah mengapa kita gak bisa terbang kayak astronot yang lagi di luar angkasa, dan kenapa naik tangga lebih capek daripada turun tangga, gaya gravitasi salah satu faktornya. Karena pada umumnya, setiap benda yang memiliki massa selalu ada gaya gravitasi.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangravitasi2.setText(Html.fromHtml("<p>F = gaya gravitasi (N)</p>\n" +
                    "<p>G = konstanta gravitasi = 6.673 x 10-11Nm2/kg2</p>\n" +
                    "<p>m1 = massa benda pertama (kg)</p>\n" +
                    "<p>m2 = massa benda kedua (kg)</p>\n" +
                    "<p>r = jarak antara pusat kedua benda (m)</p>\n" +
                    "<br/>\n" +
                    "<h3>Medan atau Percepatan Gravitasi</h3>\n" +
                    "<p>Medan gravitasi adalah ruang atau area yang dipengaruhi oleh gaya gravitasi, dimana besarannya dinyatakan sebagai kuat medan gravitasi (g), yaitu gaya gravitasi tiap massa medan gravitasi, atau bisa disebut juga percepatan gravitasi.</p>\n" +
                    "<p>\"Medan” atau ruang yang kita maksud adalah bumi.</p>\n" +
                    "<p>Jika percepatan gravitasi itu di permukaan bumi itu g, maka berat benda tersebut di permukaan bumi adalah </p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangravitasi2.setText(Html.fromHtml("<p>F = gaya gravitasi (N)</p>\n" +
                    "<p>G = konstanta gravitasi = 6.673 x 10-11Nm2/kg2</p>\n" +
                    "<p>m1 = massa benda pertama (kg)</p>\n" +
                    "<p>m2 = massa benda kedua (kg)</p>\n" +
                    "<p>r = jarak antara pusat kedua benda (m)</p>\n" +
                    "<br/>\n" +
                    "<h3>Medan atau Percepatan Gravitasi</h3>\n" +
                    "<p>Medan gravitasi adalah ruang atau area yang dipengaruhi oleh gaya gravitasi, dimana besarannya dinyatakan sebagai kuat medan gravitasi (g), yaitu gaya gravitasi tiap massa medan gravitasi, atau bisa disebut juga percepatan gravitasi.</p>\n" +
                    "<p>\"Medan” atau ruang yang kita maksud adalah bumi.</p>\n" +
                    "<p>Jika percepatan gravitasi itu di permukaan bumi itu g, maka berat benda tersebut di permukaan bumi adalah </p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangravitasi3.setText(Html.fromHtml("<p>Karena berat benda di permukaan bumi (w) sama dengan gaya gravitasi yang bekerja maka,</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangravitasi3.setText(Html.fromHtml("<p>Karena berat benda di permukaan bumi (w) sama dengan gaya gravitasi yang bekerja maka,</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangravitasi4.setText(Html.fromHtml("<br/>\n" +
                    "<h3>Hukum Kepler</h3>\n" +
                    "<p>Setelah adanya penemuan mengenai gravitasi yang ditemukan oleh Isaac Newton, seorang ahli matematika dan astronomi yang berasal dari Jerman yaitu Johannes Kepler berhasil menemukan 3 (tiga) hukum tentang pergerakan planet dalam tata surya, dimana Hukum-hukum Kepler ini sesuai dengan hukum gravitasi Newton. </p>\n" +
                    "<br/>\n" +
                    "<h4>Hukum 1 Kepler</h4>\n" +
                    "<p>“Semua planet bergerak pada lintasan elips yang mengitari matahari, dimana matahari terletak pada salah satu titik pusatnya.”</p>\n" +
                    "<p>Pada dasarnya hukum ini menjelaskan bahwa lintasan di tata surya berbentuk elips, dimana elips itu memiliki 2 titik fokus, dan matahari terletak pada salah satu titik fokusnya.</p>\n" +
                    "<br/>\n" +
                    "<h4>Hukum 2 Kepler</h4>\n" +
                    "<p>“Luas daerah yang disapu oleh garis antara matahari dan planet adalah sama untuk setiap periode waktu yang sama.”</p>\n" +
                    "<p>Pada dasarnya hukum ini menjelaskan bahwa karena lintasannya berbentuk elips, suatu planet tidak memiliki jarak pasti, yang ada adalah titik terjauh (titik aphelion), titik terdekat (titik perihelion), dan rata-rata jarak ke matahari. Dimana kecepatan orbit akan melambat pada saat berada aphelion, dan akan lebih cepat pada perihelion.</p>\n" +
                    "<p class=\"fw-bolder\">Kecepatan orbit maksimum suatu planet pada saat berada di aphelion</p>\n" +
                    "<p class=\"fw-bolder\">Kecepatan orbit minimum suatu planet pada saat berada di perihelion.</p>\n" +
                    "<br/>\n" +
                    "<h4>Hukum 3 Kepler</h4>\n" +
                    "<p>“Kuadrat periode suatu planet sebanding dengan pangkat tiga jarak rata – ratanya dari Matahari”</p>\n" +
                    "<p>Pada dasarnya hukum ini menjelaskan mengenai revolusi planet mengelilingi matahari, planet yang letaknya lebih jauh dari matahari juga akan memiliki periode orbit yang lebih lama, dan sebaliknya atau secara sistematis dapat dituliskan sebagai berikut</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangravitasi4.setText(Html.fromHtml("<br/>\n" +
                    "<h3>Hukum Kepler</h3>\n" +
                    "<p>Setelah adanya penemuan mengenai gravitasi yang ditemukan oleh Isaac Newton, seorang ahli matematika dan astronomi yang berasal dari Jerman yaitu Johannes Kepler berhasil menemukan 3 (tiga) hukum tentang pergerakan planet dalam tata surya, dimana Hukum-hukum Kepler ini sesuai dengan hukum gravitasi Newton. </p>\n" +
                    "<br/>\n" +
                    "<h4>Hukum 1 Kepler</h4>\n" +
                    "<p>“Semua planet bergerak pada lintasan elips yang mengitari matahari, dimana matahari terletak pada salah satu titik pusatnya.”</p>\n" +
                    "<p>Pada dasarnya hukum ini menjelaskan bahwa lintasan di tata surya berbentuk elips, dimana elips itu memiliki 2 titik fokus, dan matahari terletak pada salah satu titik fokusnya.</p>\n" +
                    "<br/>\n" +
                    "<h4>Hukum 2 Kepler</h4>\n" +
                    "<p>“Luas daerah yang disapu oleh garis antara matahari dan planet adalah sama untuk setiap periode waktu yang sama.”</p>\n" +
                    "<p>Pada dasarnya hukum ini menjelaskan bahwa karena lintasannya berbentuk elips, suatu planet tidak memiliki jarak pasti, yang ada adalah titik terjauh (titik aphelion), titik terdekat (titik perihelion), dan rata-rata jarak ke matahari. Dimana kecepatan orbit akan melambat pada saat berada aphelion, dan akan lebih cepat pada perihelion.</p>\n" +
                    "<p class=\"fw-bolder\">Kecepatan orbit maksimum suatu planet pada saat berada di aphelion</p>\n" +
                    "<p class=\"fw-bolder\">Kecepatan orbit minimum suatu planet pada saat berada di perihelion.</p>\n" +
                    "<br/>\n" +
                    "<h4>Hukum 3 Kepler</h4>\n" +
                    "<p>“Kuadrat periode suatu planet sebanding dengan pangkat tiga jarak rata – ratanya dari Matahari”</p>\n" +
                    "<p>Pada dasarnya hukum ini menjelaskan mengenai revolusi planet mengelilingi matahari, planet yang letaknya lebih jauh dari matahari juga akan memiliki periode orbit yang lebih lama, dan sebaliknya atau secara sistematis dapat dituliskan sebagai berikut</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangravitasi5.setText(Html.fromHtml("<p>T1= periode planet pertama</p>\n" +
                    "<p>T2= periode planet kedua</p>\n" +
                    "<p>R1= jari-jari planet pertama</p>\n" +
                    "<p>R2= jari-jari planet kedua</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangravitasi5.setText(Html.fromHtml("<p>T1= periode planet pertama</p>\n" +
                    "<p>T2= periode planet kedua</p>\n" +
                    "<p>R1= jari-jari planet pertama</p>\n" +
                    "<p>R2= jari-jari planet kedua</p>"));
        }

        Glide.with(getContext()).load("https://latex.codecogs.com/gif.latex?F=G.\\frac{m_{1}m_{2}}{r^{2}}").into(gambargravitasi1);
        Glide.with(getContext()).load("https://latex.codecogs.com/gif.latex?w&space;=&space;m.g").into(gambargravitasi2);
        Glide.with(getContext()).load("https://i0.wp.com/www.zenius.net/blog/wp-content/uploads/2021/01/rumus-medan-gravitasi-1.png?resize=300%2C188&ssl=1").into(gambargravitasi3);
        Glide.with(getContext()).load("https://i2.wp.com/www.zenius.net/blog/wp-content/uploads/2021/01/rumus-kepler-.png?resize=300%2C109&is-pending-load=1#038;ssl=1").into(gambargravitasi4);
        return view;
    }
}