package com.test.data.movie

import com.test.core.extension.mapTo
import com.test.core.network.Mapper
import com.test.data.home.GenreMapper
import com.test.data.home.ProductionCompaniesMapper
import com.test.data.home.ProductionCountryMapper
import com.test.data.home.SpokenLanguageMapper
import com.test.data.model.movie.DetailMovieDataResponse
import com.test.domain.model.movie.BelongsToCollection
import com.test.domain.model.movie.DetailMovieData

class DetailMovieMapper(
    private val productionCompaniesMapper: ProductionCompaniesMapper,
    private val productionCountryMapper: ProductionCountryMapper,
    private val spokenLanguageMapper: SpokenLanguageMapper,
    private val genreMapper: GenreMapper
) : Mapper<DetailMovieDataResponse, DetailMovieData> {
    override fun to(t: DetailMovieDataResponse): DetailMovieData {
        return DetailMovieData(
            poster_path = t.posterPath,
            id = t.id,
            overview = t.overview,
            video = t.video,
            backdrop_path = t.backdropPath,
            release_date = t.releaseDate,
            popularity = t.popularity,
            belongs_to_collection = BelongsToCollection(
                backdrop_path = t.belongsToCollection?.backdropPath,
                poster_path = t.belongsToCollection?.posterPath,
                id = t.belongsToCollection?.id,
                name = t.belongsToCollection?.name
            ),
            genres = t.genres?.map { it.mapTo(genreMapper) },
            production_companies = t.productionCompanies?.map { it.mapTo(productionCompaniesMapper) },
            production_countries = t.productionCountries?.map { it.mapTo(productionCountryMapper) },
            spoken_languages = t.spokenLanguages?.map { it.mapTo(spokenLanguageMapper) },
            title = t.title,
            adult = t.adult,
            original_language = t.originalLanguage,
            status = t.status,
            vote_average = t.voteAverage,
            vote_count = t.voteCount
        )
    }
}