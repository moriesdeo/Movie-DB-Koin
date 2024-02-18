package com.test.domain.model.movie

data class DetailMovieData(
    var adult: Boolean? = null,
    var backdrop_path: String? = null,
    var belongs_to_collection: Any? = null,
    var budget: Int? = null,
    var genres: List<Genre?>? = null,
    var homepage: String? = null,
    var id: Int? = null,
    var imdb_id: String? = null,
    var original_language: String? = null,
    var original_title: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var poster_path: String? = null,
    var production_companies: List<ProductionCompany?>? = null,
    var production_countries: List<ProductionCountry?>? = null,
    var release_date: String? = null,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var spoken_languages: List<SpokenLanguage?>? = null,
    var status: String? = null,
    var tagline: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    var vote_average: Double? = null,
    var vote_count: Int? = null
)