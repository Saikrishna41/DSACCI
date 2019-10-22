package team7.freshlist.demogp.requests;

import android.text.Editable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import team7.freshlist.demogp.models.CreateUsers;
import team7.freshlist.demogp.models.User;

public interface UserPost {

    @POST("api/users")
    Call<CreateUsers> postuserData(
            @Body
            CreateUsers user

    );

}
