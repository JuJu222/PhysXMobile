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
import android.widget.TextView;

import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MomentumDanImpuls#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MomentumDanImpuls extends Fragment {
    private QuestionViewModel questionViewModel;
    private SharedPreferenceHelper helper;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MomentumDanImpuls() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MomentumDanImpuls.
     */
    // TODO: Rename and change types and number of parameters
    public static MomentumDanImpuls newInstance(String param1, String param2) {
        MomentumDanImpuls fragment = new MomentumDanImpuls();
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
        View view = inflater.inflate(R.layout.fragment_momentum_dan_impuls, container, false);

        TextView penjelasanmdi1 = view.findViewById(R.id.penjelasanmdi1);


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
                questionViewModel.getQuestions(9);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 9);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_momentumDanImpuls_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_momentumDanImpuls_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_momentumDanImpuls_to_TOFFragment, bundle);
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
                questionViewModel.getQuestions(19);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 19);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_momentumDanImpuls_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_momentumDanImpuls_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_momentumDanImpuls_to_TOFFragment, bundle);
                                    break;
                            }
                        }
                    }
                });
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanmdi1.setText(Html.fromHtml("<h3>Definisi Momentum</h3>\n" +
                    "<p>Momentum adalah ukuran kesulitan untuk memberhentikan benda.</p>\n" +
                    "<p>Semakin berat benda, maka momentum akan semakin besar.</p>\n" +
                    "<p>Semakin cepat benda bergerak, maka momentum juga akan semakin besar.</p>\n" +
                    "<br/>\n" +
                    "<h3>Definisi Impuls</h3>\n" +
                    "<p>Impuls adalah gaya yang diperlukan untuk membuat suatu benda menjadi bergerak.</p>\n" +
                    "<p>Tentu ada interval waktu tertentu di sana.</p>\n" +
                    "<br/>\n" +
                    "<h3>Rumus Momentum dan Impuls</h3>\n" +
                    "<p>Impuls dan momentum termasuk dalam besaran vektor, sehingga akan memiliki nilai dan arah.</p>\n" +
                    "<p>Momentum memiliki arah yang sama (searah) dengan kecepatannya.</p>\n" +
                    "<p>Arah impuls searah dengan gaya impulsifnya.</p>\n" +
                    "<br/>\n" +
                    "<h4>Rumus Momentum</h4>\n" +
                    "<p>Dari uraian tentang momentum atau yang dilambangkan dengan p di atas, kamu tau kalau momentum dipengaruhi oleh massa (m) dan kecepatan (v), dengan masing-masing satuannya berturut-turut yaitu kg dan m/s. Secara matematis, berikut adalah rumus momentum:</p>\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-4\">p = m.v</i></div>\n" +
                    "<p>p : momentum (kg.m/s)</p>\n" +
                    "<p>m : massa (kg)</p>\n" +
                    "<p>v : kecepatan (v)</p>\n" +
                    "<p>Massa merupakan suatu besaran skalar, karena dia gak punya arah. Sedangkan, kecepatan merupakan besaran vektor yang punya arahnya. Nah, karena besaran skalar dan besaran vektor kalau disatukan akan menghasilkan besaran vektor, itulah mengapa momentum merupakan besaran vektor, yaitu besaran yang memiliki arah. Jadi, ketika kamu tau besaran momentum, berarti kamu juga harus tau arahnya kemana.</p>\n" +
                    "<br/>\n" +
                    "<h4>Rumus Impuls</h4>\n" +
                    "<p>Impuls dilambangkan dengan huruf “I” dengan satuannya yaitu Ns. Berikut ini adalah rumus impuls:</p>\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-4\">I = F.Δt</i></div>\n" +
                    "<p>I : impuls (Ns)</p>\n" +
                    "<p>F : gaya impulsif (N)</p>\n" +
                    "<p>Δt : perubahan waktu (s)</p>\n" +
                    "<br/>\n" +
                    "<h3>Hubungan Momentum dan Impuls</h3>\n" +
                    "<br/>\n" +
                    "<h5>Ingatkah kamu dengan Hukum II Newton berikut ini?</h5>\n" +
                    "<div class=\"d-flex justify-content-center\"><h4 class=\"text-center\">“Gaya (F) yang diberikan pada suatu benda akan sama besarnya dengan perubahan momentum (Δp) per satuan waktu (Δt)”.</h4></div>\n" +
                    "<p>Nah, kamu bisa melihat hubungan keduanya dari persamaan matematika sebagai berikut:</p>\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">F = m.a (sesuai Hukum Newton II)</i></div>\n" +
                    "<p>dimana,</p>\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">a = Δv/Δt = (v2-v1) / Δt</i></div>\n" +
                    "<p>sehingga,</p>\n" +
                    "\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">F = m ((v2-v1) / Δt)</i></div>\n" +
                    "\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">F.Δt = m.v2 – m.v1</i></div>\n" +
                    "\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">F.Δt = p2 – p1</i></div>\n" +
                    "\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">I = Δp</i></div>\n" +
                    "<br/>\n" +
                    "<p>Itu dia hubungan antara momentum dan impuls. Di mana, impuls sama dengan perubahan momentum yang dialami suatu benda.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanmdi1.setText(Html.fromHtml("<h3>Definisi Momentum</h3>\n" +
                    "<p>Momentum adalah ukuran kesulitan untuk memberhentikan benda.</p>\n" +
                    "<p>Semakin berat benda, maka momentum akan semakin besar.</p>\n" +
                    "<p>Semakin cepat benda bergerak, maka momentum juga akan semakin besar.</p>\n" +
                    "<br/>\n" +
                    "<h3>Definisi Impuls</h3>\n" +
                    "<p>Impuls adalah gaya yang diperlukan untuk membuat suatu benda menjadi bergerak.</p>\n" +
                    "<p>Tentu ada interval waktu tertentu di sana.</p>\n" +
                    "<br/>\n" +
                    "<h3>Rumus Momentum dan Impuls</h3>\n" +
                    "<p>Impuls dan momentum termasuk dalam besaran vektor, sehingga akan memiliki nilai dan arah.</p>\n" +
                    "<p>Momentum memiliki arah yang sama (searah) dengan kecepatannya.</p>\n" +
                    "<p>Arah impuls searah dengan gaya impulsifnya.</p>\n" +
                    "<br/>\n" +
                    "<h4>Rumus Momentum</h4>\n" +
                    "<p>Dari uraian tentang momentum atau yang dilambangkan dengan p di atas, kamu tau kalau momentum dipengaruhi oleh massa (m) dan kecepatan (v), dengan masing-masing satuannya berturut-turut yaitu kg dan m/s. Secara matematis, berikut adalah rumus momentum:</p>\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-4\">p = m.v</i></div>\n" +
                    "<p>p : momentum (kg.m/s)</p>\n" +
                    "<p>m : massa (kg)</p>\n" +
                    "<p>v : kecepatan (v)</p>\n" +
                    "<p>Massa merupakan suatu besaran skalar, karena dia gak punya arah. Sedangkan, kecepatan merupakan besaran vektor yang punya arahnya. Nah, karena besaran skalar dan besaran vektor kalau disatukan akan menghasilkan besaran vektor, itulah mengapa momentum merupakan besaran vektor, yaitu besaran yang memiliki arah. Jadi, ketika kamu tau besaran momentum, berarti kamu juga harus tau arahnya kemana.</p>\n" +
                    "<br/>\n" +
                    "<h4>Rumus Impuls</h4>\n" +
                    "<p>Impuls dilambangkan dengan huruf “I” dengan satuannya yaitu Ns. Berikut ini adalah rumus impuls:</p>\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-4\">I = F.Δt</i></div>\n" +
                    "<p>I : impuls (Ns)</p>\n" +
                    "<p>F : gaya impulsif (N)</p>\n" +
                    "<p>Δt : perubahan waktu (s)</p>\n" +
                    "<br/>\n" +
                    "<h3>Hubungan Momentum dan Impuls</h3>\n" +
                    "<br/>\n" +
                    "<h5>Ingatkah kamu dengan Hukum II Newton berikut ini?</h5>\n" +
                    "<div class=\"d-flex justify-content-center\"><h4 class=\"text-center\">“Gaya (F) yang diberikan pada suatu benda akan sama besarnya dengan perubahan momentum (Δp) per satuan waktu (Δt)”.</h4></div>\n" +
                    "<p>Nah, kamu bisa melihat hubungan keduanya dari persamaan matematika sebagai berikut:</p>\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">F = m.a (sesuai Hukum Newton II)</i></div>\n" +
                    "<p>dimana,</p>\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">a = Δv/Δt = (v2-v1) / Δt</i></div>\n" +
                    "<p>sehingga,</p>\n" +
                    "\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">F = m ((v2-v1) / Δt)</i></div>\n" +
                    "\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">F.Δt = m.v2 – m.v1</i></div>\n" +
                    "\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">F.Δt = p2 – p1</i></div>\n" +
                    "\n" +
                    "<div class=\"d-flex justify-content-center\"><i class=\"fw-bolder display-6\">I = Δp</i></div>\n" +
                    "<br/>\n" +
                    "<p>Itu dia hubungan antara momentum dan impuls. Di mana, impuls sama dengan perubahan momentum yang dialami suatu benda.</p>"));
        }

        return view;
    }
}