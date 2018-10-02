package com.pedroroig.speedrunapp.data.network.entity

data class GameRunListNetworkEntity(
    val data: List<Data>,
    val pagination: Pagination
)

data class Data(
    val id: String,
    val weblink: String,
    val game: String,
    val level: Any,
    val category: String,
    val videos: Videos,
    val comment: String,
    val players: List<Player>,
    val date: String,
    val submitted: String,
    val times: Times,
    val splits: Any,
    val links: List<Link>
)


data class Videos(
    val links: List<Link>
)


data class Times(
    val primary_t: Float
)


data class Player(
    val rel: String,
    val id: String?,
    val name: String?,
    val uri: String
)
