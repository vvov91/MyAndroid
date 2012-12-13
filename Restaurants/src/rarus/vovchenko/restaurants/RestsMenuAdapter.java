package rarus.vovchenko.restaurants;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RestsMenuAdapter extends BaseAdapter {
	Context ctx;
	LayoutInflater lInflater;
	ArrayList<Restaurant> objects;
	
	RestsMenuAdapter(Context _ctx, ArrayList<Restaurant> elements) {
		ctx = _ctx;
		objects = elements;
		lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public int getCount() {
		return objects.size();
	}

	public Object getItem(int position) {
		return objects.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = lInflater.inflate(R.layout.item_restaurants, parent, false);
		}
		
		Restaurant r = getRestaurant(position);
		
		((TextView) view.findViewById(R.id.resName)).setText(r.name);
		((ImageView) view.findViewById(R.id.resPhoto)).setImageResource(r.image);
		((TextView) view.findViewById(R.id.resAdress)).setText(r.adress);
		
		return view;
	}
	
	Restaurant getRestaurant(int position) {
		return ((Restaurant) getItem(position));
	}
}
