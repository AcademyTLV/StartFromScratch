package com.android_academy.network.di

import com.android_academy.network.MoviesListResult
import com.android_academy.network.NetworkingConstants
import com.google.gson.Gson

object MockNetworkDependency {
    val movieService = object : MockMovieService {
        override fun latestMovies(year: Int, apiKey: String): MoviesListResult {
            val gson = Gson()
            return gson.fromJson(data, MoviesListResult::class.java)
        }
    }
}

interface MockMovieService {
    fun latestMovies(year: Int = 2020, apiKey: String = NetworkingConstants.apiKey): MoviesListResult
}


val data = "{\n" +
        "  \"page\": 1,\n" +
        "  \"total_results\": 10000,\n" +
        "  \"total_pages\": 500,\n" +
        "  \"results\": [\n" +
        "    {\n" +
        "      \"popularity\": 1387.376,\n" +
        "      \"vote_count\": 200,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/9HT9982bzgN5on1sLRmc1GMn6ZC.jpg\",\n" +
        "      \"id\": 671039,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/gnf4Cb2rms69QbCnGFJyqwBWsxv.jpg\",\n" +
        "      \"original_language\": \"fr\",\n" +
        "      \"original_title\": \"Bronx\",\n" +
        "      \"genre_ids\": [\n" +
        "        53,\n" +
        "        28,\n" +
        "        18,\n" +
        "        80\n" +
        "      ],\n" +
        "      \"title\": \"Rogue City\",\n" +
        "      \"vote_average\": 6.1,\n" +
        "      \"overview\": \"Caught in the crosshairs of police corruption and Marseille’s warring gangs, a loyal cop must protect his squad by taking matters into his own hands.\",\n" +
        "      \"release_date\": \"2020-10-30\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 1345.086,\n" +
        "      \"vote_count\": 151,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg\",\n" +
        "      \"id\": 724989,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/86L8wqGMDbwURPni2t7FQ0nDjsH.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Hard Kill\",\n" +
        "      \"genre_ids\": [\n" +
        "        28,\n" +
        "        53\n" +
        "      ],\n" +
        "      \"title\": \"Hard Kill\",\n" +
        "      \"vote_average\": 5,\n" +
        "      \"overview\": \"The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it.\",\n" +
        "      \"release_date\": \"2020-10-23\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 1377.738,\n" +
        "      \"vote_count\": 1395,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/jlJ8nDhMhCYJuzOw3f52CP1W8MW.jpg\",\n" +
        "      \"id\": 400160,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/wu1uilmhM4TdluKi2ytfz8gidHf.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"The SpongeBob Movie: Sponge on the Run\",\n" +
        "      \"genre_ids\": [\n" +
        "        14,\n" +
        "        16,\n" +
        "        12,\n" +
        "        35,\n" +
        "        10751\n" +
        "      ],\n" +
        "      \"title\": \"The SpongeBob Movie: Sponge on the Run\",\n" +
        "      \"vote_average\": 8.1,\n" +
        "      \"overview\": \"When his best friend Gary is suddenly snatched away, SpongeBob takes Patrick on a madcap mission far beyond Bikini Bottom to save their pink-shelled pal.\",\n" +
        "      \"release_date\": \"2020-08-14\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 1377.176,\n" +
        "      \"vote_count\": 338,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/7D430eqZj8y3oVkLFfsWXGRcpEG.jpg\",\n" +
        "      \"id\": 528085,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/5UkzNSOK561c2QRy2Zr4AkADzLT.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"2067\",\n" +
        "      \"genre_ids\": [\n" +
        "        878,\n" +
        "        53,\n" +
        "        18\n" +
        "      ],\n" +
        "      \"title\": \"2067\",\n" +
        "      \"vote_average\": 4.7,\n" +
        "      \"overview\": \"A lowly utility worker is called to the future by a mysterious radio signal, he must leave his dying wife to embark on a journey that will force him to face his deepest fears in an attempt to change the fabric of reality and save humankind from its greatest environmental crisis yet.\",\n" +
        "      \"release_date\": \"2020-10-01\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 1108.384,\n" +
        "      \"vote_count\": 709,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/betExZlgK0l7CZ9CsCBVcwO1OjL.jpg\",\n" +
        "      \"id\": 531219,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/8rIoyM6zYXJNjzGseT3MRusMPWl.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Roald Dahl's The Witches\",\n" +
        "      \"genre_ids\": [\n" +
        "        14,\n" +
        "        10751,\n" +
        "        12,\n" +
        "        35,\n" +
        "        27\n" +
        "      ],\n" +
        "      \"title\": \"Roald Dahl's The Witches\",\n" +
        "      \"vote_average\": 6.9,\n" +
        "      \"overview\": \"In late 1967, a young orphaned boy goes to live with his loving grandma in the rural Alabama town of Demopolis. As the boy and his grandmother encounter some deceptively glamorous but thoroughly diabolical witches, she wisely whisks him away to a seaside resort. Regrettably, they arrive at precisely the same time that the world's Grand High Witch has gathered.\",\n" +
        "      \"release_date\": \"2020-10-26\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 851.543,\n" +
        "      \"vote_count\": 157,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/elZ6JCzSEvFOq4gNjNeZsnRFsvj.jpg\",\n" +
        "      \"id\": 741067,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/mc48QVtMhohMFrHGca8OHTB6C2B.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Welcome to Sudden Death\",\n" +
        "      \"genre_ids\": [\n" +
        "        28,\n" +
        "        53,\n" +
        "        12,\n" +
        "        18\n" +
        "      ],\n" +
        "      \"title\": \"Welcome to Sudden Death\",\n" +
        "      \"vote_average\": 6.3,\n" +
        "      \"overview\": \"Jesse Freeman is a former special forces officer and explosives expert now working a regular job as a security guard in a state-of-the-art basketball arena. Trouble erupts when a tech-savvy cadre of terrorists kidnap the team's owner and Jesse's daughter during opening night. Facing a ticking clock and impossible odds, it's up to Jesse to not only save them but also a full house of fans in this highly charged action thriller.\",\n" +
        "      \"release_date\": \"2020-09-29\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 810.348,\n" +
        "      \"vote_count\": 1874,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/kiX7UYfOpYrMFSAGbI6j1pFkLzQ.jpg\",\n" +
        "      \"id\": 613504,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/6hgItrYQEG33y0I7yP2SRl2ei4w.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"After We Collided\",\n" +
        "      \"genre_ids\": [\n" +
        "        10749,\n" +
        "        18\n" +
        "      ],\n" +
        "      \"title\": \"After We Collided\",\n" +
        "      \"vote_average\": 7.3,\n" +
        "      \"overview\": \"Tessa finds herself struggling with her complicated relationship with Hardin; she faces a dilemma that could change their lives forever.\",\n" +
        "      \"release_date\": \"2020-09-02\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 788.325,\n" +
        "      \"vote_count\": 2618,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/riYInlsq2kf1AWoGm80JQW5dLKp.jpg\",\n" +
        "      \"id\": 497582,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/kMe4TKMDNXTKptQPAdOF0oZHq3V.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Enola Holmes\",\n" +
        "      \"genre_ids\": [\n" +
        "        80,\n" +
        "        18,\n" +
        "        9648\n" +
        "      ],\n" +
        "      \"title\": \"Enola Holmes\",\n" +
        "      \"vote_average\": 7.5,\n" +
        "      \"overview\": \"While searching for her missing mother, intrepid teen Enola Holmes uses her sleuthing skills to outsmart big brother Sherlock and help a runaway lord.\",\n" +
        "      \"release_date\": \"2020-09-23\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 779.884,\n" +
        "      \"vote_count\": 720,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/xZNw9xxtwbEf25NYoz52KdbXHPM.jpg\",\n" +
        "      \"id\": 340102,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/eCIvqa3QVCx6H09bdeOS8Al2Sqy.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"The New Mutants\",\n" +
        "      \"genre_ids\": [\n" +
        "        28,\n" +
        "        878,\n" +
        "        27,\n" +
        "        12\n" +
        "      ],\n" +
        "      \"title\": \"The New Mutants\",\n" +
        "      \"vote_average\": 6.3,\n" +
        "      \"overview\": \"Five young mutants, just discovering their abilities while held in a secret facility against their will, fight to escape their past sins and save themselves.\",\n" +
        "      \"release_date\": \"2020-08-26\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 728.013,\n" +
        "      \"vote_count\": 2915,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg\",\n" +
        "      \"id\": 337401,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/zzWGRw277MNoCs3zhyG3YmYQsXv.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Mulan\",\n" +
        "      \"genre_ids\": [\n" +
        "        28,\n" +
        "        12,\n" +
        "        18,\n" +
        "        14\n" +
        "      ],\n" +
        "      \"title\": \"Mulan\",\n" +
        "      \"vote_average\": 7.2,\n" +
        "      \"overview\": \"When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.\",\n" +
        "      \"release_date\": \"2020-09-04\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 752.452,\n" +
        "      \"vote_count\": 151,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/hddzYJtfYYeMDOQVcH58n8m1W3A.jpg\",\n" +
        "      \"id\": 741074,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/DA7gzvlBoxMNL0XmGgTZOyv67P.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Once Upon a Snowman\",\n" +
        "      \"genre_ids\": [\n" +
        "        16,\n" +
        "        10751,\n" +
        "        35,\n" +
        "        14\n" +
        "      ],\n" +
        "      \"title\": \"Once Upon a Snowman\",\n" +
        "      \"vote_average\": 7,\n" +
        "      \"overview\": \"The previously untold origins of Olaf, the innocent and insightful, summer-loving snowman are revealed as we follow Olaf’s first steps as he comes to life and searches for his identity in the snowy mountains outside Arendelle.\",\n" +
        "      \"release_date\": \"2020-10-23\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 600.043,\n" +
        "      \"vote_count\": 64,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/k8Q9ulyRE8fkvZMkAM9LPYMKctb.jpg\",\n" +
        "      \"id\": 618353,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/kU7ZiyeUwcpTkYj3UcxSqGdZmxY.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Batman: Death in the Family\",\n" +
        "      \"genre_ids\": [\n" +
        "        16,\n" +
        "        28\n" +
        "      ],\n" +
        "      \"title\": \"Batman: Death in the Family\",\n" +
        "      \"vote_average\": 7.9,\n" +
        "      \"overview\": \"Tragedy strikes the Batman's life again when Robin Jason Todd tracks down his birth mother only to run afoul of the Joker. An adaptation of the 1988 comic book storyline of the same name.\",\n" +
        "      \"release_date\": \"2020-10-13\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 612.08,\n" +
        "      \"vote_count\": 70,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg\",\n" +
        "      \"id\": 635302,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/d1sVANghKKMZNvqjW0V6y1ejvV9.jpg\",\n" +
        "      \"original_language\": \"ja\",\n" +
        "      \"original_title\": \"劇場版「鬼滅の刃」無限列車編\",\n" +
        "      \"genre_ids\": [\n" +
        "        16,\n" +
        "        28,\n" +
        "        36,\n" +
        "        12,\n" +
        "        14,\n" +
        "        18\n" +
        "      ],\n" +
        "      \"title\": \"Demon Slayer: Kimetsu no Yaiba - The Movie: Mugen Train\",\n" +
        "      \"vote_average\": 6.2,\n" +
        "      \"overview\": \"Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!\",\n" +
        "      \"release_date\": \"2020-10-16\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 639.243,\n" +
        "      \"vote_count\": 39,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/e98dJUitAoKLwmzjQ0Yxp1VQrnU.jpg\",\n" +
        "      \"id\": 571384,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/5HahZPsGGaDgnFb68J49ZwdwU0b.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Come Play\",\n" +
        "      \"genre_ids\": [\n" +
        "        27\n" +
        "      ],\n" +
        "      \"title\": \"Come Play\",\n" +
        "      \"vote_average\": 6.6,\n" +
        "      \"overview\": \"A lonely young boy feels different from everyone else. Desperate for a friend, he seeks solace and refuge in his ever-present cell phone and tablet. When a mysterious creature uses the boy’s devices against him to break into our world, his parents must fight to save their son from the monster beyond the screen.\",\n" +
        "      \"release_date\": \"2020-10-28\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 567.466,\n" +
        "      \"vote_count\": 12,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/AnVD7Gn14uOTQhcc5xYZGQ9DRvS.jpg\",\n" +
        "      \"id\": 624779,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/h5sUE9jqoYrjsFjANJXL0gpZGye.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"VFW\",\n" +
        "      \"genre_ids\": [\n" +
        "        28,\n" +
        "        53,\n" +
        "        27\n" +
        "      ],\n" +
        "      \"title\": \"VFW\",\n" +
        "      \"vote_average\": 4.9,\n" +
        "      \"overview\": \"A typical night for veterans at a VFW turns into an all-out battle for survival when a desperate teen runs into the bar with a bag of stolen drugs. When a gang of violent punks come looking for her, the vets use every weapon at their disposal to protect the girl and themselves from an unrelenting attack.\",\n" +
        "      \"release_date\": \"2020-10-14\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 566.62,\n" +
        "      \"vote_count\": 627,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg\",\n" +
        "      \"id\": 539885,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/54yOImQgj8i85u9hxxnaIQBRUuo.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Ava\",\n" +
        "      \"genre_ids\": [\n" +
        "        28,\n" +
        "        80,\n" +
        "        18,\n" +
        "        53\n" +
        "      ],\n" +
        "      \"title\": \"Ava\",\n" +
        "      \"vote_average\": 5.7,\n" +
        "      \"overview\": \"A black ops assassin is forced to fight for her own survival after a job goes dangerously wrong.\",\n" +
        "      \"release_date\": \"2020-07-02\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 542.264,\n" +
        "      \"vote_count\": 189,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/6CoRTJTmijhBLJTUNoVSUNxZMEI.jpg\",\n" +
        "      \"id\": 694919,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/pq0JSpwyT2URytdFG0euztQPAyR.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Money Plane\",\n" +
        "      \"genre_ids\": [\n" +
        "        28\n" +
        "      ],\n" +
        "      \"title\": \"Money Plane\",\n" +
        "      \"vote_average\": 5.9,\n" +
        "      \"overview\": \"A professional thief with \$40 million in debt and his family's life on the line must commit one final heist - rob a futuristic airborne casino filled with the world's most dangerous criminals.\",\n" +
        "      \"release_date\": \"2020-09-29\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 601.785,\n" +
        "      \"vote_count\": 419,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/lQfdytwN7eh0tXWjIiMceFdBBvD.jpg\",\n" +
        "      \"id\": 560050,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/htBUhLSS7FfHtydgYxUWjL3J1Q1.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Over the Moon\",\n" +
        "      \"genre_ids\": [\n" +
        "        16,\n" +
        "        12,\n" +
        "        10751,\n" +
        "        14\n" +
        "      ],\n" +
        "      \"title\": \"Over the Moon\",\n" +
        "      \"vote_average\": 7.6,\n" +
        "      \"overview\": \"A girl builds a rocket to travel to the moon in hopes of meeting the legendary Moon Goddess.\",\n" +
        "      \"release_date\": \"2020-10-16\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 565.09,\n" +
        "      \"vote_count\": 774,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/sy6DvAu72kjoseZEjocnm2ZZ09i.jpg\",\n" +
        "      \"id\": 581392,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/gEjNlhZhyHeto6Fy5wWy5Uk3A9D.jpg\",\n" +
        "      \"original_language\": \"ko\",\n" +
        "      \"original_title\": \"반도\",\n" +
        "      \"genre_ids\": [\n" +
        "        28,\n" +
        "        27,\n" +
        "        53\n" +
        "      ],\n" +
        "      \"title\": \"Peninsula\",\n" +
        "      \"vote_average\": 7,\n" +
        "      \"overview\": \"A soldier and his team battle hordes of post-apocalyptic zombies in the wastelands of the Korean Peninsula.\",\n" +
        "      \"release_date\": \"2020-07-15\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"popularity\": 532.874,\n" +
        "      \"vote_count\": 910,\n" +
        "      \"video\": false,\n" +
        "      \"poster_path\": \"\\/6agKYU5IQFpuDyUYPu39w7UCRrJ.jpg\",\n" +
        "      \"id\": 740985,\n" +
        "      \"adult\": false,\n" +
        "      \"backdrop_path\": \"\\/hbrXbVoE0NuA1ORoSGGYNASagrl.jpg\",\n" +
        "      \"original_language\": \"en\",\n" +
        "      \"original_title\": \"Borat Subsequent Moviefilm\",\n" +
        "      \"genre_ids\": [\n" +
        "        35\n" +
        "      ],\n" +
        "      \"title\": \"Borat Subsequent Moviefilm\",\n" +
        "      \"vote_average\": 6.6,\n" +
        "      \"overview\": \"14 years after making a film about his journey across the USA, Borat risks life and limb when he returns to the United States with his young daughter, and reveals more about the culture, the COVID-19 pandemic, and the political elections.\",\n" +
        "      \"release_date\": \"2020-10-23\"\n" +
        "    }\n" +
        "  ]\n" +
        "}"