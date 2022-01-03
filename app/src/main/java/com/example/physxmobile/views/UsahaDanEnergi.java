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
 * Use the {@link UsahaDanEnergi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsahaDanEnergi extends Fragment {
    private QuestionViewModel questionViewModel;
    private SharedPreferenceHelper helper;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UsahaDanEnergi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsahaDanEnergi.
     */
    // TODO: Rename and change types and number of parameters
    public static UsahaDanEnergi newInstance(String param1, String param2) {
        UsahaDanEnergi fragment = new UsahaDanEnergi();
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
        View view = inflater.inflate(R.layout.fragment_usaha_dan_energi, container, false);

        TextView penjelasanude1 = view.findViewById(R.id.penjelasanude1);
        TextView penjelasanude2 = view.findViewById(R.id.penjelasanude2);
        TextView penjelasanude3 = view.findViewById(R.id.penjelasanude3);
        TextView penjelasanude4 = view.findViewById(R.id.penjelasanude4);
        TextView penjelasanude5 = view.findViewById(R.id.penjelasanude5);
        TextView penjelasanude6 = view.findViewById(R.id.penjelasanude6);
        TextView penjelasanude7 = view.findViewById(R.id.penjelasanude7);
        TextView penjelasanude8 = view.findViewById(R.id.penjelasanude8);
        TextView penjelasanude9 = view.findViewById(R.id.penjelasanude9);
        TextView penjelasanude10 = view.findViewById(R.id.penjelasanude10);

        ImageView gambarude1 = view.findViewById(R.id.gambarude1);
        ImageView gambarude2 = view.findViewById(R.id.gambarude2);
        ImageView gambarude3 = view.findViewById(R.id.gambarude3);
        ImageView gambarude4 = view.findViewById(R.id.gambarude4);
        ImageView gambarude5 = view.findViewById(R.id.gambarude5);
        ImageView gambarude6 = view.findViewById(R.id.gambarude6);
        ImageView gambarude7 = view.findViewById(R.id.gambarude7);
        ImageView gambarude8 = view.findViewById(R.id.gambarude8);
        ImageView gambarude9 = view.findViewById(R.id.gambarude9);
        ImageView gambarude92 = view.findViewById(R.id.gambarude92);
        ImageView gambarude93 = view.findViewById(R.id.gambarude93);


        Button button_easy = view.findViewById(R.id.btn_mudah);
        Button button_hard = view.findViewById(R.id.btn_susah);

        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        questionViewModel.init(helper.getAccessToken());

        button_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionViewModel.getQuestions(8);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 8);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_usahaDanEnergi_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_usahaDanEnergi_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_usahaDanEnergi_to_TOFFragment, bundle);
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
                questionViewModel.getQuestions(18);
                questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                        List<Question.Questions> resultQuestion = question.getQuestions();
                        Bundle bundle = new Bundle();
                        bundle.putInt("noSoal", 0);
                        bundle.putInt("topicId", 18);
                        if (resultQuestion.get(0) != null) {
                            switch (resultQuestion.get(0).getQuestion_type()) {
                                case "mcq":
                                    Navigation.findNavController(view).navigate(R.id.action_usahaDanEnergi_to_MCQFragment, bundle);
                                    break;
                                case "fitb":
                                    Navigation.findNavController(view).navigate(R.id.action_usahaDanEnergi_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    Navigation.findNavController(view).navigate(R.id.action_usahaDanEnergi_to_TOFFragment, bundle);
                                    break;
                            }
                        }
                    }
                });
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude1.setText(Html.fromHtml("<h3>Usaha</h3>\n" +
                    "<p class=\"fw-bolder\">Usaha adalah besarnya energi untuk merubah posisi yang diberikan gaya pada benda atau objek. </p>\n" +
                    "<p>Usaha yang dilakukan suatu objek didefinisikan sebagai perkalian antara jarak yang ditempuh dengan gaya yang searah dengan perpindahannya.</p>\n" +
                    "<p>Usaha dinotasikan dengan W yang merupakan singkatan bahasa Inggris dari Work yang berarti kerja.</p>\n" +
                    "<p>Satuan usaha adalah Joule yang didefinisikan sebagai besarnya energi yang dibutuhkan untuk memberi gaya sebesar satu Newton sejauh satu meter. </p>\n" +
                    "<p>Oleh sebab itu, 1 Joule sama dengan 1 Newton meter (N.m).</p>\n" +
                    "<br/>\n" +
                    "<p>Rumus Usaha dinotasikan dengan:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude1.setText(Html.fromHtml("<h3>Usaha</h3>\n" +
                    "<p class=\"fw-bolder\">Usaha adalah besarnya energi untuk merubah posisi yang diberikan gaya pada benda atau objek. </p>\n" +
                    "<p>Usaha yang dilakukan suatu objek didefinisikan sebagai perkalian antara jarak yang ditempuh dengan gaya yang searah dengan perpindahannya.</p>\n" +
                    "<p>Usaha dinotasikan dengan W yang merupakan singkatan bahasa Inggris dari Work yang berarti kerja.</p>\n" +
                    "<p>Satuan usaha adalah Joule yang didefinisikan sebagai besarnya energi yang dibutuhkan untuk memberi gaya sebesar satu Newton sejauh satu meter. </p>\n" +
                    "<p>Oleh sebab itu, 1 Joule sama dengan 1 Newton meter (N.m).</p>\n" +
                    "<br/>\n" +
                    "<p>Rumus Usaha dinotasikan dengan:</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude2.setText(Html.fromHtml("<p>W = Usaha yang dilakukan (Joule)</p>\n" +
                    "<p>F = Gaya yang diberikan (N)</p>\n" +
                    "<p>x = jarak perpindahan objek (m)</p>\n" +
                    "<br/>\n" +
                    "<p>Agar kamu dapat memahami konsep Usaha dengan baik, perhatikan gambar lintasan Usaha dan komponennya di bawah ini.</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude2.setText(Html.fromHtml("<p>W = Usaha yang dilakukan (Joule)</p>\n" +
                    "<p>F = Gaya yang diberikan (N)</p>\n" +
                    "<p>x = jarak perpindahan objek (m)</p>\n" +
                    "<br/>\n" +
                    "<p>Agar kamu dapat memahami konsep Usaha dengan baik, perhatikan gambar lintasan Usaha dan komponennya di bawah ini.</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude3.setText(Html.fromHtml("<p>Jika gaya yang diberikan pada objek membentuk sudut maka persamaannya menjadi:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude3.setText(Html.fromHtml("<p>Jika gaya yang diberikan pada objek membentuk sudut maka persamaannya menjadi:</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude4.setText(Html.fromHtml("<p>θ = sudut yang dibentuk gaya terhadap perpindahan.</p>\n" +
                    "<p>Nilai usaha dapat berupa positif atau negatif tergantung arah gaya terhadap perpindahannya. </p>\n" +
                    "<p>Jika gaya yang diberikan pada objek berlawanan arah dengan perpindahannya, maka usaha yang diberikan bernilai negatif.</p>\n" +
                    "<p>Jika gaya yang diberikan searah dengan perpindahan, maka objek tersebut melakukan usaha positif.</p>\n" +
                    "<br/>\n" +
                    "<p>Usaha juga dapat bernilai nol (0) atau objek tidak melakukan usaha jika,</p>\n" +
                    "<p>1. Diberikan gaya namun tidak terjadi perpindahan.</p>\n" +
                    "<p>2. Gaya yang diberikan tegak lurus dengan perpindahan (cos90 = 0)</p>\n" +
                    "<br/>\n" +
                    "<h3>Energi</h3>\n" +
                    "<p>Energi dalam pelajaran ini dapat diklasifikasikan menjadi energi <span class=\"fw-bolder\">kinetik, potensial dan mekanik.</span></p>\n" +
                    "<br/>\n" +
                    "<h4>Energi Kinetik</h4>\n" +
                    "<p>Energi Kinetik adalah energi gerak, energi yang dimiliki benda atau objek karena geraknya. Energi kinetik berasal dari kata Yunani kinetikos yang artinya bergerak. </p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude4.setText(Html.fromHtml("<p>θ = sudut yang dibentuk gaya terhadap perpindahan.</p>\n" +
                    "<p>Nilai usaha dapat berupa positif atau negatif tergantung arah gaya terhadap perpindahannya. </p>\n" +
                    "<p>Jika gaya yang diberikan pada objek berlawanan arah dengan perpindahannya, maka usaha yang diberikan bernilai negatif.</p>\n" +
                    "<p>Jika gaya yang diberikan searah dengan perpindahan, maka objek tersebut melakukan usaha positif.</p>\n" +
                    "<br/>\n" +
                    "<p>Usaha juga dapat bernilai nol (0) atau objek tidak melakukan usaha jika,</p>\n" +
                    "<p>1. Diberikan gaya namun tidak terjadi perpindahan.</p>\n" +
                    "<p>2. Gaya yang diberikan tegak lurus dengan perpindahan (cos90 = 0)</p>\n" +
                    "<br/>\n" +
                    "<h3>Energi</h3>\n" +
                    "<p>Energi dalam pelajaran ini dapat diklasifikasikan menjadi energi <span class=\"fw-bolder\">kinetik, potensial dan mekanik.</span></p>\n" +
                    "<br/>\n" +
                    "<h4>Energi Kinetik</h4>\n" +
                    "<p>Energi Kinetik adalah energi gerak, energi yang dimiliki benda atau objek karena geraknya. Energi kinetik berasal dari kata Yunani kinetikos yang artinya bergerak. </p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude5.setText(Html.fromHtml("<p>EK = Energi Kinetik benda (Joule)</p>\n" +
                    "<p>1/2m = massa benda (kg)</p>\n" +
                    "<p>v = kecepatan benda (m/s)</span>\n" +
                    "<p>Usaha merupakan besarnya energi. Pada konteks ini, usaha merupakan perubahan energi. Hubungan usaha dengan Energi Kinetik dinotasikan dengan:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude5.setText(Html.fromHtml("<p>EK = Energi Kinetik benda (Joule)</p>\n" +
                    "<p>1/2m = massa benda (kg)</p>\n" +
                    "<p>v = kecepatan benda (m/s)</span>\n" +
                    "<p>Usaha merupakan besarnya energi. Pada konteks ini, usaha merupakan perubahan energi. Hubungan usaha dengan Energi Kinetik dinotasikan dengan:</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude6.setText(Html.fromHtml("<p>W = Usaha yang dilakukan benda (Joule)</p>\n" +
                    "<p>EK = perubahan Energi Kinetik (Joule)</p>\n" +
                    "<p>v2^2-v1^2  = perubahan kecepatan (m/s^2)</p>\n" +
                    "<br/>\n" +
                    "<h4>Energi Potensial</h4>\n" +
                    "<p>Energi Potensial adalah energi yang dimiliki benda karena posisinya atau bentuk maupun susunannya.</p>\n" +
                    "<p>Energi Potensial disebabkan adanya gaya gravitasi. Suatu benda memiliki energi potensial yang besar jika massanya semakin besar dan ketinggiannya semakin tinggi.</p>\n" +
                    "<p>Rumus Energi Potensial dinotasikan dengan:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude6.setText(Html.fromHtml("<p>W = Usaha yang dilakukan benda (Joule)</p>\n" +
                    "<p>EK = perubahan Energi Kinetik (Joule)</p>\n" +
                    "<p>v2^2-v1^2  = perubahan kecepatan (m/s^2)</p>\n" +
                    "<br/>\n" +
                    "<h4>Energi Potensial</h4>\n" +
                    "<p>Energi Potensial adalah energi yang dimiliki benda karena posisinya atau bentuk maupun susunannya.</p>\n" +
                    "<p>Energi Potensial disebabkan adanya gaya gravitasi. Suatu benda memiliki energi potensial yang besar jika massanya semakin besar dan ketinggiannya semakin tinggi.</p>\n" +
                    "<p>Rumus Energi Potensial dinotasikan dengan:</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude7.setText(Html.fromHtml("<p>EP = Energi Potensial benda (Joule)</p>\n" +
                    "<p>g = kecepatan gravitasi (9,8 m/s^2)</p>\n" +
                    "<p>h = ketinggian benda (m)</p>\n" +
                    "<p>Hubungan usaha dengan Energi Potensial dinotasikan dengan:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude7.setText(Html.fromHtml("<p>EP = Energi Potensial benda (Joule)</p>\n" +
                    "<p>g = kecepatan gravitasi (9,8 m/s^2)</p>\n" +
                    "<p>h = ketinggian benda (m)</p>\n" +
                    "<p>Hubungan usaha dengan Energi Potensial dinotasikan dengan:</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude8.setText(Html.fromHtml("<p>h2-h1 = perubahan ketinggian (m)</p>\n" +
                    "<br/>\n" +
                    "<h4>Energi Mekanik</h4>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude8.setText(Html.fromHtml("<p>h2-h1 = perubahan ketinggian (m)</p>\n" +
                    "<br/>\n" +
                    "<h4>Energi Mekanik</h4>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude9.setText(Html.fromHtml("<p>Gabungan Energi kinetik dan potensial adalah energi mekanik.</p>\n" +
                    "<p>Energi Mekanik yang dimiliki suatu benda nilainya selalu konstan/tetap pada setiap titik lintasan benda, inilah yang disebut sebagai Hukum Kekekalan Energi. Energi tidak dapat diciptakan ataupun dimusnahkan, energi hanya dapat berubah bentuk dari satu bentuk ke bentuk lainnya. Maka persamaan Hukum kekekalan energi dinotasikan dengan:</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude9.setText(Html.fromHtml("<p>Gabungan Energi kinetik dan potensial adalah energi mekanik.</p>\n" +
                    "<p>Energi Mekanik yang dimiliki suatu benda nilainya selalu konstan/tetap pada setiap titik lintasan benda, inilah yang disebut sebagai Hukum Kekekalan Energi. Energi tidak dapat diciptakan ataupun dimusnahkan, energi hanya dapat berubah bentuk dari satu bentuk ke bentuk lainnya. Maka persamaan Hukum kekekalan energi dinotasikan dengan:</p>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanude10.setText(Html.fromHtml("<p>EM = Energi Mekanik benda (Joule)</p>\n" +
                    "<p>EM1 = energi mekanik di posisi 1</p>\n" +
                    "<p>EM2 = energi mekanik di posisi 2</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanude10.setText(Html.fromHtml("<p>EM = Energi Mekanik benda (Joule)</p>\n" +
                    "<p>EM1 = energi mekanik di posisi 1</p>\n" +
                    "<p>EM2 = energi mekanik di posisi 2</p>"));
        }

        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=W+%3D+F+%5Ccdot+x&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude1);
        Glide.with(getContext()).load("http://www.studiobelajar.com/wp-content/uploads/2015/11/ilustrasi-usaha-dan-energi.jpg").into(gambarude2);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=W+%3D+F+%5Ccos+%5Ctheta+%5Ccdot+s&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude3);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=EK+%3D+%5Cfrac%7B1%7D%7B2%7Dm+%5Ccdot+v%5E2&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude4);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=W+%3D+%5CDelta+EK+%3D+%5Cfrac%7B1%7D%7B2%7D+m+%28v_2%5E2+-+v_1%5E2%29&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude5);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=EP+%3D+mgh&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude6);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=W+%3D+%5CDelta+EP+%3D+mg%28h_2+-+h_1%29&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude7);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=EM+%3D+Ek+%2B+Ep&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude8);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=%5CDelta+%3D+0&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude9);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=EM_1+%3D+EM_2+%3D+konstan&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude92);
        Glide.with(getContext()).load("https://s0.wp.com/latex.php?latex=Ek_1+%2B+Ep_1+%3D+Ek_2+%2B+Ep_2&bg=f9f9f9&fg=000000&s=0&c=20201002").into(gambarude93);
        return view;
    }
}