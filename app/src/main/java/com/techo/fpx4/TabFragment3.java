package com.techo.fpx4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.techo.fpx4.EventActivity.ToFragment;

public class TabFragment3 extends SherlockFragment implements ToFragment {

    String empty = "0";

    String RULES_I;
    String SPECS_I;

    TextView rules_i;
    TextView specs_i;

    String str_rules;
    String str_specs;

    SpannableStringBuilder sb_rules = new SpannableStringBuilder();
    SpannableStringBuilder sb_specs = new SpannableStringBuilder();

    public static Fragment newInstance() {
        return new TabFragment3();
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
            this.RULES_I = savedInstanceState.getString("rules");
            this.SPECS_I = savedInstanceState.getString("specs");

            Log.v(getTag(), "frag 3 Oncreate savedInstanceState!=null ");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_3, container, false);

        this.setRetainInstance(true);

        rules_i = (TextView) view.findViewById(R.id.rules_i);
        specs_i = (TextView) view.findViewById(R.id.specs_i);

        RelativeLayout rules_l = (RelativeLayout) view.findViewById(R.id.rules_l);
        RelativeLayout specs_l = (RelativeLayout) view.findViewById(R.id.specs_l);


        if (RULES_I.equals(empty)) {

            rules_l.setVisibility(View.GONE);
        } else {

            //spannable rules

            str_rules = RULES_I;

            String[] list_rules = str_rules.split("\n");  //split the string on the delimiter

            SpannableString span_rules = new SpannableString(str_rules); //create the spannablestring

            int spanPosition_rules = 0; //we'll need to keep track of our start position

            String fabri = "Fabrication:",
                    elems = "Elimination Round:",
                    finalround = "Final Round:",
                    game_sett = "Game Settings:",
                    car_sett = "Car Settings:",
                    note = "Note:",
                    appr_gren = "Approved Grenade Amounts Per Round:";


            for (int i = 0; i < list_rules.length; i++) {

                if (list_rules[i].equals(fabri) || list_rules[i].equals(elems) || list_rules[i].equals(finalround) || list_rules[i].equals(game_sett) || list_rules[i].equals(car_sett) || list_rules[i].equals(note) || list_rules[i].equals(appr_gren)) {


                    span_rules.setSpan(new RelativeSizeSpan(1.30f), spanPosition_rules, spanPosition_rules + list_rules[i].length(), 0);
                    span_rules.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), spanPosition_rules, spanPosition_rules + list_rules[i].length(), 0);
                    span_rules.setSpan(new UnderlineSpan(), spanPosition_rules, spanPosition_rules + list_rules[i].length(), 0);

                    sb_rules.append(span_rules, spanPosition_rules, spanPosition_rules + list_rules[i].length());
                    sb_rules.append("\n\n");

                    spanPosition_rules += list_rules[i].length() + 1;
                } else {
                    span_rules.setSpan(new BulletSpan(10), spanPosition_rules, spanPosition_rules + list_rules[i].length(), 0);
                    sb_rules.append(span_rules, spanPosition_rules, spanPosition_rules + list_rules[i].length());
                    sb_rules.append("\n\n");
                    spanPosition_rules += list_rules[i].length() + 1;
                }
            }
            sb_rules.delete(sb_rules.length() - 2, sb_rules.length());

        }


        if (SPECS_I.equals(empty)) {

            specs_l.setVisibility(View.GONE);
        } else {

            //spannable specs


            str_specs = SPECS_I;

            String[] list_specs = str_specs.split("\n");  //split the string on the delimiter

            SpannableString span_specs = new SpannableString(str_specs); //create the spannablestring

            int spanPosition_specs = 0; //we'll need to keep track of our start position

            String sample_topics = "Sample topics for presentation:",
                    mat_spec = "Material Specification:",
                    note = "Note:";


            for (int i = 0; i < list_specs.length; i++) {

                if (list_specs[i].equals(sample_topics) || list_specs[i].equals(mat_spec) || list_specs[i].equals(note)) {

                    //sb_specs.append("\n");
                    span_specs.setSpan(new RelativeSizeSpan(1.30f), spanPosition_specs, spanPosition_specs + list_specs[i].length(), 0);
                    span_specs.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), spanPosition_specs, spanPosition_specs + list_specs[i].length(), 0);
                    span_specs.setSpan(new UnderlineSpan(), spanPosition_specs, spanPosition_specs + list_specs[i].length(), 0);

                    sb_specs.append(span_specs, spanPosition_specs, spanPosition_specs + list_specs[i].length());
                    sb_specs.append("\n\n");

                    spanPosition_specs += list_specs[i].length() + 1;
                } else {

                    span_specs.setSpan(new BulletSpan(10), spanPosition_specs, spanPosition_specs + list_specs[i].length(), 0);
                    sb_specs.append(span_specs, spanPosition_specs, spanPosition_specs + list_specs[i].length());
                    sb_specs.append("\n\n");
                    spanPosition_specs += list_specs[i].length() + 1;
                }

            }

            sb_specs.delete(sb_specs.length() - 2, sb_specs.length());

        }


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        if (!RULES_I.equals(empty))
            rules_i.setText(sb_rules);
        if (!SPECS_I.equals(empty))
            specs_i.setText(sb_specs);

    }


    @Override
    public void dataToFragment1(
            String PROB_STMNT_I,
            String TEAM_I,
            String FEES_I,
            String INCHR_NUM_1,
            String INCHR_NUM_2,
            String INCHR_NAME_1,
            String INCHR_NAME_2,
            String INCHR_EMAIL_1,
            String INCHR_EMAIL_2
    ) {
    }

    @Override
    public void dataToFragment2(
            String ROUNDS_I,
            String JUDG_CRIT_I,
            String ABSTRACT_I
    ) {
    }

    @Override
    public void dataToFragment3(
            String RULES_I,
            String SPECS_I
    ) {

        this.RULES_I = RULES_I;
        this.SPECS_I = SPECS_I;
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("rules", RULES_I);
        savedInstanceState.putString("specs", SPECS_I);


        Log.v(getTag(), "frag3 saveInstanceState ");
    }


}