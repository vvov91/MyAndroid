package rarus.vovchenko.restaurants;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
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
		
		((TextView) view.findViewById(R.id.dishName)).setText(d.name);
		((TextView) view.findViewById(R.id.dishPrice)).setText(d.price);
		CheckBox dishCB = (CheckBox) view.findViewById(R.id.dishCB);
		
		dishCB.setOnCheckedChangeListener(dishCheckListener);
		dishCB.setTag(position);
		
		return view;
	}
	
	Dish getDish(int position) {
		return ((Dish) getItem(position));
	}
	
	OnCheckedChangeListener dishCheckListener = new OnCheckedChangeListener() {
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			
		}
	};
}