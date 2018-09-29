package com.pedroroig.speedrunapp.model.mock

import com.pedroroig.speedrunapp.model.entity.GameModel

    fun mockGame1() =
            GameModel("ID1","Super Mario Bros",
                    "https://www.google.es/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png")

    fun mockGame2() =
            GameModel("ID2", "Sonic",
                    "https://www.google.es/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png")

    fun mockGame3() =
            GameModel("ID3", "Ghosts 'n Goblins",
                    "https://www.google.es/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png")
