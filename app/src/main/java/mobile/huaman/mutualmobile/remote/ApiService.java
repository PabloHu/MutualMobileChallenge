package mobile.huaman.mutualmobile.remote;



import io.reactivex.Observable;
import mobile.huaman.mutualmobile.model.modelrecipeapi.RecipeResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Pablo on 11/28/2017.
 */

public interface ApiService {

   

    @GET("search?")
    Observable<RecipeResponse> getRecipeResponse(
            @Query("q") String search, @Query("app_id") String app_id, @Query("app_key") String app_key);

 
}
