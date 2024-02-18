package com.test.data.home

import com.test.core.network.Mapper
import com.test.data.model.movie.ProductionCountry

class ProductionCountryMapper :
    Mapper<ProductionCountry, com.test.domain.model.movie.ProductionCountry> {
    override fun to(t: ProductionCountry): com.test.domain.model.movie.ProductionCountry {
        return com.test.domain.model.movie.ProductionCountry(
            iso_3166_1 = t.iso31661,
            name = t.name
        )
    }
}