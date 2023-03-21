package edu.uksw.fti.pam.acitivityintent.repositorues

import edu.uksw.fti.pam.acitivityintent.models.TodosModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JSONPlaceholderTypicodeRepository {
    @GET("datapemilih")
    suspend fun getTodos(): List<TodosModel>

    companion object {
        var _apiClient: JSONPlaceholderTypicodeRepository? = null

        fun getClient(): JSONPlaceholderTypicodeRepository {
            if (_apiClient == null) {
                _apiClient = Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/JemsGunawanJingga/TTS/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(JSONPlaceholderTypicodeRepository::class.java)
            }

            return _apiClient!!
        }
    }
}