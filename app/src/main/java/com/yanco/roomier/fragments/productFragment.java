package com.yanco.roomier.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yanco.roomier.R;
import com.yanco.roomier.datalayer.dao.ProductDAO;
import com.yanco.roomier.datalayer.factories.DAOFactory;
import com.yanco.roomier.datalayer.factories.SqlLiteDAOFactory;
import com.yanco.roomier.model.Event;
import com.yanco.roomier.model.Product;

import java.util.ArrayList;
import java.util.List;

public class productFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    DAOFactory SqlLiteDaoFactory;
    ProductDAO productDAO;

    public productFragment() {
    }

    public static productFragment newInstance() {
        return new productFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        if (mListener != null) {
            mListener.onFragmentInteraction("Products");
        }

        ListView lv = (ListView) view.findViewById(R.id.productListView);

        ArrayList<Product> products = (ArrayList<Product>) productDAO.getAllProducts();

        ArrayAdapter<Product> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, products);

        lv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        SqlLiteDaoFactory = new SqlLiteDAOFactory(context);
        productDAO = SqlLiteDaoFactory.getProductDAO();


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
