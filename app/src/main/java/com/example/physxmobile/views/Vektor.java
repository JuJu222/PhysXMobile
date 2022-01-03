package com.example.physxmobile.views;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.physxmobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Vektor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Vektor extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Vektor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Vektor.
     */
    // TODO: Rename and change types and number of parameters
    public static Vektor newInstance(String param1, String param2) {
        Vektor fragment = new Vektor();
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
        View view = inflater.inflate(R.layout.fragment_vektor, container, false);

        TextView penjelasanv1 = view.findViewById(R.id.penjelasanv1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanv1.setText(Html.fromHtml("<p>Besaran dapat memiliki arah dan tidak.</p>\n" +
                    "<p>Besaran yang memiliki arah disebut sebagai besaran <span class=\"fw-bolder\">vektor</span>.</p>\n" +
                    "<p>Sedangkan, besaran yang tidak memiliki arah disebut sebagai besaran <span class=\"fw-bolder\">skalar</span>.</p>\n" +
                    "<p>Sehingga, besaran skalar hanya memiliki nilai dan selalu positif, namun besaran vektor adalah besaran yang mempunyai nilai dan arah.</p>\n" +
                    "<br/>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanv1.setText(Html.fromHtml("<p>Besaran dapat memiliki arah dan tidak.</p>\n" +
                    "<p>Besaran yang memiliki arah disebut sebagai besaran <span class=\"fw-bolder\">vektor</span>.</p>\n" +
                    "<p>Sedangkan, besaran yang tidak memiliki arah disebut sebagai besaran <span class=\"fw-bolder\">skalar</span>.</p>\n" +
                    "<p>Sehingga, besaran skalar hanya memiliki nilai dan selalu positif, namun besaran vektor adalah besaran yang mempunyai nilai dan arah.</p>\n" +
                    "<br/>"));
        }

        return view;
    }
}