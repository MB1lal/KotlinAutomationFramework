package backend.models.store

import lombok.Data
import utils.TimestampGenerator
import utils.ToJson

@Data
class PetStoreModel : ToJson {
    var id = 0
    var petId = 0
    var quantity = 0
    var shipDate: String = TimestampGenerator().randomValue
    var status = "placed"
    var complete = true
}