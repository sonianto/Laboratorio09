package ar.edu.utn.frsf.isi.dam.laboratorio09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sonia on 2/12/2016.
 */
public class AdapterDatos extends BaseAdapter {
    private List<acelerar> lista;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterDatos(List<acelerar> lista, Context context) {
        super();
        this.lista = lista;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= layoutInflater.inflate(R.layout.row, null);
        TextView txtx=(TextView)view.findViewById(R.id.HMX);
        txtx.setText(lista.get(i).getHoraX());
        TextView txty=(TextView)view.findViewById(R.id.HMX);
        txty.setText(lista.get(i).getHoraY());
        TextView txtz=(TextView)view.findViewById(R.id.HMX);
        txtz.setText(lista.get(i).getHoraZ());
        return view;
    }
}
