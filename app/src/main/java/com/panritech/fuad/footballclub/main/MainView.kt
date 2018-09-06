package com.panritech.fuad.footballclub.main

import com.panritech.fuad.footballclub.model.Team


interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}