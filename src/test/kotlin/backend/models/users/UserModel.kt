package backend.models.users

import lombok.Data
import utils.ToJson

@Data
class UserModel : ToJson {
    var id: Int? = null
    var username: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var password: String? = null
    var phone: String? = null
    var userStatus: Int? = null
}
