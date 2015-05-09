package com.techo.fpx4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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

public class TabFragment2 extends SherlockFragment implements ToFragment {

    String empty = "0";

    String ROUNDS_I;
    String JUDG_CRIT_I;
    String ABSTRACT_I;

    TextView rounds_i;
    TextView judg_crit_i;
    TextView abstract_i;


    String str_rounds;
    String str_judg_crit;
    String str_abstract;

    SpannableStringBuilder sb_rounds = new SpannableStringBuilder();
    SpannableStringBuilder sb_judg_crit = new SpannableStringBuilder();
    SpannableStringBuilder sb_abstract = new SpannableStringBuilder();


    public static Fragment newInstance() {
        return new TabFragment2();
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
            this.ROUNDS_I = savedInstanceState.getString("rounds");
            this.JUDG_CRIT_I = savedInstanceState.getString("judg_crit");
            this.ABSTRACT_I = savedInstanceState.getString("abstract");

            Log.v(getTag(), "frag 2 Oncreate savedInstanceState!=null ");
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_2, container, false);

        this.setRetainInstance(true);

        rounds_i = (TextView) view.findViewById(R.id.rounds_i);
        judg_crit_i = (TextView) view.findViewById(R.id.judg_crit_i);
        abstract_i = (TextView) view.findViewById(R.id.abstract_i);

        RelativeLayout rounds_l = (RelativeLayout) view.findViewById(R.id.rounds_l);
        RelativeLayout judg_crit_l = (RelativeLayout) view.findViewById(R.id.judg_crit_l);
        RelativeLayout abstract_l = (RelativeLayout) view.findViewById(R.id.abstract_l);


        if (ROUNDS_I.equals(empty)) {

            rounds_l.setVisibility(View.GONE);
        } else {

            str_rounds = ROUNDS_I;

            String[] list_rounds = str_rounds.split("\n");  //split the string on the delimiter

            SpannableString span_rounds = new SpannableString(str_rounds); //create the spannablestring

            int spanPosition_rounds = 0; //we'll need to keep track of our start position

            String round1 = "Round 1:",
                    round2 = "Round 2:",
                    round3 = "Round 3:",
                    round4 = "Round 4:",
                    elems = "Elimination Round:",
                    finalround = "Final Round:",
                    judginground = "Judging Round:",
                    r1_elems = "Round 1: Qualifying Round",
                    phase1 = "Phase 1:",
                    phase2 = "Phase 2:",
                    phase3 = "Phase 3:",
                    qual = "Qualifying Round:",
                    note = "Note:",
                    r1_elems1 = "Round 1: Online Elimnation",
                    elems2 = "Online Elimination:";


            for (int i = 0; i < list_rounds.length; i++) {

                if (list_rounds[i].equals(round1) || list_rounds[i].equals(round2) || list_rounds[i].equals(round3) || list_rounds[i].equals(round4) || list_rounds[i].equals(elems) || list_rounds[i].equals(finalround) || list_rounds[i].equals(judginground) || list_rounds[i].equals(r1_elems) || list_rounds[i].equals(phase1) || list_rounds[i].equals(phase2) || list_rounds[i].equals(phase3) || list_rounds[i].equals(qual) || list_rounds[i].equals(note) || list_rounds[i].equals(r1_elems1) || list_rounds[i].equals(elems2)) {

                    //sb_rounds.append("\n");
                    span_rounds.setSpan(new RelativeSizeSpan(1.30f), spanPosition_rounds, spanPosition_rounds + list_rounds[i].length(), 0);
                    span_rounds.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), spanPosition_rounds, spanPosition_rounds + list_rounds[i].length(), 0);
                    span_rounds.setSpan(new UnderlineSpan(), spanPosition_rounds, spanPosition_rounds + list_rounds[i].length(), 0);

                    sb_rounds.append(span_rounds, spanPosition_rounds, spanPosition_rounds + list_rounds[i].length());
                    sb_rounds.append("\n\n");

                    spanPosition_rounds += list_rounds[i].length() + 1;
                } else {

                    span_rounds.setSpan(new BulletSpan(5), spanPosition_rounds, spanPosition_rounds + list_rounds[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    sb_rounds.append(span_rounds, spanPosition_rounds, spanPosition_rounds + list_rounds[i].length());
                    sb_rounds.append("\n\n");
                    spanPosition_rounds += list_rounds[i].length() + 1;
                }


            }

            sb_rounds.delete(sb_rounds.length() - 2, sb_rounds.length());

        }

