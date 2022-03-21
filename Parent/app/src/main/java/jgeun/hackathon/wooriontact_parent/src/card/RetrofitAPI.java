package jgeun.hackathon.wooriontact_parent.src.card;

import jgeun.hackathon.wooriontact_parent.src.card.models.AccountRequest;
import jgeun.hackathon.wooriontact_parent.src.card.models.AccountResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("oai/wb/v1/finance/getIndivAllAccInfo")
    Call<AccountResponse> postAllAccount(@Body AccountRequest accountRequest); //이건 바디 요청시 사용하는거
}