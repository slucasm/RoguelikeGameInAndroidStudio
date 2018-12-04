package dsa.eetac.upc.edu.applicationroguelike.APIGame;

import dsa.eetac.upc.edu.applicationroguelike.models.LevelResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LevelService {

    @GET("levels")
    Call<LevelResponse> getLevels();


}
