package viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptocomplete.R;

public class tripsViewHolder extends RecyclerView.ViewHolder {
   public TextView  departTxt , destinationTxt , priceTxt , conditionTxt ;
    public tripsViewHolder(@NonNull View itemView) {
        super(itemView);
        conditionTxt = itemView.findViewById(R.id.conditionTxt);
        destinationTxt = itemView.findViewById(R.id.destinationTxt);
        priceTxt = itemView.findViewById(R.id.priceTxt);
        departTxt = itemView.findViewById(R.id.departTxt);
    }
}
