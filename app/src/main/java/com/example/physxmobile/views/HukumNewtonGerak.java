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
 * Use the {@link HukumNewtonGerak#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HukumNewtonGerak extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HukumNewtonGerak() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HukumNewtonGerak.
     */
    // TODO: Rename and change types and number of parameters
    public static HukumNewtonGerak newInstance(String param1, String param2) {
        HukumNewtonGerak fragment = new HukumNewtonGerak();
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
        View view = inflater.inflate(R.layout.fragment_hukum_newton_gerak, container, false);

        TextView penjelasanhng1 = view.findViewById(R.id.penjelasanhng1);
        TextView penjelasanhng2 = view.findViewById(R.id.penjelasanhng2);
        TextView penjelasanhng3 = view.findViewById(R.id.penjelasanhng3);
        TextView penjelasanhng4 = view.findViewById(R.id.penjelasanhng4);

        ImageView gambarhng1 = view.findViewById(R.id.gambarhng1);
        ImageView gambarhng2 = view.findViewById(R.id.gambarhng2);
        ImageView gambarhng3 = view.findViewById(R.id.gambarhng3);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanhng1.setText(Html.fromHtml("<p>Hukum Newton terkait gerak ada tiga: Hukum Newton I, Hukum Newton II, dan Hukum Newton III.</p>\n" +
                    "<h3>Hukum 1 Newton</h3>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanhng1.setText(Html.fromHtml("<p>Hukum Newton terkait gerak ada tiga: Hukum Newton I, Hukum Newton II, dan Hukum Newton III.</p>\n" +
                    "<h3>Hukum 1 Newton</h3>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanhng2.setText(Html.fromHtml("<p>Hukum I Newton berbunyi “jika resultan gaya yang bekerja pada benda sama dengan nol maka benda yang mula-mula diam akan tetap diam dan benda yang mula-mula bergerak lurus beraturan akan tetap bergerak lurus beraturan”.</p>\n" +
                    "<br/>\n" +
                    "<h3>Hukum 2 Newton</h3>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanhng2.setText(Html.fromHtml("<p>Hukum I Newton berbunyi “jika resultan gaya yang bekerja pada benda sama dengan nol maka benda yang mula-mula diam akan tetap diam dan benda yang mula-mula bergerak lurus beraturan akan tetap bergerak lurus beraturan”.</p>\n" +
                    "<br/>\n" +
                    "<h3>Hukum 2 Newton</h3>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanhng3.setText(Html.fromHtml("<p>HK II Newton berbunyi “Jika ada resultan gaya yang bekerja pada sebuah benda, maka akan dihasilkan suatu percepatan dalam arah yang sama dengan resultan gaya. Besarnya percepatan tersebut berbanding lurus terhadap resultan gaya dan berbanding terbalik terhadap massa bendanya”</p>\n" +
                    "<br/>\n" +
                    "<h3>Hukum 3 Newton</h3>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanhng3.setText(Html.fromHtml("<p>HK II Newton berbunyi “Jika ada resultan gaya yang bekerja pada sebuah benda, maka akan dihasilkan suatu percepatan dalam arah yang sama dengan resultan gaya. Besarnya percepatan tersebut berbanding lurus terhadap resultan gaya dan berbanding terbalik terhadap massa bendanya”</p>\n" +
                    "<br/>\n" +
                    "<h3>Hukum 3 Newton</h3>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            penjelasanhng4.setText(Html.fromHtml("<p>HK III Newton berbunyi “Jika benda I mengerjakan gaya terhadap benda II maka benda II mengerjakan gaya pada benda I yang besarnya sama, tetapi dengan arah yang berlawanan dengan arah gaya dari benda I”</p>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            penjelasanhng4.setText(Html.fromHtml("<p>HK III Newton berbunyi “Jika benda I mengerjakan gaya terhadap benda II maka benda II mengerjakan gaya pada benda I yang besarnya sama, tetapi dengan arah yang berlawanan dengan arah gaya dari benda I”</p>"));
        }

        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/HK%201%20Newton.jpg?width=600&name=HK%201%20Newton.jpg").into(gambarhng1);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/HK%20II%20Newton.jpg?width=600&name=HK%20II%20Newton.jpg").into(gambarhng2);
        Glide.with(getContext()).load("https://www.ruangguru.com/hs-fs/hubfs/HK%20III%20Newton.jpg?width=600&name=HK%20III%20Newton.jpg").into(gambarhng3);

        return view;
    }
}