package test.kotlin

import java.io.IOException
































































































class RestControllerImproved {

    fun getVehicle(
        region: String,
        environment: String,
        vin: String
    ): Vehicle {
        return handleClientResponse(getClient(region, environment)) {
            getVehicle(vin)
        }
    }

    fun postVehicle(
        region: String,
        environment: String,
        vin: String
    ): String {
        return handleClientResponse(getClient(region, environment)) {
            postVehicle(vin)
        }
    }

    fun deleteVehicle(
        region: String,
        environment: String,
        vin: String
    ): Int {
        return handleClientResponse(getClient(region, environment)) {
            deleteVehicle(vin)
        }
    }

    private fun <R : Any> handleClientResponse(
        client: Client,
        block: Client.() -> R
    ): R {
        return try {
            client.block()
        } catch (e: IOException) {
            throw IllegalStateException(e)
        } catch (e: UnsupportedOperationException) {
            throw NotImplementedError(e.toString())
        }
    }

    private fun getClient(
        region: String,
        environment: String
    ): Client {
        // maybe add some caching
        return Client(region, environment)
    }
}
