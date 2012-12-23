package rarus.vovchenko.restaurants;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DishesMenuAdapter extends BaseAdapter {
	Context ctx;
	LayoutInflater lInflater;
	ArrayList<Dish> objects;
	
	DishesMenuAdapter(Context _ctx, ArrayList<Dish> elements) {
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
			view = lInflater.inflate(R.layout.item_menu, parent, false);
		}
		
		Dish d = getDish(position);
		
		((TextView) view.findViewById(R.id.dishName)).setText(d.getName());
		((TextView) view.findViewById(R.id.dishPrice)).setText(d.getPrice());
		
		return view;
	}
	
	Dish getDish(int position) {
		return ((Dish) getItem(position));
	}
}