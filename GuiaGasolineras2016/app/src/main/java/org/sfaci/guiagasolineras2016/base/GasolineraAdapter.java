package org.sfaci.guiagasolineras2016.base;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.sfaci.guiagasolineras2016.R;

/**
 * Adapter para listar las gasolineras en la pantalla
 * @author Santiago Faci
 * @version curso 2014-2015
 */
public class GasolineraAdapter extends ArrayAdapter<Gasolinera> {
	
	private Context contexto;
	private int layoutId;
	private List<Gasolinera> datos;

	public GasolineraAdapter(Context contexto, int layoutId, List<Gasolinera> datos) {
		super(contexto, layoutId, datos);
		
		this.contexto = contexto;
		this.layoutId = layoutId;
		this.datos = datos;
	}

	public View getView(int posicion, View view, ViewGroup padre) {
		
		View fila = view;
		ItemGasolinera item = null;
		
		if (fila == null) {
			LayoutInflater inflater = ((Activity) contexto).getLayoutInflater();
			fila = inflater.inflate(layoutId, padre, false);
			
			item = new ItemGasolinera();
			item.imagen = (ImageView) fila.findViewById(R.id.imagen);
			item.nombre = (TextView) fila.findViewById(R.id.nombre);
			
			fila.setTag(item);
		}
		else {
			item = (ItemGasolinera) fila.getTag();
		}
		
		Gasolinera gasolinera = datos.get(posicion);
		item.imagen.setImageDrawable(contexto.getResources().getDrawable(R.drawable.gasolinera));
		item.nombre.setText(gasolinera.getNombre());
		
		return fila;
	}
	
	static class ItemGasolinera {
		
		ImageView imagen;
		TextView nombre;
	}
}