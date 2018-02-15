package com.yanco.roomier.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanco.roomier.R;
import com.yanco.roomier.datalayer.dao.TaskDAO;
import com.yanco.roomier.datalayer.factories.DAOFactory;
import com.yanco.roomier.datalayer.factories.SqlLiteDAOFactory;

public class taskFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private DAOFactory SqlLiteDAOFactory;
    private TaskDAO taskDAO;

    public taskFragment() {}

    public static taskFragment newInstance() {
        return new taskFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_task, container, false);

        if (mListener != null) {
            mListener.onFragmentInteraction("Tasks");
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        SqlLiteDAOFactory = new SqlLiteDAOFactory(context);
        taskDAO = SqlLiteDAOFactory.getTaskDAO();

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String title);
    }
}
