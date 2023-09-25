package utils

enum class SharedStateConstants {
    GENERAL;

    enum class BACKEND {
        PET_ID;

        enum class PET_STORE {
            PET_ORDER_ID,
            PET_STORE_RESPONSE
        }

        enum class PET {
            PET_RESPONSE,
            PET_STATUS
        }

        enum class USERS {
            USERNAME,
            FIRST_NAME,
            LAST_NAME,
            USER_ID,
            EMAIL,
            PASSWORD,
            STATUS,
            PHONE,
            USER_RESPONSE
        }
    }

    enum class FRONTEND {
        URL,
        RESPONSE,
        WEBDRIVER,
        EXCEL_DATA,
        LINK_TEXT,
        DRIVER_TABS,
        CAST_AND_CREW
    }
}