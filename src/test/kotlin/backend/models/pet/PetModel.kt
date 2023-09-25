package backend.models.pet

import lombok.Data
import utils.ToJson

@Data
class PetModel : ToJson {
    var id: Long = 0
    var category: Category? = null
    var name: String? = null
    var photoUrls: ArrayList<String>? = null
    var tags: ArrayList<Tag>? = null
    var status: String? = null
}
