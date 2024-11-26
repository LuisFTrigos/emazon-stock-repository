package com.example.tienda_emazon.domain.util;

import com.example.tienda_emazon.domain.exception.InvalidArgumentException;
import com.example.tienda_emazon.domain.model.CategoryInfo;
import com.example.tienda_emazon.domain.model.SupplyModel;

import java.util.List;

import static com.example.tienda_emazon.domain.util.Constants.*;

public class FieldValidations {

    private FieldValidations(){
        //Validaciones
    }

    public static void validateFieldName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidArgumentException(INVALID_NAME);
        }
        if (name.length() > 50 || name.length() < 5){
            throw new InvalidArgumentException(INVALID_NAME_SIZE);
        }
    }

    public static void validateFieldDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new InvalidArgumentException(INVALID_DESCRIPTION);
        }
        if (description.length() > 90 || description.length() < 5){
            throw new InvalidArgumentException(INVALID_DESCRIPTION_SIZE);
        }
    }

    public static void validateCategoryAssociated(SupplyModel supplyModel){
        List<CategoryInfo> associatedCategories = supplyModel.getAssociatedCategories();
        if (associatedCategories == null || associatedCategories.isEmpty()){
            throw new InvalidArgumentException(INVALID_SUPPLY);
        }
        if (associatedCategories.size() > 3){
            throw new IllegalArgumentException(INVALID_ASSOCIATED_CATEGORIES);
        }
    }
}
