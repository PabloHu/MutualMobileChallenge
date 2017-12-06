package mobile.huaman.mutualmobile.view.MutualMobileActivity;

import java.util.List;

import mobile.huaman.mutualmobile.model.modelrecipeapi.Recipe;
import mobile.huaman.mutualmobile.model.modelrecipeapi.RecipeResponse;
import mobile.huaman.mutualmobile.view.BasePresenter;
import mobile.huaman.mutualmobile.view.BaseView;

/**
 * Created by Pablo on 11/28/2017.
 */

public interface MutualMobileContract {
    interface View extends BaseView {
       // void updateCurrentPokeGif(String currentPokemonUrlGif);

        void updateRecipeList(List<Recipe> recipeList);


        void updateTest(String something);
    }

    interface Presenter extends BasePresenter<View> {
        void getRecipeList(String RecipeSearch);


    }
}
