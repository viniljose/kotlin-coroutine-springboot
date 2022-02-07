package com.vinil.kotlin

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@SpringBootApplication
class SpringBootCoroutinesApplication {
    fun main(args: Array<String>) {
        runApplication<SpringBootCoroutinesApplication>(*args)
    }

    @Bean
    fun jsonPlaceHolderRegularClient(): JsonPlaceHolderRegularClient {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().findAndRegisterModules()))
            .build()
            .create(JsonPlaceHolderRegularClient::class.java)
    }

    @Bean
    fun jsonPlaceHolderSuspendClient(): JsonPlaceHolderSuspendClient {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().findAndRegisterModules()))
            .build()
            .create(JsonPlaceHolderSuspendClient::class.java)
    }
}
