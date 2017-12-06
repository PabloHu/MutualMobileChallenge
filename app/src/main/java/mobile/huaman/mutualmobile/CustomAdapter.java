package mobile.huaman.mutualmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import mobile.huaman.mutualmobile.model.modelrecipeapi.Recipe;
import mobile.huaman.mutualmobile.modelRecipeDisplay.ModelRecipeDisplay;
import mobile.huaman.mutualmobile.view.MutualMobileActivity.MutualMobileMainActivity;
import mobile.huaman.mutualmobile.view.MutualMobileRecipeViewActivity.MutualMobileRecipeViewActivity;

/**
 * Created by Pablo on 11/28/2017.
 */

public class CustomAdapter extends BaseAdapter {

    private static final String OBJECT_KEY = "Secret_Recipe";
    List<Recipe> recipeList;
 //   String [] result;
    Context context;
  //  int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MutualMobileMainActivity mainActivity, List<Recipe> recipeList) {
        // TODO Auto-generated constructor stub
        this.recipeList = recipeList;
     //   result=osNameList;
        context=mainActivity;
       // imageId=osImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return recipeList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
     //   TextView os_text;
        ImageView os_img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.custom_gridview, null);
        //holder.os_text =(TextView) rowView.findViewById(R.id.os_texts);
        holder.os_img =(ImageView) rowView.findViewById(R.id.os_images);

      //  holder.os_text.setText(recipeList.get(position).getLabel());
        Picasso.with(context)
                .load(recipeList.get(position).getImage())
                //.error( R.drawable.opps )
              //  .placeholder( R.drawable.ditto_incomplete )
                .into(holder.os_img);
       // holder.os_img.setImageResource(recipeList.get(position).getImage());

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
              //  Toast.makeText(context, recipeList.get(position).getLabel() , Toast.LENGTH_SHORT).show();
              //  Toast.makeText(context, recipeList.get(position).getImage() , Toast.LENGTH_SHORT).show();

                String recipeDisplay = "";
                for (int i = 0; i < recipeList.get(position).getIngredients().size(); i++) {
                    recipeDisplay += recipeList.get(position).getIngredients().get(i).getText().toString() + "\n";
                }

                ModelRecipeDisplay modelRecipeDisplay = new ModelRecipeDisplay(
                        recipeList.get(position).getLabel(),
                        recipeList.get(position).getImage(),
                        recipeDisplay,
                        recipeList.get(position).getSource(),
                        recipeList.get(position).getUrl()
                );
                Intent intent = new Intent(context, MutualMobileRecipeViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(OBJECT_KEY, modelRecipeDisplay);

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return rowView;
    }

}