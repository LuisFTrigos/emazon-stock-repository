package com.example.tienda_emazon.domain.util;

public class Constants {

    private Constants(){
        //Constantes
    }

    //Generic
    public static final String INVALID_DESCRIPTION = "La descripcion es obligatoria";
    public static final String INVALID_NAME = "El Nombre es obligatorio";
    public static final String INVALID_NAME_SIZE = "El nombre debe tener más de 5 y menos de 50 caracteres";
    public static final String INVALID_DESCRIPTION_SIZE = "La descripción debe tener más de 5 y menos de 50 caracteres";

    //Category
    public static final String CATEGORY_CREATED_SUCCESSFULLY = "Se creó correctamente la categoría";
    public static final String CATEGORY_ALREADY_EXIST = "Categoria ya existente: ";
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String CATEGORY_DUPLICATED = "Duplicate categories are not allowed";
    //CategoriesName
    public static final String CATEGORY_MIN_NAME_SIZE = "El nombre de la categoría debe tener más de 6 carácteres";
    public static final String CATEGORY_MAX_NAME_SIZE = "El nombre de la categoría debe tener menos de 50 carácteres";
    public static final String NOT_NULL_CATEGORY_NAME = "El nombre de la categoría no puede estar vacío";
    public static final String CATEGORY_MIN_DESCRIPTION_SIZE = "La descripción de la categoría debe tener más de 6 carácteres";
    public static final String CATEGORY_MAX_DESCRIPTION_SIZE = "La descripción de la categoría debe tener menos de 90 carácteres";
    public static final String NOT_NULL_CATEGORY_DESCRIPTION = "La descripción de la categoría no puede estar vacía";
    //Brand
    public static final String BRAND_CREATED_SUCCESSFULLY = "Se creó correctamente la marca";
    public static final String BRAND_ALREADY_EXIST = "Marca ya existente: ";
    //BrandsName
    public static final String BRAND_MIN_NAME_SIZE = "El nombre de marca debe tener más de 6 carácteres";
    public static final String BRAND_MAX_NAME_SIZE = "El nombre de marca debe tener menos de 50 carácteres";
    public static final String NOT_NULL_BRAND_NAME = "El nombre de marca no puede estar vacío";
    public static final String BRAND_MIN_DESCRIPTION_SIZE = "La descripción de marca debe tener más de 6 carácteres";
    public static final String BRAND_MAX_DESCRIPTION_SIZE = "La descripción de marca debe tener menos de 120 carácteres";
    public static final String NOT_NULL_BRAND_DESCRIPTION = "La descripción de marca no puede estar vacía";
    //Supply
    public static final String INVALID_SUPPLY = "Al menos una categoría debe estar asociada a este articulo";
    public static final String INVALID_ASSOCIATED_CATEGORIES = "Un articulo no puede tener más de 3 categorías asociadas";
    public static final String SUPPLY_ALREADY_EXIST = "Articulo ya existente";
    public static final String SUPPLY_CREATED_SUCCESSFULLY = "Se creó correctamente el articulo";
    //SuppliesName
    public static final String SUPPLY_MIN_NAME_SIZE = "El nombre del artículo debe tener más de 5 carácteres";
    public static final String SUPPLY_MAX_NAME_SIZE = "El nombre del artículo debe tener menos de 50 carácteres";
    public static final String NOT_NULL_SUPPLY_NAME = "El nombre del artículo no puede estar vacío";
    public static final String SUPPLY_MIN_DESCRIPTION_SIZE = "La descripción del artículo debe tener más de 6 carácteres";
    public static final String SUPPLY_MAX_DESCRIPTION_SIZE = "La descripción del artículo debe tener menos de 100 carácteres";
    public static final String NOT_NULL_SUPPLY_DESCRIPTION = "La descripción del artículo no puede estar vacía";
    public static final String NOT_EMPTY_SUPPLY_AMOUNT = "El campo de la cantidad no puede estar vacío";
    public static final String NOT_EMPTY_SUPPLY_PRICE = "El campo del precio no puede estar vacío";
    //User
    public static final String ADMIN_ROLE = "ADMIN";
    public static final Long ADMIN_ROLE_ID = 1L;
    public static final String ACCESS_TOKEN_SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXvCJ9";
    public static final Long OWNER_ROLE_ID = 2L;
    public static final String AUX_ROLE = "AUX_BODEGA";

    public static final String SUPPLIED_CREATED_SUCCESSFULLY = "Se actualizó correctamente el suministro";

}
