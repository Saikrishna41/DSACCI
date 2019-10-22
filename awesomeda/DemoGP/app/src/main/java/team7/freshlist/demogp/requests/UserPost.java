package team7.freshlist.demogp.requests;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import team7.freshlist.demogp.models.User;
import team7.freshlist.demogp.requests.response.PostResponse;

public interface UserPost {

    @POST("api/users")
    Call<User> postuserData(
            @Body
            User user


    );
}
