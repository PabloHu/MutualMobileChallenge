package mobile.huaman.mutualmobile.view.MutualMobileActivity;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mobile.huaman.mutualmobile.model.modelrecipeapi.Recipe;
import mobile.huaman.mutualmobile.model.modelrecipeapi.RecipeResponse;
import mobile.huaman.mutualmobile.remote.ApiProvider;



/**
 * Created by Pablo on 11/28/2017.
 */

public class MutualMobilePresenter implements MutualMobileContract.Presenter {
    private static final String TAG = "PresenterTag";
    MutualMobileContract.View view;
    @Override
    public void attachView(MutualMobileContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {this.view = null;

    }

    @Override
    public void getRecipeList(String recipeSearch) {

        //create an observable that will emit the response from the network call
        Observable<RecipeResponse> responseObservable = ApiProvider.getRecipeResponse(recipeSearch);

        //create an observer that is going to read the emitted values
        Observer<RecipeResponse> responseObserver = new Observer<RecipeResponse>() {
            String address;

            List<Recipe> recipeList = new ArrayList<>();
         //   Recipe recipe = new Recipe();
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(RecipeResponse recipeResponse) {


                for (int i = 0; i < recipeResponse.getHits().size(); i++) {
                    recipeList.add(recipeResponse.getHits().get(i).getRecipe());
                    /*
                    Log.d(TAG, "onNext: "+recipeResponse.getHits().get(i).getRecipe().getLabel());
                    Log.d(TAG, "onNext: "+recipeResponse.getHits().get(i).getRecipe().getSource());
                    Log.d(TAG, "onNext: " +recipeResponse.getHits().get(i).getRecipe().getImage());
                    for (int j = 0; j < recipeResponse.getHits().get(i).getRecipe().getIngredients().size(); j++) {
                        Log.d(TAG, "onNext: " +recipeResponse.getHits().get(i).getRecipe().getIngredients().get(j).getText());
                    }
*/

                }

            }


            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e.toString());

            }

            @Override
            public void onComplete() {
             //   Log.d(TAG, "onComplete: "+recipeList.size());
                view.updateRecipeList(recipeList);

               // view.updateTest("hello");

            }
        };

        //subscribe the oberver to the observable
        responseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseObserver);
        responseObservable.unsubscribeOn(Schedulers.io());

    }
}
