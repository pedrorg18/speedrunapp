package com.pedroroig.speedrunapp.data.network.entity

data class Pagination(
        val offset: Int,
        val max: Int,
        val size: Int,
        val links: List<Link>
)

data class Link(
        val rel: String?,
        val uri: String
)

data class Names(
        val international: String
)