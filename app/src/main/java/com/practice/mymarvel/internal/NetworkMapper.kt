package com.practice.mymarvel.internal

interface NetworkMapper<NetworkResponse, Domain> {
    fun toDomain(networkResponse: NetworkResponse): Domain
    fun toDomainList(networkResponseList: List<NetworkResponse>): List<Domain>
}
