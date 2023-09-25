package core

class EnvSerenity : Config() {
    //bootstrap
    val basePetUri = environmentVariables.getProperty("baseURI") + "pet"
    val basePetStoreUri = environmentVariables.getProperty("baseURI") + "store"
    val petFileBodiesRoot = environmentVariables.getProperty("petFileBodiesRoot")
    val baseUserUri = environmentVariables.getProperty("baseURI") + "user"
}
