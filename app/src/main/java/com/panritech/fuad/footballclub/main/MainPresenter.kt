package com.panritech.fuad.footballclub.main

import com.google.gson.Gson
import com.panritech.fuad.footballclub.model.TeamResponse
import com.panritech.fuad.footballclub.api.ApiRepository
import com.panritech.fuad.footballclub.api.TheSportDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }

}