package backend.steps

import backend.connectors.PetStoreConnector
import backend.models.PetStoreModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.javafaker.Faker
import net.serenitybdd.core.Serenity
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters
import utils.SharedStateConstants
import java.io.File
import java.io.IOException
import kotlin.random.Random


abstract class BaseSteps {

    protected val objectMapper = ObjectMapper()
    private val petStoreConnector = PetStoreConnector()
//    private val userConnector: UserConnector = UserConnector()

    val logger: Logger = LogManager.getLogger(BaseSteps::class.java)

    @Throws(IOException::class)
    fun <T> getStaticBody(tClass: Class<T>?, path: String?): T {
        return objectMapper.readValue(path?.let { File(it) }, tClass)
    }

    var random = EasyRandom(
        EasyRandomParameters()
            .seed(Random.nextLong()) //sensible string length
            .stringLengthRange(5, 50)
    )

    fun createPetStorePayload(): PetStoreModel {
        val petStoreModel = PetStoreModel()
        val faker = Faker()
        petStoreModel.id = faker.random().nextInt(0, 1000)
        petStoreModel.petId = faker.hashCode()
        petStoreModel.quantity = 4
        logger.info("Pet Store payload: " + petStoreModel.toJson())
        return petStoreModel
    }

    fun placePetStoreOrder(petStoreModel: PetStoreModel) {
        Serenity.setSessionVariable(SharedStateConstants.BACKEND.PET_STORE.PET_ORDER_ID).to<Int>(petStoreModel.id)
        petStoreConnector.placingAnOrder(petStoreModel.toJson())
        logger.info("Pet order placed.")
    }

    fun fetchPetStoreOrderDetails(orderId: Int) {
        Serenity.setSessionVariable(SharedStateConstants.BACKEND.PET_STORE.PET_STORE_RESPONSE).to(petStoreConnector.fetchOrder(orderId))
        logger.info("Order fetched: " + SharedStateConstants.BACKEND.PET_STORE.PET_STORE_RESPONSE.toString() )
    }

    fun fetchDeletedOrder(orderId: Int) {
        petStoreConnector.fetchInvalidOrder(orderId)
        logger.info("Deleted order not found.")
    }

    fun deleteOrderById(orderId: Int) {
        petStoreConnector.deleteOrderById(orderId)
        logger.info("Order deleted: $orderId")
    }


}