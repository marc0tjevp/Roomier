package com.yanco.roomier.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanco.roomier.MainActivity;
import com.yanco.roomier.R;
import com.yanco.roomier.datalayer.dao.EventDAO;
import com.yanco.roomier.datalayer.dao.SqlLiteEventDAO;
import com.yanco.roomier.datalayer.factories.DAOFactory;
import com.yanco.roomier.datalayer.factories.SqlLiteDAOFactory;

public class eventFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    DAOFactory SqlLiteDaoFactory;
    EventDAO eventDAO;

    public eventFragment() {
    }

    public static eventFragment newInstance() {
        return new eventFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_event, container, false);

        if (mListener != null) {
            mListener.onFragmentInteraction("Events");
        }

        eventDAO.getAllEvents();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        SqlLiteDaoFactory = new SqlLiteDAOFactory(context);
        eventDAO = SqlLiteDaoFactory.getEventDAO();

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
