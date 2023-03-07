package test.kotlin

import java.io.IOException

/*
 * Refactor the following controller to make it more concise.
 */

object RestController {

    fun getVehicle(
        region: String,
        environment: String,
        vin: String
    ): Vehicle {
        val client = getClient(region, environment)
        return try {
            client.getVehicle(vin)
        } catch (e: IOException) {
            throw IllegalStateException(e)
        } catch (e: UnsupportedOperationException) {
            throw NotImplementedError(e.toString())
        }
    }

    fun postVehicle(
        region: String,
        environment: String,
        vin: String
    ): String {
        val client = getClient(region, environment)
        return try {
            client.postVehicle(vin)
        } catch (e: IOException) {
            throw IllegalStateException(e)
        } catch (e: UnsupportedOperationException) {
            throw NotImplementedError(e.toString())
        }
    }

    fun deleteVehicle(
        region: String,
        environment: String,
        vin: String
    ): Int {
        val client = getClient(region, environment)
        return try {
            client.deleteVehicle(vin)
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

class Client(val region: String, val environment: String) {
    fun getVehicle(vin: String): Vehicle {
        return Vehicle()
    }

    fun postVehicle(vin: String): String {
        return "OK"
    }

    fun deleteVehicle(vin: String): Int {
        return 1
    }
}

class Vehicle
