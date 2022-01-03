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
 * Use the {@link Besaran#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Besaran extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private QuestionViewModel questionViewModel;
    private SharedPreferenceHelper helper;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Besaran() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Besaran.
     */
    // TODO: Rename and change types and number of parameters
    public static Besaran newInstance(String param1, String param2) {
        Besaran fragment = new Besaran();
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
        View view = inflater.inflate(R.layout.fragment_besaran, container, false);

        TextView penjelasan1 = view.findViewById(R.id.penjelasanmdi1);
        TextView penjelasan2 = view.findViewById(R.id.penjelasan2);
        TextView penjelasan3 = view.findViewById(R.id.penjelasan3);
        TextView penjelasan4 = view.findViewById(R.id.penjelasan4);

        ImageView gambar1 = view.findViewById(R.id.gambar1);
        ImageView gambar2 = view.findViewById(R.id.gambar2);
        ImageView gambar3 = view.findViewById(R.id.gambar3);
        ImageView gambar4 = view.findViewById(R.id.gambar4);

        Button button_easy = view.findViewById(R.id.btn_mudah);
        Button button_hard = view.findViewById(R.id.btn_susah);

        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        questionViewModel.init(helper.getAccessToken());

        button_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionViewModel.getQuestions(1);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 1);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_besaran_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_besaran_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_besaran_to_TOFFragment, bundle);
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
                questionViewModel.getQuestions(11);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 11);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_besaran_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_besaran_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_besaran_to_TOFFragment, bundle);
                                    break;
                            }
                        }
                    }
                });
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasan1.setText(Html.fromHtml("<p>Besaran adalah segala sesuatu yang dapat diukur dan dinyatakan dengan angka, serta memiliki satuan.</p>\n" +
                    "<p>Satuan adalah segala sesuatu yang menyatakan hasil pengukuran atau pembanding dari suatu besaran.</p>\n" +
                    "<p>Ada satuan yang baku dan ada yang tidak baku.</p>\n" +
                    "<p>Yang dipakai dalam Fisika adalah besaran dan satuan yang baku yaitu dari Satuan Internasional (SI)</p>\n" +
                    "<br/>\n" +
                    "<h3>Besaran Pokok</h3>\n" +
                    "<p>Besaran pokok adalah besaran dasar untuk menetapkan besaran yang lain</p>\n" +
                    "<p>Berikut adalah 7 besaran pokok beserta satuannya yang telah disepakati:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasan1.setText(Html.fromHtml("<p>Besaran adalah segala sesuatu yang dapat diukur dan dinyatakan dengan angka, serta memiliki satuan.</p>\n" +
                    "<p>Satuan adalah segala sesuatu yang menyatakan hasil pengukuran atau pembanding dari suatu besaran.</p>\n" +
                    "<p>Ada satuan yang baku dan ada yang tidak baku.</p>\n" +
                    "<p>Yang dipakai dalam Fisika adalah besaran dan satuan yang baku yaitu dari Satuan Internasional (SI)</p>\n" +
                    "<br/>\n" +
                    "<h3>Besaran Pokok</h3>\n" +
                    "<p>Besaran pokok adalah besaran dasar untuk menetapkan besaran yang lain</p>\n" +
                    "<p>Berikut adalah 7 besaran pokok beserta satuannya yang telah disepakati:</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasan2.setText(Html.fromHtml("<h3>Besaran Turunan</h3>\n" +
                    "<p>Besaran turunan adalah besaran yang diturunkan atau berasal dari besaran pokok.</p>\n" +
                    "<p>Berikut adalah beberapa dari banyak besaran turunan:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasan2.setText(Html.fromHtml("<h3>Besaran Turunan</h3>\n" +
                    "<p>Besaran turunan adalah besaran yang diturunkan atau berasal dari besaran pokok.</p>\n" +
                    "<p>Berikut adalah beberapa dari banyak besaran turunan:</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasan3.setText(Html.fromHtml("<h3>Dimensi</h3>\n" +
                    "<p>Dimensi adalah bentuk penulisan besaran menggunakan lambang satuan besaran pokok.</p>\n" +
                    "<p>Ciri-cirinya adalah terdapat lambang besaran pokok di dalam kurung siku.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasan3.setText(Html.fromHtml("<h3>Dimensi</h3>\n" +
                    "<p>Dimensi adalah bentuk penulisan besaran menggunakan lambang satuan besaran pokok.</p>\n" +
                    "<p>Ciri-cirinya adalah terdapat lambang besaran pokok di dalam kurung siku.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasan4.setText(Html.fromHtml("<br/>\n" +
                    "<p>Nah, bagaimana kalau dimensi dibutuhkan untuk perhitungan?</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasan4.setText(Html.fromHtml("<br/>\n" +
                    "<p>Nah, bagaimana kalau dimensi dibutuhkan untuk perhitungan?</p>"));
        }

        Glide.with(getContext()).load("https://drive.google.com/uc?export=view&id=1nXmsPHtTV7UmgAMd9q-3Af2gGx6XypKI").into(gambar1);
        //https://drive.google.com/uc?export=view&id=1HXVB2tF8fQmHldBUmjj8xMqbvNHZBdMO
        Glide.with(getContext()).load("https://drive.google.com/uc?export=view&id=1HXVB2tF8fQmHldBUmjj8xMqbvNHZBdMO").into(gambar2);
        //https://drive.google.com/uc?export=view&id=1HXVB2tF8fQmHldBUmjj8xMqbvNHZBdMO
        Glide.with(getContext()).load("https://drive.google.com/uc?export=view&id=18YXCPCrFjt_d0Ozw6-R6mcWTvLyrAgYN").into(gambar3);
        //https://drive.google.com/uc?export=view&id=18YXCPCrFjt_d0Ozw6-R6mcWTvLyrAgYN
        Glide.with(getContext()).load("https://i0.wp.com/www.zenius.net/blog/wp-content/uploads/2021/01/contoh.png?fit=534%2C338&ssl=1").into(gambar4);


        return view;
    }
}