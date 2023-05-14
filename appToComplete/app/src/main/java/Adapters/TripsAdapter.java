package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptocomplete.R;

import java.util.ArrayList;
import classes.Trip;
import viewHolders.tripsViewHolder;
public class TripsAdapter extends RecyclerView.Adapter<tripsViewHolder> {

    ArrayList<Trip> trips ;
    Context context ;

    public TripsAdapter(ArrayList<Trip> trips, Context context) {
        this.trips = trips;
        this.context = context;
    }

    @NonNull
    @Override
    public tripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trip_item , parent , false);
        return new tripsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull tripsViewHolder holder, int position) {
        holder.conditionTxt.setText(trips.get(position).getConditions());
        holder.priceTxt.setText(String.valueOf(trips.get(position).getPrice()));
        holder.departTxt.setText(trips.get(position).getFromWhere());
        holder.destinationTxt.setText(trips.get(position).getToWhere());
    }
    @Override
    public int getItemCount() {
        return trips.size();
    }
}
