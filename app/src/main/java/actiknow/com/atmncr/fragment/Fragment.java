package actiknow.com.atmncr.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import actiknow.com.atmncr.R;

public class Fragment extends android.support.v4.app.Fragment {
    // Store instance variables
    private String question;
    private int question_id;
    private int page;

    private Switch switchYesNo;

    // newInstance constructor for creating fragment with arguments
    public static Fragment newInstance (int page, String question, int question_id) {
        Fragment fragmentFirst = new Fragment ();
        Bundle args = new Bundle ();
        args.putInt ("page_number", page);
        args.putString ("question", question);
        args.putInt ("question_id", question_id);
        fragmentFirst.setArguments (args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        page = getArguments ().getInt ("page_number", 0);
        question = getArguments ().getString ("question");
        question_id = getArguments ().getInt ("question_id");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_first, container, false);
        TextView tvQuestion = (TextView) view.findViewById (R.id.tvQuestion);
        switchYesNo = (Switch) view.findViewById (R.id.switchYesNo);
        tvQuestion.setText (question);

        switchYesNo.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
                Log.d ("question ", "" + question);
                Log.d ("question_id ", "" + question_id);
            }
        });

//        Log.d ("question ", "" + question);
//        Log.d ("question_id ", "" + question_id);




        return view;
    }
}