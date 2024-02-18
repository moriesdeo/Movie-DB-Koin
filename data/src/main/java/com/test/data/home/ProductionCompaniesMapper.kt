package com.test.data.home

import com.test.core.network.Mapper
import com.test.data.model.movie.ProductionCompany

class ProductionCompaniesMapper :
    Mapper<ProductionCompany, com.test.domain.model.movie.ProductionCompany> {
    override fun to(t: ProductionCompany): com.test.domain.model.movie.ProductionCompany {
        return com.test.domain.model.movie.ProductionCompany(
            id = t.id,
            name = t.name,
            logo_path = t.logoPath,
            origin_country = t.originCountry
        )
    }
}