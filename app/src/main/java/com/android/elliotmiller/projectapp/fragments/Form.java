package com.android.elliotmiller.projectapp.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.elliotmiller.projectapp.R;
import com.android.elliotmiller.projectapp.models.Report;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FormInterface} interface
 * to handle interaction events.
 * Use the {@link Form#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Form extends Fragment implements View.OnClickListener {

    private FormInterface mListener;
    private EditText et_activity, et_miles, et_date;
    private Button btn_add;
    private Calendar mCalendar = Calendar.getInstance();

    public Form() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Form.
     */
    public static Form newInstance() {
        Form fragment = new Form();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        et_activity = view.findViewById(R.id.et_activity);
        et_miles = view.findViewById(R.id.et_miles);
        et_date = view.findViewById(R.id.et_date);
        et_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        mCalendar.set(Calendar.YEAR, year);
                        mCalendar.set(Calendar.MONTH, month);
                        mCalendar.set(Calendar.DAY_OF_MONTH, day);
                        updateLabel();
                    }
                }, mCalendar
                        .get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                        mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        btn_add = view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FormInterface) {
            mListener = (FormInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FormInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add: {
                if(inputsValid()){
                    mListener.sumbitReport(new Report(
                            et_activity.getText().toString(),
                            et_miles.getText().toString(),
                            et_date.getText().toString()
                    ));
                }
                break;
            }
        }
    }

    private boolean inputsValid() {
        boolean valid = true;
        if (TextUtils.isEmpty(et_activity.getText().toString())) {
            valid = false;
            et_activity.setError("Enter an Activity");
        }
        if (TextUtils.isEmpty(et_miles.getText().toString())) {
            valid = false;
            et_miles.setError("Enter Miles");
        }
        if (TextUtils.isEmpty(et_date.getText().toString())) {
            valid = false;
            et_date.setError("Enter Date");
        }
        return valid;
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        et_date.setError(null);
        et_date.setText(sdf.format(mCalendar.getTime()));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other com.android.elliotmiller.projectapp.fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface FormInterface {
        void sumbitReport(Report report);
    }
}
