package com.example.demo.payment.infrastructure.routes

import com.example.demo.payment.infrastructure.handler.CustomerHandler
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.servlet.function.router

class CustomerRoutes {
    companion object {
        fun routes(handler: CustomerHandler) = router {
            "api/v1".nest {
                "customers".nest {
                    accept(APPLICATION_JSON).nest {
                        GET("").invoke { handler.list() }
                        POST("").invoke { request -> handler.create(request) }
                    }
                }
            }
        }
    }
}

