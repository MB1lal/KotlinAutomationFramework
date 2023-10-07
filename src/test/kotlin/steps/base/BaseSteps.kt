package steps.base

import connectors.PetConnector
import connectors.PetStoreConnector
import connectors.UserConnector
import models.pet.PetModel
import models.store.PetStoreModel
import models.users.UserModel
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.javafaker.Faker
import com.google.gson.Gson
import core.EnvSerenity
import models.DownloadedJson
import io.restassured.response.Response
import net.serenitybdd.core.Serenity
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters
import utils.SharedStateConstants
import utils.SharedStateConstants.BACKEND
import utils.SharedStateConstants.BACKEND.PET
import utils.SharedStateConstants.BACKEND.USERS
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.random.Random


abstract class BaseSteps {

    protected val objectMapper = ObjectMapper()
    private val petStoreConnector = PetStoreConnector()
    private val userConnector = UserConnector()
    private val petConnector = PetConnector()

    protected val logger: Logger = LogManager.getLogger(BaseSteps::class.java)

    protected val downloadPath = System.getProperty("user.dir") + "/src/test-output/downloads/"

    @Throws(IOException::class)
    fun <T> getStaticBody(tClass: Class<T>?, path: String?): T {
        return objectMapper.readValue(path?.let { File(it) }, tClass)
    }

    @Suppress("unused")
    var random = EasyRandom(
        EasyRandomParameters()
            .seed(Random.nextLong()) //sensible string length
            .stringLengthRange(5, 50)
    )

    @Throws(IOException::class)
    fun createPetPayloadUsingFile(): PetModel {
        return getStaticBody(
            PetModel::class.java, EnvSerenity().petFileBodiesRoot + "new-pet.json"
        )
    }

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
        logger.info("Order fetched: $orderId")
    }

    fun fetchDeletedOrder(orderId: Int) {
        petStoreConnector.fetchInvalidOrder(orderId)
        logger.info("Deleted order not found.")
    }

    fun deleteOrderById(orderId: Int) {
        petStoreConnector.deleteOrderById(orderId)
        logger.info("Order deleted: $orderId")
    }


    fun addANewPet(petModel: PetModel) {
        Serenity.setSessionVariable(BACKEND.PET_ID).to(petModel.id)
        Serenity.setSessionVariable(PET.PET_STATUS).to(petModel.status)
        petConnector.addNewPet(petModel.toJson())
        logger.info("Adding new pet.")
    }

    fun getPetById(petId: Long) {
        Serenity.setSessionVariable(PET.PET_RESPONSE).to(
            petConnector.getPetById(petId.toInt())
        )
        logger.info("Fetched pet: " + petId)
    }

    fun getPetStatus(status: List<String?>?) {
        Serenity.setSessionVariable(PET.PET_RESPONSE).to<Response>(
            petConnector.getPetStatus(status)
        )
        logger.info("Fetched pet status")
    }

    fun deletePetWithId(petId: Long) {
        petConnector.deletePetWithId(petId.toInt())
        logger.info("Pet deleted: $petId")
    }

    fun updatePetDetails(attribute: String?, attributeValue: String?) {
        petConnector.updatePetDetails(attribute, attributeValue)
        logger.info("Pet details updated")
    }

    fun createUserPayLoad(): UserModel {
        val userModel = UserModel()
        val faker = Faker()
        userModel.id = faker.hashCode()
        userModel.username = faker.name().username()
        userModel.firstName = faker.name().firstName()
        userModel.lastName = faker.name().lastName()
        userModel.email = faker.internet().emailAddress()
        userModel.password = faker.internet().password()
        userModel.phone = faker.phoneNumber().cellPhone()
        userModel.userStatus = faker.random().nextInt(3)
        Serenity.setSessionVariable(USERS.USERNAME).to(userModel.username)
        Serenity.setSessionVariable(USERS.PASSWORD).to(userModel.password)
        Serenity.setSessionVariable(USERS.EMAIL).to(userModel.email)
        Serenity.setSessionVariable(USERS.PHONE).to(userModel.phone)
        Serenity.setSessionVariable(USERS.FIRST_NAME).to(userModel.firstName)
        Serenity.setSessionVariable(USERS.LAST_NAME).to(userModel.lastName)
        Serenity.setSessionVariable(USERS.STATUS).to(userModel.userStatus)
        Serenity.setSessionVariable(USERS.USER_ID).to(userModel.id)
        logger.info("User payload created.")
        return userModel
    }

    fun verifyUserExists() {
        Serenity.setSessionVariable(USERS.USER_RESPONSE).to(
            userConnector.getUser(Serenity.sessionVariableCalled(USERS.USERNAME))
        )
        logger.info("Verified user exists.")
    }

    fun loginUser() {
        logger.info("User is logging in.")
        Serenity.setSessionVariable(USERS.USER_RESPONSE).to(
            userConnector.loginExistingUser(
                Serenity.sessionVariableCalled(USERS.USERNAME),
                Serenity.sessionVariableCalled(USERS.PASSWORD)
            )
        )
        logger.info("User is logged in.")
    }

    fun logoutUser() {
        userConnector.logoutUser()
        logger.info("User is logged out.")
    }

    fun deleteDownloadsFolder(path: String = downloadPath) {
        val folder = File(path)

        if (folder.exists()) {
            if (folder.isDirectory) {
                // Delete all files and subdirectories in the folder
                folder.listFiles()?.forEach { file ->
                    if (file.isDirectory) {
                        deleteDownloadsFolder(file.absolutePath)
                    } else {
                        file.delete()
                    }
                }
            }

            // Delete the empty folder
            folder.delete()
            println("Folder deleted successfully.")
        } else {
            println("Folder does not exist.")
        }
    }

    protected fun readJsonFile(filePath: String): String? {
        return try {
            String(Files.readAllBytes(Paths.get(filePath)))
        } catch (e: Exception) {
            null
        }
    }

    protected fun parseJson(jsonString: String): DownloadedJson {
        return Gson().fromJson(jsonString, DownloadedJson::class.java)
    }

}