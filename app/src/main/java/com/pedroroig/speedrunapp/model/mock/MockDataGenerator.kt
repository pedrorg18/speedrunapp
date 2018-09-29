package com.pedroroig.speedrunapp.model.mock

import com.pedroroig.speedrunapp.model.entity.GameModel

    fun mockGame1() =
            GameModel("ID1","Super Mario Bros",
                    "https://www.speedrun.com/themes/SkyRoads/cover-128.png")

    fun mockGame2() =
            GameModel("ID2", "Sonic",
                    "https://www.speedrun.com/themes/lb/cover-128.png")

    fun mockGame3() =
            GameModel("ID3", "Ghosts 'n Goblins",
                    "https://www.speedrun.com/themes/snake_vs_block/cover-128.png")
