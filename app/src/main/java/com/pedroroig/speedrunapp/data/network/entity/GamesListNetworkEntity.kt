package com.pedroroig.speedrunapp.data.network.entity

import com.google.gson.annotations.SerializedName

data class GamesListNetworkEntity(
        val data: List<GameNetworkEntity>,
        val pagination: Pagination
)

data class Pagination(
        val offset: Int,
        val max: Int,
        val size: Int,
        val links: List<Link>
)

data class Link(
        val rel: String,
        val uri: String
)

data class GameNetworkEntity(
        val id: String,
        val names: Names,
        val abbreviation: String,
        val weblink: String,
        val released: Int,
        @SerializedName("release-date")
        val releaseDate: String,
        val romhack: Boolean,
        val platforms: List<String>,
        val regions: List<String>,
        val genres: List<String>,
        val engines: List<String>,
        val developers: List<String>,
        val publishers: List<String>,
        val created: String,
        val assets: Assets,
        val links: List<Link>
)

data class Names(
        val international: String,
        val japanese: Any,
        val twitch: String
)


data class Assets(
        val logo: Image,
        @SerializedName("cover-medium")
        val coverMedium: Image,
        @SerializedName("cover-large")
        val coverLarge: Image,
        val icon: Image,
        val background: Image?,
        val foreground: Image?
)

data class Image(
        val uri: String,
        val width: Int,
        val height: Int
)


