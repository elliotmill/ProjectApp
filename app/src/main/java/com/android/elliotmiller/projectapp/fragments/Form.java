package com.android.elliotmiller.projectapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.elliotmiller.projectapp.R;

import com.android.elliotmiller.projectapp.models.Report;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FormInterface} interface
 * to handle interaction events.
 * Use the {@link Form#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Form extends Fragment {

    private FormInterface mListener;

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
        return inflater.inflate(R.layout.fragment_form, container, false);
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
