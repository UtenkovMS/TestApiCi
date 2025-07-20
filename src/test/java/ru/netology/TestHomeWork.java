package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class TestHomeWork {

    @Test

    void shouldReturnAccounts() {

        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1/")
                // Выполняемые действия
        .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                .header("content-type", "application/json; charset=UTF-8")
                .body("", hasSize(3)) //hasSize - метод указывающий размер массива
                .body("[0].id", equalTo(1)) // [0] - порядковый номер индекса элемента (объекта) массива,
                                                        // .id - свойство объекта,
                                                        // equalTo() - указывается значение, свойства объекта id, равное 1
                .body("[0].currency", equalTo("RUB"))
                .body("[1].balance", greaterThan(0)) // Метод greaterThan() сравнивает больше ли наше значение нуля.
                .body(matchesJsonSchemaInClasspath("accounts.schema.json")); // Данный метод проверяет соответствует ли ответ сервера схеме Json





    }

}
