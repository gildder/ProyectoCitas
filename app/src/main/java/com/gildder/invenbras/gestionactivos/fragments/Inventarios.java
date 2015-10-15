package com.gildder.invenbras.gestionactivos.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gildder.invenbras.gestionactivos.MyInventarioActivity;
import com.gildder.invenbras.gestionactivos.R;
import com.gildder.invenbras.gestionactivos.Utils.Util;
import com.gildder.invenbras.gestionactivos.adapters.InventarioAdapter;
import com.gildder.invenbras.gestionactivos.models.Inventario;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.Random;


public class Inventarios extends Fragment {

    public Inventarios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventarios, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Inventario> inventarios = new ArrayList<Inventario>();

        for (int i=0;i<10;i++) {
            Inventario inventario = new Inventario();
            inventario.setId(i);
            inventario.setNombre("Inventario "+i);
            inventario.setDescripcion("descripcion "+i);
            inventario.setPrioridad((String.valueOf( new Random().nextInt(3)+1)));


            inventarios.add(inventario);
        }


        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.RclInventario);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new InventarioAdapter(inventarios, R.layout.row_inventario));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


   //     TaskInventario tarea = new TaskInventario();
     //   tarea.execute();

    }

    /**
     * Clase Tarea
     */
/*
    public class TaskInventario extends AsyncTask<String,Integer,Boolean> {
        private Inventario[] inventarios;

        final static String METHOD_NAME = "ObtenerInventarioXml";
        final static String SOAP_ACTION = "http://inventario.pre/ObtenerInventarioXml";


        @Override
        protected Boolean doInBackground(String... params) {
            boolean result = true;

            //modelo del request
            SoapObject request = new SoapObject(Util.NAMESPACE,Util.URL);

            //modelo envolepe
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.dotNet = true;

            envelope.setOutputSoapObject(request);

            //modo de transporte
            HttpTransportSE transportSE = new HttpTransportSE(Util.URL);

            try {
                transportSE.call(SOAP_ACTION, envelope);

                SoapObject resSoap = (SoapObject) envelope.getResponse();

                inventarios = new Inventario[resSoap.getPropertyCount()];


                for (int i = 0; i<inventarios.length; i++){
                    SoapObject ic = (SoapObject) resSoap.getProperty(i);

                    Inventario inventario = new Inventario();
                    inventario.setId(Integer.parseInt(ic.getProperty(0).toString()));
                    inventario.setNombre(ic.getProperty(1).toString());
                    inventario.setDescripcion(ic.getProperty(2).toString());
                    inventario.setPrioridad(ic.getProperty(3).toString());

                    //añadimos a la lista de inventarios
                    inventarios[i] = inventario;
                }


            }catch (Exception ex){
                Log.e("ERROR...", ex.getMessage());
            }
            return result;
        }

        protected void onPostExecute(Boolean result) {

            if (result)
            {

                ArrayList<Inventario> ListaInventarios = new ArrayList<Inventario>();

                for (int i=0; i<inventarios.length; i++) {
                    ListaInventarios.add(inventarios[i]);
                }


                //llemamos el RecyclerView
                RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.RclInventario);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(new InventarioAdapter(ListaInventarios, R.layout.row_inventario));
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }
            else
            {

            }
        }


    }//fin clase Task
    */
}
