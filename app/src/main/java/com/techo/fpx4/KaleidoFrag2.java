package com.techo.fpx4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BulletSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.techo.fpx4.KaleidoEventActivity.ToFragmentK;

public class KaleidoFrag2 extends SherlockFragment implements ToFragmentK {

    String empty = "0";

    String INFO;
    String WORKS_LAYOUT;
    String KIT;

    TextView info_i;
    TextView works_layout_i;
    TextView kit_i;

    String str_works_layout;
    String str_kit;

    SpannableStringBuilder sb_works_layout = new SpannableStringBuilder();
    SpannableStringBuilder sb_kit = new SpannableStringBuilder();


    public static Fragment newInstance() {
        return new KaleidoFrag2();
    }


    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            this.INFO = savedInstanceState.getString("info");
            this.WORKS_LAYOUT = savedInstanceState.getString("works_layout");
            this.KIT = savedInstanceState.getString("kit");

            Log.v(getTag(), "frag 2 Oncreate savedInstanceState!=null ");
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_kaleido_2, container, false);

        this.setRetainInstance(true);

        info_i = (TextView) view.findViewById(R.id.info_i);
        works_layout_i = (TextView) view.findViewById(R.id.works_layout_i);
        kit_i = (TextView) view.findViewById(R.id.kit_i);

        RelativeLayout works_layout_l = (RelativeLayout) view.findViewById(R.id.works_layout_l);
        RelativeLayout kit_l = (RelativeLayout) view.findViewById(R.id.kit_l);


        if (WORKS_LAYOUT.equals(empty)) {

            works_layout_l.setVisibility(View.GONE);
        } else {

            str_works_layout = WORKS_LAYOUT;

            String[] list_works_layout = str_works_layout.split("\n");  //split the string on the delimiter

            SpannableString span_works_layout = new SpannableString(str_works_layout); //create the spannablestring

            int spanPosition_works_layout = 0; //we'll need to keep track of our start position


            for (int i = 0; i < list_works_layout.length; i++) {

                span_works_layout.setSpan(new BulletSpan(5), spanPosition_works_layout, spanPosition_works_layout + list_works_layout[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                sb_works_layout.append(span_works_layout, spanPosition_works_layout, spanPosition_works_layout + list_works_layout[i].length());
                sb_works_layout.append("\n\n");
                spanPosition_works_layout += list_works_layout[i].length() + 1;
            }

            sb_works_layout.delete(sb_works_layout.length() - 2, sb_works_layout.length());

        }


        if (KIT.equals(empty)) {
            kit_l.setVisibility(View.GONE);
        } else {

            //spannable for Judging Criteria

            str_kit = KIT;

            String[] list_kit = str_kit.split("\n");  //split the string on the delimiter

            SpannableString span_kit = new SpannableString(str_kit); //create the spannablestring

            int spanPosition_kit = 0; //we'll need to keep track of our start position

            String elems = "Elimination Round:",
                    finalround = "Final Round:",
                    expl = "Explanation/Description:",
                    run_rel = "Run Related:",
                    task = "Task Completed:";

            for (int i = 0; i < list_kit.length; i++) {

                span_kit.setSpan(new BulletSpan(10), spanPosition_kit, spanPosition_kit + list_kit[i].length(), 0);
                sb_kit.append(span_kit, spanPosition_kit, spanPosition_kit + list_kit[i].length());
                sb_kit.append("\n\n");
                spanPosition_kit += list_kit[i].length() + 1;

            }
            sb_kit.delete(sb_kit.length() - 2, sb_kit.length());

        }

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        if (!INFO.equals(empty))
            info_i.setText(INFO);

        if (!WORKS_LAYOUT.equals(empty))
            works_layout_i.setText(sb_works_layout);

        if (!KIT.equals(empty))
            kit_i.setText(sb_kit);

    }


    @Override
    public void dataToFragmentK1(
            String PHOTO,
            String DATE_VENUE,
            String TEAM_I,
            String FEES_I,
            String INCHR_NUM_1,
            String INCHR_NUM_2,
            String INCHR_NAME_1,
            String INCHR_NAME_2,
            String INCHR_EMAIL_1,
            String INCHR_EMAIL_2) {
    }

    @Override
    public void dataToFragmentK2(
            String INFO,
            String WORKS_LAYOUT,
            String KIT
    ) {

        this.INFO = INFO;
        this.WORKS_LAYOUT = WORKS_LAYOUT;
        this.KIT = KIT;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("info", INFO);
        savedInstanceState.putString("works_layout", WORKS_LAYOUT);
        savedInstanceState.putString("kit", KIT);


        Log.v(getTag(), "frag2 saveInstanceState ");
    }

}
