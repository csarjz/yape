package com.csarjz.data.datasource.remote.di

import okhttp3.CertificatePinner

object SSLPinning {

    fun  getPinnedCertificate () : CertificatePinner {
        val domain = "*.mockable.io"
        val prefix = "sha256/"
        val hashes = listOf(
            "+8kW3Dz6AzbsfNkHmIqy7xf6GZJ2MKM2FLSCkE64Bc4=",
            "WGJkyYjx1QMdMe0UqlyOKXtydPDVrk7sl2fV+nNm1r4=",
        )
        val sslPinner = CertificatePinner.Builder()
        hashes.forEach { hash ->
            sslPinner.add(domain, prefix + hash)
        }
        return sslPinner.build()
    }
}