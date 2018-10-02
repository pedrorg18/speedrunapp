package com.pedroroig.speedrunapp.domain.mapper

import com.pedroroig.speedrunapp.data.network.entity.*
import org.junit.Test

import org.junit.Assert.*

private const val MOCK_ID_1 = "pdvp7kdw"
private const val MOCK_ID_2 = "k6qrzm1g"
private const val MOCK_ID_3 = "369k2gdl"

private const val MOCK_NAME_1 = "\\u0027Allo \\u0027Allo! Cartoon Fun!"
private const val MOCK_NAME_2 = ".hack//Infection"
private const val MOCK_NAME_3 = ".hack//Mutation"

private const val MOCK_URL_1 = "https://www.speedrun.com/themes/Allo_Allo_Cartoon_Fun/cover-128.png"
private const val MOCK_URL_2 = "https://www.speedrun.com/themes/.hackInfection/cover-128.png"
private const val MOCK_URL_3 = "https://www.speedrun.com/themes/.hackMutation/cover-128.png"

class GameNetworkToDomainMapperTest {

    @Test
    fun map() {

        val netListEntity = generateMockNetworkGameList()
        val domainEntity = GameNetworkToDomainMapper().map(netListEntity)

        with(domainEntity[0]) {
            assertEquals(MOCK_ID_1, id)
            assertEquals(MOCK_NAME_1, name)
            assertEquals(MOCK_URL_1, imageLocation)
        }
        with(domainEntity[1]) {
            assertEquals(MOCK_ID_2, id)
            assertEquals(MOCK_NAME_2, name)
            assertEquals(MOCK_URL_2, imageLocation)
        }
        with(domainEntity[2]) {
            assertEquals(MOCK_ID_3, id)
            assertEquals(MOCK_NAME_3, name)
            assertEquals(MOCK_URL_3, imageLocation)
        }

    }


    private fun generateMockNetworkGameList(): GamesListNetworkEntity {
        val idsList = listOf(MOCK_ID_1, MOCK_ID_2, MOCK_ID_3)

        val namesList = listOf(
                Names(MOCK_NAME_1, "", ""),
                Names(MOCK_NAME_2, "", ""),
                Names(MOCK_NAME_3, "", "")
        )
        val assetsList = listOf(
                Assets(emptyImage(),
                        Image(MOCK_URL_1,
                                128, 164),
                        emptyImage(), emptyImage(), null, null),
                Assets(emptyImage(),
                        Image(MOCK_URL_2,
                                128, 164),
                        emptyImage(), emptyImage(), null, null),
                Assets(emptyImage(),
                        Image(MOCK_URL_3,
                                128, 164),
                        emptyImage(), emptyImage(), null, null)
        )


        val data = ArrayList<GameNetworkEntity>()
        idsList.forEachIndexed { i, id ->
            data.add(
                    GameNetworkEntity(id,
                            namesList[i],
                            "",
                            "",
                            0,
                            "",
                            false,
                            emptyList(),
                            emptyList(),
                            emptyList(),
                            emptyList(),
                            emptyList(),
                            emptyList(),
                            "",
                            assetsList[i],
                            emptyList()
                    )

            )
        }

        return GamesListNetworkEntity(data, Pagination(0, 0, 0, emptyList()))
    }

    private fun emptyImage(): Image =
            Image("", 0, 0)
}