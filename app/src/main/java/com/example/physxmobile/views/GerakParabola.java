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
 * Use the {@link GerakParabola#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GerakParabola extends Fragment {
    private QuestionViewModel questionViewModel;
    private SharedPreferenceHelper helper;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GerakParabola() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GerakParabola.
     */
    // TODO: Rename and change types and number of parameters
    public static GerakParabola newInstance(String param1, String param2) {
        GerakParabola fragment = new GerakParabola();
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
        View view = inflater.inflate(R.layout.fragment_gerak_parabola, container, false);

        TextView penjelasangp1 = view.findViewById(R.id.penjelasanmdi1);
        TextView penjelasangp2 = view.findViewById(R.id.penjelasangp2);
        TextView penjelasangp3 = view.findViewById(R.id.penjelasangp3);
        TextView penjelasangp4 = view.findViewById(R.id.penjelasangp4);
        ImageView gambargp1 = view.findViewById(R.id.gambargp1);
        ImageView gambargp2 = view.findViewById(R.id.gambargp2);
        ImageView gambargp3 = view.findViewById(R.id.gambargp3);
        ImageView gambargp4 = view.findViewById(R.id.gambargp4);

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
                questionViewModel.getQuestions(4);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 4);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakParabola_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakParabola_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakParabola_to_TOFFragment, bundle);
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
                questionViewModel.getQuestions(14);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 14);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakParabola_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakParabola_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_gerakParabola_to_TOFFragment, bundle);
                                    break;
                            }
                        }
                    }
                });
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangp1.setText(Html.fromHtml("<p>Gerak parabola adalah <span class=\"fw-bolder\">gabungan antara gerak lurus beraturan (GLB) dan gerak lurus berubah beraturan (GLBB)</span>.</p>\n" +
                    "<p class=\"fw-bolder\">Gerak parabola merupakan gerak dua dimensi suatu benda yang bergerak membentuk sudut elevasi dengan sumbu x atau sumbu y. </p>\n" +
                    "<p>Sumbu x (horizontal) merupakan GLB dan sumbu y (vertikal) merupakan GLBB.</p>\n" +
                    "<p>Kedua gerak ini tidak saling memengaruhi, hanya saja membentuk suatu gerak parabola.</p>\n" +
                    "<p>Berikut adalah contoh gerakan parabola.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangp1.setText(Html.fromHtml("<p>Gerak parabola adalah <span class=\"fw-bolder\">gabungan antara gerak lurus beraturan (GLB) dan gerak lurus berubah beraturan (GLBB)</span>.</p>\n" +
                    "<p class=\"fw-bolder\">Gerak parabola merupakan gerak dua dimensi suatu benda yang bergerak membentuk sudut elevasi dengan sumbu x atau sumbu y. </p>\n" +
                    "<p>Sumbu x (horizontal) merupakan GLB dan sumbu y (vertikal) merupakan GLBB.</p>\n" +
                    "<p>Kedua gerak ini tidak saling memengaruhi, hanya saja membentuk suatu gerak parabola.</p>\n" +
                    "<p>Berikut adalah contoh gerakan parabola.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangp2.setText(Html.fromHtml("<p class=\"fw-bolder\">Dalam gerak parabola, komponen sumbu x merupakan komponen GLB.</p>\n" +
                    "<p>GLB merupakan kecepatan di sumbu horizontal pada titik ataupun posisi tetap.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangp2.setText(Html.fromHtml("<p class=\"fw-bolder\">Dalam gerak parabola, komponen sumbu x merupakan komponen GLB.</p>\n" +
                    "<p>GLB merupakan kecepatan di sumbu horizontal pada titik ataupun posisi tetap.</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangp3.setText(Html.fromHtml("<p>Perhatikan juga tabel di bawah ini untuk referensi:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangp3.setText(Html.fromHtml("<p>Perhatikan juga tabel di bawah ini untuk referensi:</p>"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasangp4.setText(Html.fromHtml("<h3>Sumbu Y</h3>\n" +
                    "<p class=\"fw-bolder\">Jika sumbu x merupakan komponen GLB, sumbu y atau arah vertikal komponen gerak merupakan GLBB.</p>\n" +
                    "<p>Perbedaan sumbu x dengan sumbu y ialah simbol perpindahan/jarak pada sumbu x ditunjukkan dengan s, sedangkan pada sumbu y ditunjukkan dengan y.</p>\n" +
                    "<p>Sumbu y kecepatan awal disimbolkan dengan. Sehingga, dapat dirumuskan sebagai berikut:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasangp4.setText(Html.fromHtml("<h3>Sumbu Y</h3>\n" +
                    "<p class=\"fw-bolder\">Jika sumbu x merupakan komponen GLB, sumbu y atau arah vertikal komponen gerak merupakan GLBB.</p>\n" +
                    "<p>Perbedaan sumbu x dengan sumbu y ialah simbol perpindahan/jarak pada sumbu x ditunjukkan dengan s, sedangkan pada sumbu y ditunjukkan dengan y.</p>\n" +
                    "<p>Sumbu y kecepatan awal disimbolkan dengan. Sehingga, dapat dirumuskan sebagai berikut:</p>"));
        }
        Glide.with(getContext()).load("https://asset.kompas.com/data/photo/2020/10/02/5f7733cb9dfdc.png").into(gambargp1);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/Rumus%201-2.jpg?width=600&name=Rumus%201-2.jpg").into(gambargp2);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/tabel%20gerak%20parabola.jpg?width=600&name=tabel%20gerak%20parabola.jpg").into(gambargp3);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/Rumus%202-3.jpg?width=600&name=Rumus%202-3.jpg").into(gambargp4);
        return view;
    }
}