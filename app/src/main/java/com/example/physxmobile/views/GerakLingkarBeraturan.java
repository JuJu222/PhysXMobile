package com.example.physxmobile.views;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GerakLingkarBeraturan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GerakLingkarBeraturan extends Fragment {
    private QuestionViewModel questionViewModel;
    private SharedPreferenceHelper helper;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GerakLingkarBeraturan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GerakLingkarBeraturan.
     */
    // TODO: Rename and change types and number of parameters
    public static GerakLingkarBeraturan newInstance(String param1, String param2) {
        GerakLingkarBeraturan fragment = new GerakLingkarBeraturan();
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
        View view = inflater.inflate(R.layout.fragment_gerak_lingkar_beraturan, container, false);

        TextView penjelasanglb1 = view.findViewById(R.id.penjelasangp2);
        TextView penjelasanglb2 = view.findViewById(R.id.penjelasangp3);
        TextView penjelasanglb3 = view.findViewById(R.id.penjelasanglb3);
        TextView penjelasanglb4 = view.findViewById(R.id.penjelasanglb4);

        ImageView gambarglb1 = view.findViewById(R.id.gambargp1);
        ImageView gambarglb2 = view.findViewById(R.id.gambargp2);
        ImageView gambarglb3 = view.findViewById(R.id.gambargp3);
        ImageView gambarglb4 = view.findViewById(R.id.gambarglb4);

        Button button_easy = view.findViewById(R.id.btn_mudah);
        Button button_hard = view.findViewById(R.id.btn_susah);
        ImageButton topic_overview_back = view.findViewById(R.id.topic_overview_back);

        topic_overview_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).popBackStack();
            }
        });
        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        questionViewModel.init(helper.getAccessToken());

        button_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionViewModel.getQuestions(5);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 5);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakLingkarBeraturan_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakLingkarBeraturan_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakLingkarBeraturan_to_TOFFragment, bundle);
                                    break;
                            }
                        }
                    }
                });
            }
        });

        button_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionViewModel.getQuestions(15);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 15);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakLingkarBeraturan_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakLingkarBeraturan_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakLingkarBeraturan_to_TOFFragment, bundle);
                                    break;
                            }
                        }
                    }
                });
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanglb1.setText(Html.fromHtml("<br/>\n" +
                    "<p>Gerak Melingkar dibagi menjadi dua macam, yakni <span class=\"fw-bolder\">Gerak Melingkar Beraturan (GMB) dan Gerak Melingkar Berubah Beraturan (GMBB)</span>.</p>\n" +
                    "<p>Namun, kali ini kita akan fokus ke GMB terlebih dahulu.</p>\n" +
                    "<p class=\"fw-bolder\">Gerak Melingkar Beraturan (GMB) adalah gerak suatu benda yang menempuh lintasan melingkar dengan kecepatan atau kelajuan yang tetap.</p>\n" +
                    "<p>GMB merupakan jenis gerak yang mirip, namun tidak sama dengan Gerak Lurus Beraturan (GLB). Perbedaannya terdapat pada jenis lintasannya. Pada GMB, lintasannya melingkar, sedangkan pada GLB, lintasannya lurus.</p>\n" +
                    "<p>Contohnya seperti gerak jarum jam. Jarum jam itu bergerak melingkar dengan kecepatan yang tetap, nggak ngebut-ngebut apalagi berhenti mendadak, karena berjalannya waktu itu tetap alias sama saja dari hari ke hari. </p>\n" +
                    "<p>Contoh lain dari GMB yaitu gerak yang terjadi pada bianglala dan komedi putar. Biasanya, bianglala dan komedi putar akan bergerak dengan kecepatan yang tetap, supaya antara 1 sesi dengan sesi lainnya, memakan waktu yang sama.</p>\n" +
                    "<br/>\n" +
                    "<h3>Besaran dan Rumus pada Gerak Melingkar Beraturan (GMB)</h3>\n" +
                    "<p>Pada Gerak Melingkar Beraturan, terdapat beberapa besaran yang perlu kamu tahu. Mulai dari kecepatan tangensial, percepatan tangensial, kecepatan sudut, hingga percepatan sentripetal.</p>\n" +
                    "<br/>\n" +
                    "<h4>Kecepatan Tangensial dan Percepatan Tangensial</h4>\n" +
                    "<p>Pada GMB, bendanya itu bergerak dengan kecepatan tangensial yang konstan (tetap) alias tidak berubah-ubah, sehingga percepatan tangensialnya bernilai 0 (nol).</p>\n" +
                    "<p>Kecepatan tangensial (v) adalah kecepatan yang selalu menyinggung lintasan dan tegak lurus dengan jari-jari lintasan. Sedangkan percepatan tangensial adalah percepatan yang sejajar dengan lintasan.</p>\n" +
                    "<p>Meskipun nilai kecepatan tangensialnya tetap, tetapi vektor (arah) dari kecepatan tangensialnya berubah setiap saat atau tidak tetap.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanglb1.setText(Html.fromHtml("<br/>\n" +
                    "<p>Gerak Melingkar dibagi menjadi dua macam, yakni <span class=\"fw-bolder\">Gerak Melingkar Beraturan (GMB) dan Gerak Melingkar Berubah Beraturan (GMBB)</span>.</p>\n" +
                    "<p>Namun, kali ini kita akan fokus ke GMB terlebih dahulu.</p>\n" +
                    "<p class=\"fw-bolder\">Gerak Melingkar Beraturan (GMB) adalah gerak suatu benda yang menempuh lintasan melingkar dengan kecepatan atau kelajuan yang tetap.</p>\n" +
                    "<p>GMB merupakan jenis gerak yang mirip, namun tidak sama dengan Gerak Lurus Beraturan (GLB). Perbedaannya terdapat pada jenis lintasannya. Pada GMB, lintasannya melingkar, sedangkan pada GLB, lintasannya lurus.</p>\n" +
                    "<p>Contohnya seperti gerak jarum jam. Jarum jam itu bergerak melingkar dengan kecepatan yang tetap, nggak ngebut-ngebut apalagi berhenti mendadak, karena berjalannya waktu itu tetap alias sama saja dari hari ke hari. </p>\n" +
                    "<p>Contoh lain dari GMB yaitu gerak yang terjadi pada bianglala dan komedi putar. Biasanya, bianglala dan komedi putar akan bergerak dengan kecepatan yang tetap, supaya antara 1 sesi dengan sesi lainnya, memakan waktu yang sama.</p>\n" +
                    "<br/>\n" +
                    "<h3>Besaran dan Rumus pada Gerak Melingkar Beraturan (GMB)</h3>\n" +
                    "<p>Pada Gerak Melingkar Beraturan, terdapat beberapa besaran yang perlu kamu tahu. Mulai dari kecepatan tangensial, percepatan tangensial, kecepatan sudut, hingga percepatan sentripetal.</p>\n" +
                    "<br/>\n" +
                    "<h4>Kecepatan Tangensial dan Percepatan Tangensial</h4>\n" +
                    "<p>Pada GMB, bendanya itu bergerak dengan kecepatan tangensial yang konstan (tetap) alias tidak berubah-ubah, sehingga percepatan tangensialnya bernilai 0 (nol).</p>\n" +
                    "<p>Kecepatan tangensial (v) adalah kecepatan yang selalu menyinggung lintasan dan tegak lurus dengan jari-jari lintasan. Sedangkan percepatan tangensial adalah percepatan yang sejajar dengan lintasan.</p>\n" +
                    "<p>Meskipun nilai kecepatan tangensialnya tetap, tetapi vektor (arah) dari kecepatan tangensialnya berubah setiap saat atau tidak tetap.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanglb2.setText(Html.fromHtml("<br/>\n" +
                    "<h4>Frekuensi Sudut (Kecepatan Sudut)</h4>\n" +
                    "<p>Kenapa kecepatan tangensial pada GMB tetap? Hal ini disebabkan oleh kecepatan sudut yang juga tetap. Kecepatan sudut atau frekuensi sudut (ω) adalah besarnya sudut yang ditempuh tiap detiknya.</p>\n" +
                    "<p>Kecepatan sudut ini nilainya tetap karena arah kecepatan sudut sama dengan arah putaran benda.</p>\n" +
                    "<p>Untuk menghitung nilai kecepatan sudut, kamu bisa menggunakan rumus berikut.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanglb2.setText(Html.fromHtml("<br/>\n" +
                    "<h4>Frekuensi Sudut (Kecepatan Sudut)</h4>\n" +
                    "<p>Kenapa kecepatan tangensial pada GMB tetap? Hal ini disebabkan oleh kecepatan sudut yang juga tetap. Kecepatan sudut atau frekuensi sudut (ω) adalah besarnya sudut yang ditempuh tiap detiknya.</p>\n" +
                    "<p>Kecepatan sudut ini nilainya tetap karena arah kecepatan sudut sama dengan arah putaran benda.</p>\n" +
                    "<p>Untuk menghitung nilai kecepatan sudut, kamu bisa menggunakan rumus berikut.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanglb3.setText(Html.fromHtml("<br/>\n" +
                    "<h4>Percepatan Sentripetal</h4>\n" +
                    "<p>Percepatan sentripetal (as) adalah percepatan yang tegak lurus dengan kecepatan tangensial, selalu mengarah ke pusat lintasan, dan hanya mengubah arah kecepatan (tidak dengan besarnya).</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanglb3.setText(Html.fromHtml("<br/>\n" +
                    "<h4>Percepatan Sentripetal</h4>\n" +
                    "<p>Percepatan sentripetal (as) adalah percepatan yang tegak lurus dengan kecepatan tangensial, selalu mengarah ke pusat lintasan, dan hanya mengubah arah kecepatan (tidak dengan besarnya).</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanglb4.setText(Html.fromHtml("<p>Berdasarkan gambar di atas, dapat dilihat bahwa vektor (arah) percepatan sentripetal (as) selalu menuju ke pusat lingkaran.</p>\n" +
                    "<p>Sedangkan vektor kecepatan tangensial (v) arahnya lurus. Sementara itu, vektor kecepatan sudut (ω) searah dengan putaran benda. </p>\n" +
                    "<p>Jadi, ketiganya memiliki arah yang berbeda-beda.</p>\n" +
                    "<p>Selain itu, berdasarkan persamaan di atas, dapat disimpulkan bahwa semakin besar kecepatan tangensialnya, maka akan semakin besar pula percepatan sentripetalnya.</p>\n" +
                    "<br/>\n" +
                    "<h4>Periode dan Frekuensi</h4>\n" +
                    "<p>Periode adalah waktu yang diperlukan untuk berputar satu putaran penuh.</p>\n" +
                    "<p>Sedangkan frekuensi adalah banyaknya putaran yang ditempuh oleh suatu benda selama 1 detik. </p>\n" +
                    "<p>Rumus periode dan frekuensi bisa kamu lihat pada gambar berikut.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanglb4.setText(Html.fromHtml("<p>Berdasarkan gambar di atas, dapat dilihat bahwa vektor (arah) percepatan sentripetal (as) selalu menuju ke pusat lingkaran.</p>\n" +
                    "<p>Sedangkan vektor kecepatan tangensial (v) arahnya lurus. Sementara itu, vektor kecepatan sudut (ω) searah dengan putaran benda. </p>\n" +
                    "<p>Jadi, ketiganya memiliki arah yang berbeda-beda.</p>\n" +
                    "<p>Selain itu, berdasarkan persamaan di atas, dapat disimpulkan bahwa semakin besar kecepatan tangensialnya, maka akan semakin besar pula percepatan sentripetalnya.</p>\n" +
                    "<br/>\n" +
                    "<h4>Periode dan Frekuensi</h4>\n" +
                    "<p>Periode adalah waktu yang diperlukan untuk berputar satu putaran penuh.</p>\n" +
                    "<p>Sedangkan frekuensi adalah banyaknya putaran yang ditempuh oleh suatu benda selama 1 detik. </p>\n" +
                    "<p>Rumus periode dan frekuensi bisa kamu lihat pada gambar berikut.</p>"));
        }

        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/kecepatan%20dan%20percepatan%20tangensial.jpg?width=600&name=kecepatan%20dan%20percepatan%20tangensial.jpg").into(gambarglb1);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/rumus%20kecepatan%20sudut.jpg?width=600&name=rumus%20kecepatan%20sudut.jpg").into(gambarglb2);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/rumus%20percepatan%20sentripetal.jpg?width=600&name=rumus%20percepatan%20sentripetal.jpg").into(gambarglb3);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/rumus%20periode%20dan%20frekuensi.jpg?width=600&name=rumus%20periode%20dan%20frekuensi.jpg").into(gambarglb4);
        return view;
    }
}