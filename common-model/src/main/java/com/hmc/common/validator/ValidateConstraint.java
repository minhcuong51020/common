package com.hmc.common.validator;

public interface ValidateConstraint {

    interface LENGTH {
        int CODE_MAX_LENGTH = 50;
        int NAME_MAX_LENGTH = 100;
        int TITLE_MAX_LENGTH = 200;
        int DESC_MAX_LENGTH = 1000;
        int NOTE_MAX_LENGTH = 1000;
        int ENUM_MAX_LENGTH = 20;
        int ID_MIN_LENGTH = 1;
        int ID_MAX_LENGTH = 36;
        int PASSWORD_MIN_LENGTH = 3;
        int PASSWORD_MAX_LENGTH = 20;
        int CONTENT_MAX_LENGTH = 2000;
        int VALUE_MAX_LENGTH = 200;
        int PHONE_MAX_LENGTH = 20;
        int EMAIL_MAX_LENGTH = 50;
        int ADDRESS_MAX_LENGTH = 200;
        int MENU_MAX_LENGTH = 1000;
        int DISH_NAME_MAX_LENGTH = 200;
        int PRODUCT_NAME_MAX_LENGTH = 200;
        int BANK_NUMBER_MAX_LENGTH = 30;
        int SERIAL_NUMBER_MAX_LENGTH = 30;
        int BANK_NAME_MAX_LENGTH = 50;
        int QUANTITY_NUMBER_MIN_LENGTH = 1;
        int BOOK_NAME_MAX_LENGTH=200;
        int LANGUAGE_MAX_LENGTH=50;
        int SIZE_MAX_LENGTH=50;
        int PUBLISHING_COMPANY_MAX_LENGTH=100;
        int NATIONALITY_MAX_LENGTH = 50;
        int DIMENSION_MAX_LENGTH = 50;
        int TOTAL_PAGE_MAX_LENGTH = 50;
        int ISBN_MAX_LENGTH = 13;
        int RATING_MAX_LENGTH = 50;
        int ITEM_WEIGHT_MAX_LENGTH = 50;
        int BOOK_TYPE = 50;
        int TYPE_FILE_MAX_LENGTH=50;
        int LINK_MAX_LENGTH=50;

    }

    interface VALUE {
        int FLOOR_NUMBER_MAX = 200;
    }

    interface FORMAT {
        String PHONE_NUMBER_PATTERN = "^(\\+[0-9]+[\\- \\.]*)?(\\([0-9]+\\)[\\- \\.]*)?([0-9][0-9\\- \\.]+[0-9])$";
        String MULTI_PHONE_NUMBER_PATTERN = "(\\+[0-9]+[\\- \\.]*)?(\\([0-9]+\\)[\\- \\.]*)?([0-9][0-9\\- \\.]+[0-9])$";
        String EMAIL_PATTERN = "^(\\s){0,}[a-zA-Z][a-zA-Z0-9-_\\.]{1,50}@[a-zA-Z0-9_-]{2,}(\\.[a-zA-Z0-9]{2,4}){1,2}(\\s){0,}$";
        String CODE_PATTERN = "^[A-Za-z0-9_.]{4,50}$";
    }
}
