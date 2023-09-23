package core

class EnvSerenity : Config() {
    //bootstrap
    val basePetURI = environmentVariables.getProperty("baseURI") + "pet"
    val basePetStoreURI = environmentVariables.getProperty("baseURI") + "store"
    val petFileBodiesRoot = environmentVariables.getProperty("petFileBodiesRoot")
    val userURI = environmentVariables.getProperty("baseURI") + "user"
}