        if (JUDG_CRIT_I.equals(empty)) {
            judg_crit_l.setVisibility(View.GONE);
        } else {

            //spannable for Judging Criteria

            str_judg_crit = JUDG_CRIT_I;

            String[] list_judg_crit = str_judg_crit.split("\n");  //split the string on the delimiter

            SpannableString span_judg_crit = new SpannableString(str_judg_crit); //create the spannablestring

            int spanPosition_judg_crit = 0; //we'll need to keep track of our start position

            String elems = "Elimination Round:",
                    finalround = "Final Round:",
                    expl = "Explanation/Description:",
                    run_rel = "Run Related:",
                    task = "Task Completed:";

            for (int i = 0; i < list_judg_crit.length; i++) {

                if (list_judg_crit[i].equals(elems) || list_judg_crit[i].equals(finalround) || list_judg_crit[i].equals(expl) || list_judg_crit[i].equals(run_rel) || list_judg_crit[i].equals(task)) {


                    span_judg_crit.setSpan(new RelativeSizeSpan(1.30f), spanPosition_judg_crit, spanPosition_judg_crit + list_judg_crit[i].length(), 0);
                    span_judg_crit.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), spanPosition_judg_crit, spanPosition_judg_crit + list_judg_crit[i].length(), 0);
                    span_judg_crit.setSpan(new UnderlineSpan(), spanPosition_judg_crit, spanPosition_judg_crit + list_judg_crit[i].length(), 0);

                    sb_judg_crit.append(span_judg_crit, spanPosition_judg_crit, spanPosition_judg_crit + list_judg_crit[i].length());
                    sb_judg_crit.append("\n\n");

                    spanPosition_judg_crit += list_judg_crit[i].length() + 1;
                } else {
                    span_judg_crit.setSpan(new BulletSpan(10), spanPosition_judg_crit, spanPosition_judg_crit + list_judg_crit[i].length(), 0);
                    sb_judg_crit.append(span_judg_crit, spanPosition_judg_crit, spanPosition_judg_crit + list_judg_crit[i].length());
                    sb_judg_crit.append("\n\n");
                    spanPosition_judg_crit += list_judg_crit[i].length() + 1;
                }

            }
            sb_judg_crit.delete(sb_judg_crit.length() - 2, sb_judg_crit.length());

        }


        if (ABSTRACT_I.equals(empty)) {
            abstract_l.setVisibility(View.GONE);
        } else {

            //spannable of abstract detaisl

            str_abstract = ABSTRACT_I;

            String[] list_abstract = str_abstract.split("\n");  //split the string on the delimiter

            SpannableString span_abstract = new SpannableString(str_abstract); //create the spannablestring

            int spanPosition_abstract = 0; //we'll need to keep track of our start position
            String abs_details = "Abstract Details:",
                    abs_specs = "Abstract Specifications:",
                    note = "Note:",
                    abs_sample = "Sample topics for paper presentation:";


            for (int i = 0; i < list_abstract.length; i++) {

                if (list_abstract[i].equals(abs_details) || list_abstract[i].equals(abs_specs) || list_abstract[i].equals(note) || list_abstract[i].equals(abs_sample)) {


                    span_abstract.setSpan(new RelativeSizeSpan(1.30f), spanPosition_abstract, spanPosition_abstract + list_abstract[i].length(), 0);
                    span_abstract.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), spanPosition_abstract, spanPosition_abstract + list_abstract[i].length(), 0);
                    span_abstract.setSpan(new UnderlineSpan(), spanPosition_abstract, spanPosition_abstract + list_abstract[i].length(), 0);

                    sb_abstract.append(span_abstract, spanPosition_abstract, spanPosition_abstract + list_abstract[i].length());
                    sb_abstract.append("\n\n");

                    spanPosition_abstract += list_abstract[i].length() + 1;
                } else {
                    span_abstract.setSpan(new BulletSpan(10), spanPosition_abstract, spanPosition_abstract + list_abstract[i].length(), 0);

                    sb_abstract.append(span_abstract, spanPosition_abstract, spanPosition_abstract + list_abstract[i].length());
                    sb_abstract.append("\n\n");
                    spanPosition_abstract += list_abstract[i].length() + 1;
                }
            }

            sb_abstract.delete(sb_abstract.length() - 2, sb_abstract.length());
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!ROUNDS_I.equals(empty))
            rounds_i.setText(sb_rounds);

        if (!JUDG_CRIT_I.equals(empty))
            judg_crit_i.setText(sb_judg_crit);

        if (!ABSTRACT_I.equals(empty))
            abstract_i.setText(sb_abstract);

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
            String INCHR_EMAIL_2) {

    }

    @Override
    public void dataToFragment2(
            String ROUNDS_I,
            String JUDG_CRIT_I,
            String ABSTRACT_I
    ) {
        this.ROUNDS_I = ROUNDS_I;
        this.JUDG_CRIT_I = JUDG_CRIT_I;
        this.ABSTRACT_I = ABSTRACT_I;
    }

    @Override
    public void dataToFragment3(
            String RULES_I,
            String SPECS_I
    ) {
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("rounds", ROUNDS_I);
        savedInstanceState.putString("judg_crit", JUDG_CRIT_I);
        savedInstanceState.putString("abstract", ABSTRACT_I);


        Log.v(getTag(), "frag2 saveInstanceState ");
    }

}