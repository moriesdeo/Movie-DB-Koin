package com.test.data.home

import com.test.core.network.Mapper
import com.test.data.model.movie.SpokenLanguage

class SpokenLanguageMapper : Mapper<SpokenLanguage, com.test.domain.model.movie.SpokenLanguage> {
    override fun to(t: SpokenLanguage): com.test.domain.model.movie.SpokenLanguage {
        return com.test.domain.model.movie.SpokenLanguage(
            name = t.name,
            english_name = t.englishName
        )
    }
}